package A1;



import java.util.*;

public class BFS {
    private int vertices;
    private LinkedList<Integer> adjList[];

    public BFS(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    public void BFS(int startVertex) {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (queue.size() != 0) {
            startVertex = queue.poll();
            System.out.print(startVertex + " ");

            Iterator<Integer> i = adjList[startVertex].listIterator();
            while (i.hasNext()) {
                int nextVertex = i.next();
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int v = scanner.nextInt();
        BFS graph = new BFS(v);

        System.out.print("Enter number of edges: ");
        int e = scanner.nextInt();

        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < e; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter the starting vertex for BFS: ");
        int startVertex = scanner.nextInt();
        
        System.out.println("BFS traversal starting from vertex " + startVertex + ":");
        graph.BFS(startVertex);
    }
}
