package info.yodlee.composition;

import java.util.ArrayList;
import java.util.Set;

public class WordbreakPgm {

public static void main(String[] args) {

		ArrayList<String> wordBreak(String s, Set<String> dict) {
	        ArrayList<String> res = new ArrayList<String>();
	        if(s == null || s.length() == 0)
	            return res;
	        ArrayList<String> cur = new ArrayList<String>();
	        int n = s.length();
	        boolean[] dp = new boolean[n + 1];
	        dp[0] = true;
	        for(int i = 1; i <= n; i++){
	            if(dict.contains(s.substring(0, i))) {
	                dp[i] = true;
	                continue;
	            }
	            for(int j = 0; j < i; j++) {
	                if(dp[j] && dict.contains(s.substring(j, i))) {
	                    dp[i] = true;
	                }
	            }
	        }
	        if(dp[n] == false) 
	            return res; // This is all DP is about.... 
	        StringBuilder cur = new StringBuilder();
	        dfs(s, 0, cur, ret, dict);
	        return ret;
	    }

	    public void dfs(String s, int start, StringBuilder cur, ArrayList<String> ret, Set<String> dict){
	        int n = s.length();
	        if(start >= n) {
	            ret.add(new String(cur));
	            return;
	        }
	        for(int i = start + 1; i <= n; i++) {
	            String sub = s.substring(start, i);
	            if(dict.contains(sub)) {
	                int oldLen = cur.length();
	                if(oldLen != 0)
	                    cur.append(" ");
	                cur.append(sub);
	                dfs(s, i, cur, ret, dict);
	                // backtracking. 
	                cur.delete(oldLen, cur.length());
	            }
	        }
	    }
	}


}
