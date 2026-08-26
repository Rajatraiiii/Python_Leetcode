class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }
            while (ones == k) {
                while (left <= right && s.charAt(left) == '0') {
                    left++;
                }
                int len = right - left + 1;
                String curr = s.substring(left, right + 1);
                if (len < minLen) {
                    minLen = len;
                    ans = curr;
                } 
                else if (len == minLen && curr.compareTo(ans) < 0) {
                    ans = curr;
                }
                ones--;
                left++;
            }
        }
        return ans;
    }
}