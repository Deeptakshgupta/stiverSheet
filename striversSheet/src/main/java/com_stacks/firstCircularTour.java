package com_stacks;
import java.util.*;
public class firstCircularTour {

/*Given information about N petrol pumps (say arr[]) that are present in a circular path.
 *  The information consists of the distance of the next petrol pump from the current
 *   one (in arr[i][1]) and the amount of petrol stored in that petrol pump (in arr[i][0]).
 *    Consider a truck with infinite capacity that consumes 1 unit of petrol to travel 1 
 *    unit distance. The task is to find the index of the first starting point such that
 *     the truck can visit all the petrol pumps and come back to that starting point.	
	
	
*/

	
		public static void main(String args[])
		{
			Scanner sc = new Scanner(System.in);
			int t =sc.nextInt();
			while(t>0)
			{
				int n = sc.nextInt();
				sc.nextLine();
				String str = sc.nextLine();
				String arr[] = str.split(" ");
				int p[] = new int[n];
				int d[] = new int[n];
				int j=0;
				int k=0;
				for(int i=0; i<2*n; i++)
				{
					if(i%2 == 0)
					{
						p[j]= Integer.parseInt(arr[i]);
						j++;
					}
					else
					{
						d[k] = Integer.parseInt(arr[i]);
						k++;
					}
				}
				
				System.out.println(new Solution().tour(p,d));
			t--;
			}
			sc.close();
		}
	}
	// } Driver Code Ends


	// In java function tour() takes two arguments array of petrol
	// and array of distance

	class Solution
	{
	    //Function to find starting point where the truck can start to get through
	    //the complete circle without exhausting its petrol in between.
	      public int tour(int[] gas, int[] cost) {
	        int start=0;
	        int n=gas.length;
	        int extraPetrol=0;
	        int requiredPetrol=0;
	        for(int i=0;i<n;i++){
	            extraPetrol+=gas[i]-cost[i];
	           if(extraPetrol<0){
	            start=i+1;
	            requiredPetrol+=extraPetrol;
	            extraPetrol=0;
	           }
	           
	        }
	        if(requiredPetrol+extraPetrol>=0)return start;
	        return -1;
	    }



}
