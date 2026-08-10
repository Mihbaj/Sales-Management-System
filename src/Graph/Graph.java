package Graph;

import java.util.*;


public class Graph<T> {

    private Map<T, List<T>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex
    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an undirected edge
    public void addEdge(T vertex1, T vertex2) {

        addVertex(vertex1);
        addVertex(vertex2);

        if (!adjacencyList.get(vertex1).contains(vertex2)) {
            adjacencyList.get(vertex1).add(vertex2);
        }

        if (!adjacencyList.get(vertex2).contains(vertex1)) {
            adjacencyList.get(vertex2).add(vertex1);
        }
    }

    // Remove an edge
    public void removeEdge(T vertex1, T vertex2) {

        if (adjacencyList.containsKey(vertex1)) {
            adjacencyList.get(vertex1).remove(vertex2);
        }

        if (adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex2).remove(vertex1);
        }
    }

    // Remove a vertex
    public void removeVertex(T vertex) {

        if (!adjacencyList.containsKey(vertex)) {
            return;
        }

        for (T neighbour : new ArrayList<>(adjacencyList.get(vertex))) {
            adjacencyList.get(neighbour).remove(vertex);
        }

        adjacencyList.remove(vertex);
    }

    // Search/check whether a vertex exists
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Check whether an edge exists
    public boolean containsEdge(T vertex1, T vertex2) {

        if (!adjacencyList.containsKey(vertex1)) {
            return false;
        }

        return adjacencyList.get(vertex1).contains(vertex2);
    }

    // Get neighbours
    public List<T> getNeighbours(T vertex) {

        if (!adjacencyList.containsKey(vertex)) {
            return new ArrayList<>();
        }

        return adjacencyList.get(vertex);
    }

    // Breadth First Search
    public void bfs(T startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Vertex does not exist");
            return;
        }

        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {

            T current = queue.remove();

            System.out.println(current);

            for (T neighbour : adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    // Depth First Search
    public void dfs(T startVertex) {

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Vertex does not exist");
            return;
        }

        Set<T> visited = new HashSet<>();

        dfsRecursive(startVertex, visited);
    }

    private void dfsRecursive(T current, Set<T> visited) {

        visited.add(current);

        System.out.println(current);

        for (T neighbour : adjacencyList.get(current)) {

            if (!visited.contains(neighbour)) {

                dfsRecursive(neighbour, visited);
            }
        }
    }

    // Display graph
    public void display() {

        for (T vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (T neighbour : adjacencyList.get(vertex)) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }
    }

    
}
