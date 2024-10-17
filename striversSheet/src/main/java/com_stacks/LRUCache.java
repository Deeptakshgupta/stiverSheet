package com_stacks;

import java.util.HashMap;

/*
 Cache replacement Algorithms - replace the cache when the space is full
 */
public class LRUCache {
// Least Recently picks the data that is recently used and 
// removes it to make space for new data
	
	
/**HashMap + Doubly Linked List  **/
    class Node{
    Node next;
    Node prev;
    int key,val;
        
      Node(int key,int val){
            this.key=key;
            this.val=val;
       }
    }
    
    
    Node head;
    Node tail;
    int capacity=0;
    
    // integer for key 
    //Node to store the data and refresh the insertion time
    // removing the node and adding again at head 
    HashMap<Integer,Node> hash=new HashMap<Integer,Node>();
    
    LRUCache(int cap)
    {
       capacity=cap;
       head=new Node(0,0);
       tail=new Node(0,0);
       head.next=tail;
       tail.prev=head;
       
    }

    //Function to return value corresponding to the key.
    public int get(int key)
    {
         if(hash.containsKey(key)){
             Node data=hash.get(key);
             //refresh that node in cache
             removed(data);
             insert(data);
             return data.val;
         }
         else{
             return -1;
         }
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
       if(hash.containsKey(key)){
    	   //hash.get => provides the pointer to the Node
           removed(hash.get(key));
       }
       
       if(hash.size()==capacity){
           removed(tail.prev);
       }
       
       Node node=new Node(key,value);
       insert(node);
    }
    
    public  void removed(Node node){
        hash.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        
    }
    
    public void insert(Node node){
        hash.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
}
	

