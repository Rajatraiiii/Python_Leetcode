class Solution(object):
    def minimumScore(self, nums, edges):
        """
        :type nums: List[int]
        :type edges: List[List[int]]
        :rtype: int
        """
        from collections import defaultdict

        n = len(nums)
        graph = defaultdict(list)

       
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

      
        parent = [-1] * n
        xor_subtree = nums[:]
        in_time = [0] * n
        out_time = [0] * n
        time = [1]  
      
        def dfs(u, p):
            parent[u] = p
            in_time[u] = time[0]
            time[0] += 1
            for v in graph[u]:
                if v == p:
                    continue
                dfs(v, u)
                xor_subtree[u] ^= xor_subtree[v]
            out_time[u] = time[0]
            time[0] += 1

        dfs(0, -1)

        total_xor = xor_subtree[0]
        min_score = float('inf')

       
        candidates = []
        for i in range(1, n):
            candidates.append(i)

       
        def is_ancestor(u, v):
            return in_time[u] < in_time[v] and out_time[u] > out_time[v]

        for i in range(len(candidates)):
            for j in range(i + 1, len(candidates)):
                u = candidates[i]
                v = candidates[j]

                if is_ancestor(u, v):
                  
                    x = xor_subtree[v]
                    y = xor_subtree[u] ^ xor_subtree[v]
                    z = total_xor ^ xor_subtree[u]
                elif is_ancestor(v, u):
                    
                    x = xor_subtree[u]
                    y = xor_subtree[v] ^ xor_subtree[u]
                    z = total_xor ^ xor_subtree[v]
                else:
                   
                    x = xor_subtree[u]
                    y = xor_subtree[v]
                    z = total_xor ^ x ^ y

                max_x = max(x, y, z)
                min_x = min(x, y, z)
                min_score = min(min_score, max_x - min_x)

        return min_score

        