package A1;

import java.util.*;

public class DFS {


	    private int vertices;
	    private LinkedList<Integer> adjList[];

	    public DFS(int v) {
	        vertices = v;
	        adjList = new LinkedList[v];
	        for (int i = 0; i < v; i++) {
	            adjList[i] = new LinkedList<>();
	        }
	    }

	    public void addEdge(int source, int destination) {
	        adjList[source].add(destination);
	        adjList[destination].add(source); // For an undirected graph
	    }

	    public void DFS(int startVertex) {
	        boolean visited[] = new boolean[vertices];
	        DFSUtil(startVertex, visited);
	    }

	    private void DFSUtil(int vertex, boolean[] visited) {
	        visited[vertex] = true;
	        System.out.print(vertex + " ");

	        Iterator<Integer> i = adjList[vertex].listIterator();
	        while (i.hasNext()) {
	            int nextVertex = i.next();
	            if (!visited[nextVertex]) {
	                DFSUtil(nextVertex, visited);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter number of vertices: ");
	        int v = scanner.nextInt();
	        
	        DFS graph = new DFS(v);

	        System.out.print("Enter number of edges: ");
	        int e = scanner.nextInt();

	        System.out.println("Enter the edges (source destination):");
	        for (int i = 0; i < e; i++) {
	            int source = scanner.nextInt();
	            int destination = scanner.nextInt();
	            graph.addEdge(source, destination);
	        }

	        System.out.print("Enter the starting vertex for DFS: ");
	        int startVertex = scanner.nextInt();
	        
	        System.out.println("DFS traversal starting from vertex " + startVertex + ":");
	        graph.DFS(startVertex);
	    }
	}
