class Solution(object):
    def mirrorDistance(self, n):
        """
        :type n: int
        :rtype: int
        """
        a=str(n)
        k=a[::-1]
        result = int(k)

        m= abs(n-result)
        return m