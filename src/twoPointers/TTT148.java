package twoPointers;

public class TTT148 {
	public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        
        int left = 0;
        int right = a.length - 1;
        int i = 0;
        while (i <= right) {
            if (a[i] == 0) {
                swap(a, left, i);
                left++;
                i++;
            } else if(a[i] == 1) {
                i++;
            } else {
                swap(a, right, i);
                right--;
            }
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
