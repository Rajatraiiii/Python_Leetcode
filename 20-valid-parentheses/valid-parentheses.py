class Solution(object):
    def isValid(self, s):
        stack = []  
        
        for ch in s:
            if ch in "([{":     # If opening bracket
                stack.append(ch)
            else:               # closing bracket
                if not stack:   # nothing to match
                    return False
                
                top = stack.pop()
                
                # check matching pair
                if (ch == ')' and top != '(') or \
                   (ch == ']' and top != '[') or \
                   (ch == '}' and top != '{'):
                    return False

        # if stack empty → all matched
        return len(stack) == 0
