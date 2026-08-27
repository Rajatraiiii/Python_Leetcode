import java.util.*;

class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {

        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build both trees
        List<Integer>[] graph1 = buildGraph(n, edges1);
        List<Integer>[] graph2 = buildGraph(m, edges2);

        // Color Tree 1
        int[] color1 = new int[n];
        int[] count1 = new int[2];

        colorTree(graph1, color1, count1);

        // Color Tree 2
        int[] color2 = new int[m];
        int[] count2 = new int[2];

        colorTree(graph2, color2, count2);

        // Maximum nodes we can get from Tree 2
        int maxTree2 = Math.max(count2[0], count2[1]);

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = count1[color1[i]] + maxTree2;
        }

        return answer;
    }


    private List<Integer>[] buildGraph(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        return graph;
    }


    private void colorTree(List<Integer>[] graph, int[] color, int[] count) {

        int n = graph.length;

        // -1 means not visited
        Arrays.fill(color, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        color[0] = 0;
        count[0]++;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbor : graph[node]) {

                if (color[neighbor] == -1) {

                    color[neighbor] = 1 - color[node];
                    count[color[neighbor]]++;

                    queue.offer(neighbor);
                }
            }
        }
    }
}