import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
    public static void dijkstra(List<Vertex> vertexList, Vertex source, Vertex target) {
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>();

        for (Vertex v : vertexList) {
            v.distance = Double.POSITIVE_INFINITY;
            v.pred = null;
        }
        source.distance = 0.0;

        minHeap.add(source);

        while (!minHeap.isEmpty() && !minHeap.peek().equals(target)) {
            Vertex curr = minHeap.remove();
            visited.add(curr);

            for (VertexWithDistance neighbour : curr.neighbours) {
                if (!visited.contains(neighbour.v)) {
                    double calculatedDistance = curr.distance + neighbour.distance;

                    if (calculatedDistance < neighbour.v.distance) {
                        neighbour.v.distance = calculatedDistance;
                        neighbour.v.pred = curr;
                    }
                    minHeap.add(neighbour.v);
                }
            }
        }

        printPath(target);
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");

        a.neighbours = new VertexWithDistance[]{new VertexWithDistance(b, 2.0),
                new VertexWithDistance(c, 5.0)};
        b.neighbours = new VertexWithDistance[]{new VertexWithDistance(a, 2.0),
                new VertexWithDistance(c, 6.0),
                new VertexWithDistance(d, 1.0),
                new VertexWithDistance(e, 3.0)};
        c.neighbours = new VertexWithDistance[]{new VertexWithDistance(a, 5.0),
                new VertexWithDistance(b, 6.0),
                new VertexWithDistance(f, 8.0)};
        d.neighbours = new VertexWithDistance[]{new VertexWithDistance(b, 1.0),
                new VertexWithDistance(e, 4.0)};
        e.neighbours = new VertexWithDistance[]{new VertexWithDistance(b, 3.0),
                new VertexWithDistance(d, 4.0),
                new VertexWithDistance(g, 9.0)};
        f.neighbours = new VertexWithDistance[]{new VertexWithDistance(c, 8.0),
                new VertexWithDistance(g, 7.0)};
        g.neighbours = new VertexWithDistance[]{new VertexWithDistance(e, 9.0),
                new VertexWithDistance(f, 7.0)};

        dijkstra(Arrays.asList(a, b, c, d, e, f, g), a, g);
        dijkstra(Arrays.asList(a, b, c, d, e, f, g), a, b);
    }

    private static void printPath(Vertex v) {
        if (v != null) {
            printPath(v.pred);
            System.out.println(v.name);
        }
    }

    public static class VertexWithDistance {
        Vertex v;
        double distance;

        public VertexWithDistance(Vertex v, double distance) {
            this.v = v;
            this.distance = distance;
        }
    }

    public static class Vertex implements Comparable<Vertex> {
        String name;
        double distance;
        VertexWithDistance[] neighbours;
        Vertex pred;

        public Vertex(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Vertex v) {
            return Double.compare(distance, v.distance);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Vertex)) {
                return false;
            }

            Vertex v = (Vertex) o;
            return v == this || name.equals(v.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
}
