class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] num=new int[nums.length];
        int p=0;
        int j=1;
        if(nums.length%2==0){
            for(int i=0;i<nums.length;i++){
            if (nums[i]>0){
                num[p]=nums[i];
                p=p+2;

            }
            else{
                num[j]=nums[i];
                j=j+2;
            }
        }


        }
        
        return num;
    }
}