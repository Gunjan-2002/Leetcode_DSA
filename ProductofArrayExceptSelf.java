package Medium;

//											Product of Array Except Self
//			
//			Given an integer array nums, return an array answer such that answer[i] 
//					is equal to the product of all the elements of nums except nums[i].
//			
//			The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//			
//			You must write an algorithm that runs in O(n) time and without using the division operation.
//			
//			 
//			
//			Example 1:
//			
//			Input: nums = [1,2,3,4]
//			Output: [24,12,8,6]
//			Example 2:
//			
//			Input: nums = [-1,1,0,-3,3]
//			Output: [0,0,9,0,0]
//			 
//			
//			Constraints:
//			
//			2 <= nums.length <= 105
//			-30 <= nums[i] <= 30
//			The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//			 
//			
//			Follow up: Can you solve the problem in O(1) extra space complexity?
//			(The output array does not count as extra space for space complexity analysis.)

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int[] productExceptSelf(int[] nums) 
    {
        int ans[]=new int[nums.length];
        
        int rp=1;
        //Left Pass
        for(int i=0;i<nums.length;i++)
        {
            ans[i]=rp;
            rp=rp*nums[i];
        }
        
        rp=1;
        //Left Pass
        for(int i=nums.length-1;i>=0;i--)
        {
            ans[i]=ans[i]*rp;
            rp=rp*nums[i];
        }
        return ans;
    }
	
}
