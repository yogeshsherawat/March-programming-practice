package March;


import java.util.*;

class Pair<K,V> {
    K a;
    V b;

    public Pair(K a, V b) {
        this.a = a;
        this.b = b;
    }

    public K getKey() {
        return a;
    }
    public V getValue(){
        return b;
    }
}


public class  maximum_cost_path_from_source_to_destination_via_atmost_k_nodes{
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
        int max = 0;
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
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = q.poll();
                if (pair.getKey() == dest)
                    max = Math.max(max, pair.getValue());
                int distance = pair.getValue();
                int parent = pair.getKey();
                for (int j = 0; j < n; j++) {

                    // this condition is used for avoiding extra work
                    // e.g 0 -> 1(100) 2(200) and 1->2(50) then 0->2 (200) and 0-1-2(150) so adding
                    // this 2 will be extra work so to avoid this
                    if (!map.containsKey(j) || map.get(j) < distance + adjMatrix[parent][j]) {
                        map.put(j, distance + adjMatrix[parent][j]);
                        q.add(new Pair<>(j, distance + adjMatrix[parent][j]));
                    }
                }
            }
            nodeCount++;
        }
        System.out.println(src + " to " + dest + " with max path sum " + max);

    }

}
