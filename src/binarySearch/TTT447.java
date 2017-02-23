package binarySearch;

public class TTT447 {
	public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if(reader == null){
            return -1;
        }
        //if(reader.get(0) == target) return 0;
        int index = 1;
        while(index < Integer.MAX_VALUE / 2 && reader.get(index) < target){
            index *= 2;
        }
        if(reader.get(index) < target){
            index = Integer.MAX_VALUE;
        }
        int start = 0, end = index;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(reader.get(mid) < target){
                start = mid;
            }
            else {
                end = mid; 
            }
        }
        if(reader.get(start) == target){
            return start;
        }
        else if(reader.get(end) == target){
            return end;
        }
        else{
            return -1;
        }
    }

}

abstract class ArrayReader{
	public abstract int get(int index);
}
