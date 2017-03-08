package T1_100;

public class TT13 {
	public int strStr(String source, String target) {
        // write your code here
        if(source == null || target == null || source.length() < target.length()){
            return -1;
        }
        int i = 0;
        for(; i < source.length() - target.length() + 1; i++){
            int j = 0;
            for(; j < target.length(); j++){
                if(source.charAt(i + j) != target.charAt(j)){
                    break;
                }
            }
            if(j == target.length()){
                return i;
            }
        }
        return -1;
    }
}
