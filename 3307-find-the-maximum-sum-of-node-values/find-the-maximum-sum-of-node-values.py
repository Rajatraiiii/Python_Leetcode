class Solution(object):
    def maximumValueSum(self, nums, k, edges):
        total = sum(nums)
        deltas = [(num ^ k) - num for num in nums]

        # Sort deltas descending — biggest benefits first
        deltas.sort(reverse=True)

        curr_total = total
        max_sum = total
        count = 0

        for delta in deltas:
            curr_total += delta
            count += 1
            if count % 2 == 0:
                max_sum = max(max_sum, curr_total)
        
        return max_sum
