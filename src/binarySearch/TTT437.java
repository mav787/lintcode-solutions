package binarySearch;

public class TTT437 {
	public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages == null || pages.length == 0){
            return 0;
        }
        int max = 0, sum = 0;
        for(int i = 0; i < pages.length; i++){
            max = Math.max(max, pages[i]);
            sum += pages[i];
        }
        int start = max, end = sum;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(numOfPeople(pages, mid) > k){
                start = mid;
            }
            else if(numOfPeople(pages, mid) == k){
                end = mid;
            }
            else{
                end = mid;
            }
        }
        if(numOfPeople(pages, start) <= k){
            return start;
        }
        else{
            return end;
        }
    }
    
    private int numOfPeople(int[] pages, int time){
        int people = 1;
        int persum = 0;
        for(int i = 0; i < pages.length; i++){
            if(persum + pages[i] <= time){
                persum += pages[i];
            }
            else{
                people++;
                persum = pages[i];
            }
        }
        return people;
    }
}
