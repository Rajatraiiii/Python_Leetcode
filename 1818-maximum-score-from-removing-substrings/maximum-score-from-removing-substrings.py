class Solution(object):
    def maximumGain(self, s, x, y):
        """
        :type s: str
        :type x: int
        :type y: int
        :rtype: int
        """
        def remove_pairs(s, first, second, score):
            stack = []
            total = 0
            for char in s:
                if stack and stack[-1] == first and char == second:
                    stack.pop()
                    total += score
                else:
                    stack.append(char)
            return ''.join(stack), total
        
        
        if x >= y:
            s, points1 = remove_pairs(s, 'a', 'b', x)
            s, points2 = remove_pairs(s, 'b', 'a', y)
        else:
            s, points1 = remove_pairs(s, 'b', 'a', y)
            s, points2 = remove_pairs(s, 'a', 'b', x)
        
        return points1 + points2
