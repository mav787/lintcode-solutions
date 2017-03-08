package binarySearch;

public class TTT585 {
	public int mountainSequence(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];
        if(nums[0] > nums[1])
            return nums[0];
        if(nums[nums.length - 1] > nums[nums.length - 2])
            return nums[nums.length - 1];
        int start = 1, end = nums.length - 2;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return nums[mid];
            else if(nums[mid] > nums[mid - 1])
                start = mid;
            else if(nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid;
        }
        return Math.max(nums[start], nums[end]);
    }
}
