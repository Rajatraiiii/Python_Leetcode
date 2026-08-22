class Solution {
    public void duplicateZeros(int[] arr) {
        
        int[] nums = new int[arr.length];
        int p = 0;

        for (int i = 0; i < arr.length && p < arr.length; i++) {

            if (arr[i] != 0) {
                nums[p] = arr[i];
                p++;
            } 
            else {
                nums[p] = 0;
                p++;

                if (p < arr.length) {
                    nums[p] = 0;
                    p++;
                }
            }
        }

       
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
    }
}