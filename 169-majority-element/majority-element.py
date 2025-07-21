class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        freq=0;
        ans=0;
        n=len(nums);
        for val in nums:
            if(freq==0):
                ans=val
            if(ans==val):
                freq=freq+1
            else:
                freq=freq-1
            
        return ans;
        