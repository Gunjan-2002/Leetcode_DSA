package Sorting;

import java.util.ArrayList;
import java.util.HashMap;

//											Intersection of Two Arrays 2
//				
//				Given two integer arrays nums1 and nums2, return an array of their intersection. 
//				Each element in the result must appear as many times as it shows in both arrays 
//				and you may return the result in any order.
//				
//				
//				Example 1:
//				
//				Input: nums1 = [1,2,2,1], nums2 = [2,2]
//				Output: [2,2]
//				Example 2:
//				
//				Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//				Output: [4,9]
//				Explanation: [9,4] is also accepted.
//				
//				
//				Constraints:
//				
//				1 <= nums1.length, nums2.length <= 1000
//				0 <= nums1[i], nums2[i] <= 1000
//				
//				
//				Follow up:
//				
//				What if the given array is already sorted? How would you optimize your algorithm?
//				What if nums1's size is small compared to nums2's size? Which algorithm is better?
//				What if elements of nums2 are stored on disk, and the memory is limited such that 
//				you cannot load all elements into the memory at once?


public class Easy_IntersectionofTwoArrays_II_350 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}
	
//		Note :
//			
//		In this we have two methods to solve question
//		1] With Frequency method
//		2] HashMap Method
//		
//		HashMap Method is so effective in means of time complexity
//		It is faster than frequency method
	
	
	 public int[] intersect(int[] nums1, int[] nums2) 
	    {
	        int freq1[]=getFreq(nums1);
	        int freq2[]=getFreq(nums2);
	        ArrayList<Integer> l=new ArrayList<>();        
	        for(int i=0;i<freq1.length;i++)
	        {
	            int count=Math.min(freq1[i],freq2[i]);
	            
	            while(count > 0)
	            {
	                l.add(i);
	                count--;
	            }
	        }
	        
	        int ans[] = new int[l.size()];
	        
	        for(int i=0;i<l.size();i++)
	        {
	            ans[i]=l.get(i);
	        }
	        
	        return ans;       
	    }
	 
	 	public int[] intersect_2(int[] nums1, int[] nums2) 
	 	{
		 		HashMap<Integer,Integer> h=new HashMap<>();
		        
		        for(int x : nums1)
		        {
		            if(h.containsKey(x))
		            {
		                h.put(x,h.get(x)+1);
		            }
		            else
		            {
		                h.put(x,1);
		            }
		        }
		        
		        ArrayList<Integer> ar=new ArrayList<>();
		        
		        for(int x : nums2)
		        {
		        	if(h.containsKey(x))
		        	{
		        		if(h.get(x) > 1)
		        		{
		        			h.put(x,h.get(x)-1);
		        		}
		        		else
		        		{
		        			h.remove(x);
		        		}
		        		ar.add(x);
		        	}
		        }
		        
		        int ans[]=new int[ar.size()];
		        int i=0;
		        for(int x : ar)
		        {
		        	ans[i]=x;
		        	i++;
		        }
		        return ans;     
	 	}
	    
	    private int[] getFreq(int arr[])
	    {
	        int ar[]=new int[1001];
	        for(int i : arr)
	        {
	            ar[i]++;
	        }
	        return ar;
	    }
	

}