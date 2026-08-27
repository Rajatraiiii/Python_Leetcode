class Solution {

    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];

        // Count all characters in s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();
        int n = s.length();

        // Try matching target from left to right
        for (int i = 0; i < n; i++) {

            int t = target.charAt(i) - 'a';

            // If we can match target[i], do it
            if (count[t] > 0) {
                count[t]--;
                prefix.append(target.charAt(i));
            } else {
                // Cannot match at this position
                // First try making THIS position greater
                String ans = buildGreater(prefix, count, t);

                if (!ans.equals("")) {
                    return ans;
                }

                // Otherwise, backtrack
                return backtrack(prefix, count, target);
            }
        }

        // We matched target exactly
        // Need to make some previous position greater
        return backtrack(prefix, count, target);
    }


    // Make current position greater than target character
    private String buildGreater(StringBuilder prefix, int[] count, int targetChar) {

        for (int c = targetChar + 1; c < 26; c++) {

            if (count[c] > 0) {

                StringBuilder ans = new StringBuilder(prefix);

                // Use the smallest character greater than target[i]
                ans.append((char) ('a' + c));

                count[c]--;

                // Add all remaining characters in sorted order
                for (int j = 0; j < 26; j++) {
                    while (count[j] > 0) {
                        ans.append((char) ('a' + j));
                        count[j]--;
                    }
                }

                return ans.toString();
            }
        }

        return "";
    }


    // Go backwards and try increasing an earlier position
    private String backtrack(StringBuilder prefix, int[] count, String target) {

        for (int i = prefix.length() - 1; i >= 0; i--) {

            // Restore last character
            char ch = prefix.charAt(prefix.length() - 1);
            prefix.deleteCharAt(prefix.length() - 1);
            count[ch - 'a']++;

            int t = target.charAt(i) - 'a';

            // Find smallest available character greater than target[i]
            for (int c = t + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder(prefix);

                    ans.append((char) ('a' + c));
                    count[c]--;

                    // Add remaining characters in sorted order
                    for (int j = 0; j < 26; j++) {
                        while (count[j] > 0) {
                            ans.append((char) ('a' + j));
                            count[j]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}