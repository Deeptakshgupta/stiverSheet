package com_stacks;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 Given a string str of lowercase alphabets and a number k, the task is to print the minimum value
  of the string after removal of k characters. The value of a string is defined as the sum of
  squares of the count of each distinct character present in the string. Return the minimum 
  possible required value.
 */
public class gameWitString {

	static int minValue(String s, int k) {
		// code here
		char testing[] = s.toCharArray();
		HashMap<Character, Integer> freqmap = new HashMap<>();

		for (char c : testing) {
			freqmap.put(c, freqmap.getOrDefault(c, 0) + 1);
		} // adding frequency in the hashmap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		// increasing order m
		for (int freq : freqmap.values()) {
			maxHeap.add(freq);
		}
		while (k > 0 && !maxHeap.isEmpty()) {
			int maxi = maxHeap.poll(); // getting the top element
			maxi--;
			k--;
			if (maxi > 0) {
				maxHeap.add(maxi); // if reduced frequency is greater than 0 then add
			}

		}
		int result = 0;
		while (!maxHeap.isEmpty()) {
			int freq = maxHeap.poll();
			result += freq * freq;

		}
		return result;

	}
}
