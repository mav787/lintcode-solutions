package T1_100;
import java.util.*;

public class T9 {
	public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();
        if(n < 1)
            return res;
        for(int i = 1; i <= n; i++){
            if (i % 15 == 0)
                res.add("fizz buzz");
            else if(i % 3 == 0)
                res.add("fizz");
            else if(i % 5 == 0)
                res.add("buzz");
            else
                res.add(String.valueOf(i));
        }
        return res;
    }
}
