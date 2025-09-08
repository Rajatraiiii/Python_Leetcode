class Solution(object):
    def getNoZeroIntegers(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        for A in range(1,n):
            B=n-A
            if "0" not in str(A) and "0" not in str(B):
                return [A,B]
        return []