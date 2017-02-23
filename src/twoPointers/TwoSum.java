package twoPointers;
import java.util.*;


public class TwoSum {
    
    List<Integer> list;
    Map<Integer, Integer> map;
    
    public TwoSum(){
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        }
        else{
            map.put(number, 1);
            list.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for (int i = 0; i < list.size(); i++){
            int a = list.get(i);
            int b = value - a;
            if(a == b){
                if(map.get(a) > 1){
                    return true;
                }
            }
            else{
                if(map.containsKey(b)){
                    return true;
                }
            }
        }
        return false;
    }
}
