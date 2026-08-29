class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums3 = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare elements
        for (; i < m && j < n;) {

            if (nums1[i] <= nums2[j]) {
                nums3[k] = nums1[i];
                i++;
            } else {
                nums3[k] = nums2[j];
                j++;
            }

            k++;
        }

        // Remaining nums1 elements
        for (; i < m; i++) {
            nums3[k] = nums1[i];
            k++;
        }

        // Remaining nums2 elements
        for (; j < n; j++) {
            nums3[k] = nums2[j];
            k++;
        }

        for (i = 0; i < m + n; i++) {
            nums1[i] = nums3[i];
        }
    }
}