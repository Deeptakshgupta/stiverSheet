package com_stacks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Given two binary trees, we have to check if each of their levels is an
 anagram of the other or not.
*/

/*
 using Hash tables during level order traversal. 
 The idea is to do a level order traversal and in each level check whether
  the level is an anagram with help of hash tables.
*/

public class levelOrderAnagramCheck {

	public static boolean areAnagrams(Node root1, Node root2) {
		// Base Cases
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.add(root1);
		q2.add(root2);

		// Hashmap to store the elements that occur at each level
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();

		while (!q1.isEmpty() && !q2.isEmpty()) {
			
			int n1 = q1.size(), n2 = q2.size();

			if (n1 != n2)
				return false;

			if (n1 == 0)
				break;

			// Traverse current level elements from Tree 1
			// while traversing them store them in hashmap with their frequency
			while (n1-- > 0) {
				Node node1 = q1.peek();
				q1.remove();

				m.put(node1.data, m.getOrDefault(node1.data, 0) + 1);

				if (node1.left != null)
					q1.add(node1.left);
				if (node1.right != null)
					q1.add(node1.right);
			}

			// Traverse Tree 2
			// while traversing reduce frequency of elements from hashMap
			// remove element when frequency == 0 
			// if hashmap doesn't gets empty at any level => Anagram is not possible
			while (n2-- > 0) {
				Node node2 = q2.peek();
				q2.remove();

				if (!m.containsKey(node2.data))
					return false;

				m.put(node2.data, m.get(node2.data) - 1);

				if (m.get(node2.data) == 0)
					m.remove(node2.data);

				if (node2.left != null)
					q2.add(node2.left);
				if (node2.right != null)
					q2.add(node2.right);
			}
			if (m.size() > 0)
				return false;
		}
		if (q1.isEmpty() && q2.isEmpty())
			return true;
		return false;
	}

	// Utility function to create a new tree Node
	public static Node newNode(int data) {
		Node temp = new Node(data);
		return temp;
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		// Constructing both the trees.
		Node root1 = newNode(1);
		root1.left = newNode(3);
		root1.right = newNode(2);
		root1.right.left = newNode(5);
		root1.right.right = newNode(4);

		Node root2 = newNode(1);
		root2.left = newNode(2);
		root2.right = newNode(3);
		root2.left.left = newNode(4);
		root2.left.right = newNode(5);

		if (areAnagrams(root1, root2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}