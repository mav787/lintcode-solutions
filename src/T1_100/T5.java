package T1_100;

public class T5 {
	public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if(nums == null || k > nums.length || k < 1)
            return -1;
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }
    
    private void quickSelect(int[] nums, int left, int right, int k){
        int i = left, j = right;
        int mid = left + (right - left) / 2;
        int pivot = nums[mid];
        
        while(i <= j){
            while(nums[i] < pivot)
                i++;
            while(nums[j] > pivot)
                j--;
            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        
        if(i <= k && i < right)
            quickSelect(nums, i, right, k);
        if(j >= k && j > left)
            quickSelect(nums, left, j, k);
    }
}
