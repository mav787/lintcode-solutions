package twoPointers;

public class TTT143 {
	public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length < 2) {
            return;
        }
        quickSort(colors, 0, colors.length - 1);
    }
    
    private void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        
        int mid = left + (right - left)/2;
        int pivot = arr[mid];
        int i = left, j = right;
        while(i <= j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        
        if(i < right){
            quickSort(arr, i, right);
        }
        if(j > left){
            quickSort(arr, left, j);
        }
    }
}
