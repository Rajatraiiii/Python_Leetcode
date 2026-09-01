import java.util.*;

class Solution {

    static class State {
        int row, col, energyLeft, mask, moves;

        State(int row, int col, int energyLeft, int mask, int moves) {
            this.row = row;
            this.col = col;
            this.energyLeft = energyLeft;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = 0;
        int startCol = 0;

        // Assign an index to every litter
        int[][] litterIndex = new int[m][n];
        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                }

                if (cell == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        int fullMask = (1 << litterCount) - 1;

        /*
         * visited[row][col][mask] stores the maximum energy
         * with which we have visited this state.
         *
         * If we reach the same position + collected litter mask
         * with less or equal energy, it is not useful.
         */
        int[][][] visited = new int[m][n][1 << litterCount];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }

        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(
                startRow,
                startCol,
                energy,
                0,
                0
        ));

        visited[startRow][startCol][0] = energy;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!queue.isEmpty()) {

            State current = queue.poll();

            // Try all 4 directions
            for (int[] dir : directions) {

                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                // Boundary check
                if (newRow < 0 || newRow >= m ||
                    newCol < 0 || newCol >= n) {
                    continue;
                }

                // Cannot pass obstacle
                if (classroom[newRow].charAt(newCol) == 'X') {
                    continue;
                }

                // Need energy to move
                if (current.energyLeft == 0) {
                    continue;
                }

                int newEnergy = current.energyLeft - 1;
                int newMask = current.mask;

                char cell = classroom[newRow].charAt(newCol);

                // Collect litter
                if (cell == 'L') {
                    int index = litterIndex[newRow][newCol];
                    newMask |= (1 << index);
                }

                // Reset energy
                if (cell == 'R') {
                    newEnergy = energy;
                }

                // All litter collected
                if (newMask == fullMask) {
                    return current.moves + 1;
                }

                /*
                 * If we have already reached this position
                 * with same collected litter and more/equal energy,
                 * skip it.
                 */
                if (visited[newRow][newCol][newMask] >= newEnergy) {
                    continue;
                }

                visited[newRow][newCol][newMask] = newEnergy;

                queue.offer(new State(
                        newRow,
                        newCol,
                        newEnergy,
                        newMask,
                        current.moves + 1
                ));
            }
        }

        return -1;
    }
}