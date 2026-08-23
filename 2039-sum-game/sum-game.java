class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int qDiff = leftQ - rightQ;
        int sumDiff = leftSum - rightSum;

        // Same number of '?' on both sides
        if (qDiff == 0) {
            return sumDiff != 0;
        }

        // Alice wins if the difference cannot be balanced
        if (qDiff > 0) {
            return 2 * sumDiff != -9 * qDiff;
        } else {
            return 2 * sumDiff != -9 * qDiff;
        }
    }
}