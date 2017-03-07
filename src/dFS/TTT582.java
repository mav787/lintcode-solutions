package dFS;
import java.util.*;

public class TTT582 {
 // copy
    
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> result = new ArrayList<String>();
        if (s.length() == 0) {
            return result;
        }
        
        boolean[][] isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                isWord[i][j] = wordDict.contains(word);
            }
        }
        
        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isWord[i][j] && possible[j + 1]) {
                    possible[i] = true;
                    break;
                }
            }
        }
        
        List<Integer> path = new ArrayList<Integer>();
        search(0, s, path, isWord, possible, result);
        return result;
    }
    
    private void search(int index, String s, List<Integer> path,
                   boolean[][] isWord, boolean[] possible,
                   List<String> result) {
        if (!possible[index]) {
            return;
        }
        
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            int lastIndex = 0;
            for (int i = 0; i < path.size(); i++) {
                sb.append(s.substring(lastIndex, path.get(i)));
                if (i != path.size() - 1) sb.append(" ");
                lastIndex = path.get(i);
            }
            result.add(sb.toString());
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (!isWord[index][i]) {
                continue;
            }
            path.add(i + 1);
            search(i + 1, s, path, isWord, possible, result);
            path.remove(path.size() - 1);
        }
    }
}
