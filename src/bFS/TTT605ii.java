package bFS;

import java.util.*;

public class TTT605ii {
	/**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here

        // copy of answers...
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();

        for (int num : org) {
            map.put(num, new HashSet<Integer>());
            indegree.put(num, 0);
        }

        int n = org.length;
        int count = 0;
        for (int[] seq : seqs) {
            count += seq.length;
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n))
                return false;
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] <= 0 || seq[i] > n)
                    return false;
                if (map.get(seq[i - 1]).add(seq[i]))
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
            }
        }

        // case: [1], []
        if (count < n){
            return false;
        }


        if (org.length < map.size())
            return false;


        int cnt = 0;

        for (int key : org) {
            if (map.get(key).size() > 1) {
                for (int x : map.get(key) )
                {
                    for (int j : map.get(key)) {
                        if (x == j) {
                            continue;
                        }
                        else {
                            if ( map.get(x).contains(j)) {
                                if ( map.get(j).contains(x)) {
                                    return false;
                                }
                                cnt++;
                            }
                        }
                    }
                }
            }
            if (map.get(key).size() == 1) {
                for (int x : map.get(key)) {
                    if ( map.get(x).contains(key)) {
                        return false;
                    }
                }
            }
            if (map.get(key).size() == 2 && cnt != 1)
                return false;
            if (cnt < map.get(key).size() - 1)
                return false;
            cnt = 0;
        }
          Queue<Integer> q = new ArrayDeque<Integer>();
        for (int key : indegree.keySet()) 
            if (indegree.get(key) == 0)
                q.add(key);
        
        if (q.size() > 1) {
            return false;
        }

        return true;
    }
}
