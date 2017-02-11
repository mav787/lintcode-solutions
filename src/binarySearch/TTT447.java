package binarySearch;

public class TTT447 {
	public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int index = 1;
        while(reader.get(index) < target){
            index = index * 2;
        }
        
        int start = 0, end = index;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(reader.get(mid) < target){
                start = mid;
            }
            else if(reader.get(mid) > target){
                end = mid;
            }
            else{
                end = mid;
            }
        }
        
        if(reader.get(start) == target){
            return start;
        }
        else if(reader.get(end) == target){
            return end;
        }
        else return -1;
    }

}

abstract class ArrayReader{
	public abstract int get(int index);
}
