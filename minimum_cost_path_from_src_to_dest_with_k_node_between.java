package March;

import java.util.*;
public class minimum_cost_path_from_src_to_dest_with_k_node_between {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int adjMatrix[][] = new int[n][n];
        // intializing adjacecny matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                adjMatrix[i][j] = -1;
        }
        int E = sc.nextInt();
        int k = sc.nextInt();
        int src = sc.nextInt();
        int dest = sc.nextInt();
        //
        for (int i = 0; i < E; i++) {
            int a, b, w;
            a = sc.nextInt();
            b = sc.nextInt();
            w = sc.nextInt();
            adjMatrix[a][b] = w;
        }
        int min = Integer.MAX_VALUE;
        // queue for bfs
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        // map will store distance of source to node for (1 , 300) => 0 to 1 with max
        // distance is 300
        HashMap<Integer, Integer> map = new HashMap<>();
        q.add(new Pair<>(src, 0));
        map.put(0, 0);
        // counting current node level
        int nodeCount = 0;

        while (q.size() > 0 && nodeCount < k + 2) {
            System.out.println(q);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = q.peek();
                q.poll();
                int distance = pair.getValue();
                int parent = pair.getKey();
                if (parent == dest && nodeCount == k + 1)
                    min = Math.min(min, distance);
                if (parent == dest)
                    continue;
                for (int j = 0; j < n; j++) {
                    if (adjMatrix[parent][j] > 0)
                        q.add(new Pair<>(j, distance + adjMatrix[parent][j]));

                }
            }
            nodeCount++;
        }
        System.out.println(src + " to " + dest + " with min path sum " + min);

    }
    
}
