class Solution(object):
    def mirrorDistance(self, n):
        # Reverse the number
        reversed_n = int(str(n)[::-1])
        
        # Return absolute difference
        return abs(n - reversed_n)