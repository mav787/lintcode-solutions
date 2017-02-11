package strStr;

public class TT13 {
	public int strStr(String source, String target) {
        // write your code here
        if(source == null || target == null || source.length() < target.length()){
            return -1;
        }
        int j = 0;
        for(int i = 0; i < source.length() - target.length() + 1; i++){
            for(j = 0; j < target.length(); j++){
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
