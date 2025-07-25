class Solution(object):
    def makeFancyString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return ""
        
        result = [s[0]]  
        count = 1  

        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                count += 1
            else:
                count = 1  

            if count < 3:
                result.append(s[i])

        return "".join(result)


        