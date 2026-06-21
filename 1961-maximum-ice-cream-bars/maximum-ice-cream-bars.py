class Solution(object):
    def maxIceCream(self, costs, coins):
        """
        :type costs: List[int]
        :type coins: int
        :rtype: int
        """
        
       
        max_cost = max(costs)
        
     
        freq = [0] * (max_cost + 1)
        
       
        for cost in costs:
            freq[cost] += 1
        
        count = 0
        
        # Buy ice creams starting from the cheapest price
        for price in range(1, max_cost + 1):
            
            if freq[price] == 0:
                continue
            
            # Maximum bars we can buy at this price
            can_buy = min(freq[price], coins // price)
            
            count += can_buy
            coins -= can_buy * price
            
            if coins < price:
                continue
        
        return count