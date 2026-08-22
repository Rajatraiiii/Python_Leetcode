class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] arr=new int[nums.length];
        int p=0;
        int n=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                arr[p]=nums[i];
                p++;
               
            }else{
                arr[n]=nums[i];
                n--;
            }
        }
        return arr;
        
    }
}