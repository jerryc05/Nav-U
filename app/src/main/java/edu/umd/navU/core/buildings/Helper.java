package edu.umd.navU.core.buildings;

import java.util.List;

import edu.umd.navU.core.dijkstra.model.Edge;
import edu.umd.navU.core.dijkstra.model.Vertex;

public class Helper {
    private Helper() {
    }

    public static void addLane(Vertex vertex1, Vertex vertex2, double duration, List<Edge> edges) {
        int durationAsInt = (int) (duration * 10 * 10);
        Edge lane = new Edge(vertex1, vertex2, durationAsInt);
        edges.add(lane);
        lane = new Edge(vertex2, vertex1, durationAsInt);
        edges.add(lane);
    }
}
