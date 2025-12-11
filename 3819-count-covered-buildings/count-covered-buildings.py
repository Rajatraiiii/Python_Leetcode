class Solution(object):
    def countCoveredBuildings(self, n, buildings):
        """
        :type n: int
        :type buildings: List[List[int]]
        :rtype: int
        """
        from collections import defaultdict

        # track min/max x for each row (y), and min/max y for each column (x)
        row_min = defaultdict(lambda: 10**9)
        row_max = defaultdict(lambda: -10**9)
        col_min = defaultdict(lambda: 10**9)
        col_max = defaultdict(lambda: -10**9)

        for x, y in buildings:
            row_min[y] = min(row_min[y], x)
            row_max[y] = max(row_max[y], x)
            col_min[x] = min(col_min[x], y)
            col_max[x] = max(col_max[x], y)

        covered = 0
        for x, y in buildings:
            has_left  = row_min[y] < x
            has_right = row_max[y] > x
            has_below = col_min[x] < y
            has_above = col_max[x] > y
            if has_left and has_right and has_below and has_above:
                covered += 1

        return covered
