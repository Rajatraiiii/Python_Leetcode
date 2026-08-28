import java.util.*;

class Solution {

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Check if a palindromic permutation is possible
        int oddCount = 0;
        char middle = '\0';

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        // Characters needed for the left half
        int[] halfCount = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        int halfLength = n / 2;
        String bound = target.substring(0, halfLength);

        // Find smallest half >= target's left half
        String half = findSmallestGreaterOrEqual(
                halfCount.clone(), bound, halfLength
        );

        if (half == null) {
            return "";
        }

        String palindrome = buildPalindrome(half, middle, n);

        // If already strictly greater
        if (palindrome.compareTo(target) > 0) {
            return palindrome;
        }

        // Otherwise, find the next lexicographical permutation
        char[] arr = half.toCharArray();

        if (!nextPermutation(arr)) {
            return "";
        }

        return buildPalindrome(new String(arr), middle, n);
    }


    private String findSmallestGreaterOrEqual(
            int[] count, String bound, int length) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {

            int ch = bound.charAt(i) - 'a';

            if (count[ch] > 0) {
                count[ch]--;
                result.append(bound.charAt(i));
            } else {

                String ans = makeGreater(result, count, bound.charAt(i));

                if (ans != null) {
                    return ans;
                }

                // Backtrack
                while (result.length() > 0) {

                    char last = result.charAt(result.length() - 1);

                    result.deleteCharAt(result.length() - 1);
                    count[last - 'a']++;

                    char boundChar = bound.charAt(result.length());

                    ans = makeGreater(result, count, boundChar);

                    if (ans != null) {
                        return ans;
                    }
                }

                return null;
            }
        }

        return result.toString();
    }


    private String makeGreater(
            StringBuilder prefix,
            int[] count,
            char boundChar) {

        for (int i = boundChar - 'a' + 1; i < 26; i++) {

            if (count[i] > 0) {

                StringBuilder ans = new StringBuilder(prefix);
                ans.append((char) ('a' + i));

                count[i]--;

                for (int j = 0; j < 26; j++) {
                    while (count[j] > 0) {
                        ans.append((char) ('a' + j));
                        count[j]--;
                    }
                }

                return ans.toString();
            }
        }

        return null;
    }


    private String buildPalindrome(String half, char middle, int n) {

        StringBuilder ans = new StringBuilder();

        ans.append(half);

        if (n % 2 == 1) {
            ans.append(middle);
        }

        for (int i = half.length() - 1; i >= 0; i--) {
            ans.append(half.charAt(i));
        }

        return ans.toString();
    }


    private boolean nextPermutation(char[] arr) {

        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = arr.length - 1;

        while (arr[j] <= arr[i]) {
            j--;
        }

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i + 1, arr.length - 1);

        return true;
    }


    private void reverse(char[] arr, int left, int right) {

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}