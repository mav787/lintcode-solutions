package hashHeapAndStack;

public class TTT128 {
	public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if(key == null || key.length == 0 || HASH_SIZE <= 0){
            return -1;
        }
        long hashcode = 0;
        for(int i = 0; i < key.length; i++){
            hashcode = (33 * hashcode + (int)key[i]) % HASH_SIZE;
        }
        return (int)hashcode;
    }
}
