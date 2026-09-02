class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int[] nums2=new int[n];
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0 || nums1[i]%2!=0){
                nums2[i]=nums1[i];
                return true;
            }
        }
        return false;
        
    }
}