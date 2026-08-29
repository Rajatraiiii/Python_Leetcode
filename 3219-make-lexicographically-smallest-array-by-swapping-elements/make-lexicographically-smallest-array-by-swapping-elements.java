import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;
        
        // Store value and original index
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        // Sort according to values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        int i = 0;
        
        while (i < n) {
            int j = i;
            
            // Find all elements in the same group
            while (j + 1 < n && 
                   arr[j + 1][0] - arr[j][0] <= limit) {
                j++;
            }
            
            // Collect original indices of this group
            List<Integer> indices = new ArrayList<>();
            
            for (int k = i; k <= j; k++) {
                indices.add(arr[k][1]);
            }
            
            // Sort indices
            Collections.sort(indices);
            
            // Assign smallest values to smallest indices
            for (int k = 0; k < indices.size(); k++) {
                nums[indices.get(k)] = arr[i + k][0];
            }
            
            i = j + 1;
        }
        
        return nums;
    }
}