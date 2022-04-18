package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.util.Pair;

//													436 . Find Right Interval
//				
//				You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
//				
//				The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.
//				
//				Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
//				
//				 
//				
//				Example 1:
//				
//				Input: intervals = [[1,2]]
//				Output: [-1]
//				Explanation: There is only one interval in the collection, so it outputs -1.
//				Example 2:
//				
//				Input: intervals = [[3,4],[2,3],[1,2]]
//				Output: [-1,0,1]
//				Explanation: There is no right interval for [3,4].
//				The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
//				The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
//				Example 3:
//				
//				Input: intervals = [[1,4],[2,3],[3,4]]
//				Output: [-1,2,-1]
//				Explanation: There is no right interval for [1,4] and [3,4].
//				The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
//				 
//				
//				Constraints:
//				
//				1 <= intervals.length <= 2 * 104
//				intervals[i].length == 2
//				-106 <= starti <= endi <= 106
//				The start point of each interval is unique.

public class FindRightInterval_436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int[] findRightInterval(int[][] intervals) 
    {
        List<Pair<Pair<Integer,Integer>,Integer>> sorted = new ArrayList();
        int n=intervals.length;
        
        for(int i=0;i<n;i++)
        {
            sorted.add(new Pair(new Pair(intervals[i][0],intervals[i][1]),i));
        }
        Collections.sort(sorted , (a,b)-> a.getKey().getKey() - b.getKey().getKey());
        
        int ans[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            ans[i]=binarySearch(sorted,intervals[i][1]);
        }
        return ans;
    }
    
   int binarySearch(List<Pair<Pair<Integer,Integer>,Integer>> sorted , int x )
    {
       int n=sorted.size();
        if(sorted.get(n-1).getKey().getKey() < x)
        {
            return -1;
        }
        
        int start=0;
        int end=sorted.size()-1;
        
        while(start <= end)
        {
            int mid=start + (end-start)/2;
            
            if(sorted.get(mid).getKey().getKey() < x)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return sorted.get(start).getValue();
    }

}
