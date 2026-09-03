class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true;
        int min = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 != 0) {
                allEven = false;
            }
            min = Math.min(min, num);
        }

        if (allEven) {
            return true;
        }

        
        return min % 2 != 0;
    }
}