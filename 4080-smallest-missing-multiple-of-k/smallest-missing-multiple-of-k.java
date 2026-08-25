class Solution {
    public int missingMultiple(int[] nums, int k) {
        int i=1;
        int n;
        while(true){
            n=k*i;
            boolean found = false;
            
            for(int j=0;j<nums.length;j++){
                 if (n == nums[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return n;
            }
            i++;
        }
    }
}