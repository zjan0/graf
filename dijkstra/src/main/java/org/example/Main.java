package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void printGraph(int[][] graph) {
        int n = graph.length;
        System.out.println("Adjacency Matrix (Distances):");

        // Print column headers
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();

        System.out.print("   +");
        for (int i = 0; i < n; i++) {
            System.out.print("---+");
        }
        System.out.println();

        // Print rows with row headers
        for (int i = 0; i < n; i++) {
            System.out.print(" " + i + " |");
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) System.out.print("  . |");
                else System.out.printf("%3d|", graph[i][j]);
            }
            System.out.println();
        }
        System.out.println("\nLegend: '.' means no edge between nodes\n");
    }

    static void printDistances(int[] dist) {
        System.out.print("Distances: ");
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) System.out.print("∞ ");
            else System.out.print(d + " ");
        }
        System.out.println();
    }

    static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        dist[source] = 0;

        var pq = new PriorityQueue<Node>((a, b) -> Integer.compare(a.distance, b.distance));
        pq.add(new Node(source, 0));

        printGraph(graph);
        printDistances(dist);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            System.out.println("\nProcessing node " + u + ":");
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v] && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }

            printDistances(dist);
        }

        System.out.println("\nFinal shortest distances and paths from node " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " : ");
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("∞ (no path)");
            } else {
                System.out.print(dist[i] + " via ");
                printPath(prev, i);
                System.out.println();
            }
        }
    }

    static void printPath(int[] prev, int node) {
        if (node == -1) return;
        printPath(prev, prev[node]);
        System.out.print(node + " ");
    }

    static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                // 0  1  2  3  4
                { 0, 10, 0, 0, 5 },
                { 0, 0,  1, 0, 2 },
                { 0, 0,  0, 4, 0 },
                { 7, 0,  6, 0, 0 },
                { 0, 3,  9, 2, 0 }
        };

        dijkstra(graph, 0);
    }
}