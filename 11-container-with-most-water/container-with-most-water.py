class Solution(object):
    def maxArea(self, height):
        maxWater = 0
        lp, rp = 0, len(height) - 1

        while lp < rp:
            width = rp - lp
            ht = min(height[lp], height[rp])
            currWater = width * ht
            maxWater = max(maxWater, currWater)

            if height[lp] < height[rp]:
                lp += 1
            else:
                rp -= 1

        return maxWater
