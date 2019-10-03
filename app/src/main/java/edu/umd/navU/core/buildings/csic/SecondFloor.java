package edu.umd.navU.core.buildings.csic;

import java.util.List;

import edu.umd.navU.core.dijkstra.model.Edge;
import edu.umd.navU.core.dijkstra.model.Vertex;

import static edu.umd.navU.core.buildings.Helper.addLane;

public class SecondFloor {
    private static final Vertex[] vertices = {
            new Vertex("2195"),
            new Vertex("2107"),
            new Vertex("2107A"),
            new Vertex("2109"),
            new Vertex("2111"),
            new Vertex("2113"),
            new Vertex("2197_A"),
            new Vertex("2197"),
            new Vertex("2196"),
            new Vertex("2197_B"),
            new Vertex("2198"),
            new Vertex("2105"),
            new Vertex("2101"),
            new Vertex("2199"),
            new Vertex("2103"),
            new Vertex("2117_A"),
            new Vertex("2118"),
            new Vertex("2118A"),
            new Vertex("2117"),
            new Vertex("2117_B"),
            new Vertex("2117A"),
            new Vertex("2117B"),
            new Vertex("2194"),
            new Vertex("2193"),
            new Vertex("2120"),
            new Vertex("2120A")};

    private SecondFloor() {
    }

    public static Vertex getVertexByName(String name) {
        for (Vertex vertex : vertices) {
            if (name.equals(vertex.getName())) {
                return vertex;
            }
        }
        throw new UnsupportedOperationException("No Vertex Found!");
    }

    public static Vertex[] getVertices() {
        return vertices;
    }

    public static void addLanes(List<Edge> edges) {
        addLane(getVertexByName("2195"), getVertexByName("2107"), 1.11, edges);
        addLane(getVertexByName("2107"), getVertexByName("2107A"), 0.38 + 3.06, edges);
        addLane(getVertexByName("2195"), getVertexByName("2109"), 0.47, edges);
        addLane(getVertexByName("2109"), getVertexByName("2111"), 0.55, edges);
        addLane(getVertexByName("2111"), getVertexByName("2113"), 0.32, edges);
        addLane(getVertexByName("2113"), getVertexByName("2197_A"), 0.79, edges);
        addLane(getVertexByName("2197_A"), getVertexByName("2197"), 1.0 / 2 + 0.03, edges);
        addLane(getVertexByName("2197_A"), getVertexByName("2197_B"), 1, edges);
        addLane(getVertexByName("2197_B"), getVertexByName("2197"), 1.0 / 2, edges);
        addLane(getVertexByName("2113"), getVertexByName("2196"), 0.83, edges);
        addLane(getVertexByName("2196"), getVertexByName("2197_B"), 1.3, edges);
        addLane(getVertexByName("2196"), getVertexByName("2117_A"), 0.98, edges);
        addLane(getVertexByName("2197_B"), getVertexByName("2198"), 1.91, edges);
        addLane(getVertexByName("2198"), getVertexByName("2105"), 0.57, edges);
        addLane(getVertexByName("2105"), getVertexByName("2101"), 0.62, edges);
        addLane(getVertexByName("2101"), getVertexByName("2199"), 0.64, edges);
        addLane(getVertexByName("2199"), getVertexByName("2103"), 0.3, edges);
        addLane(getVertexByName("2117_A"), getVertexByName("2118"), 2.94, edges);
        addLane(getVertexByName("2118"), getVertexByName("2117_B"), 1.15, edges);
        addLane(getVertexByName("2117_B"), getVertexByName("2117A"), 0, edges);
        addLane(getVertexByName("2117A"), getVertexByName("2117B"), 2.94 + 1.15, edges);
        addLane(getVertexByName("2118"), getVertexByName("2118A"), 2.04, edges);
        addLane(getVertexByName("2117_A"), getVertexByName("2117"), (2.94 + 1.15) / 2 + 0.02, edges);
        addLane(getVertexByName("2117_B"), getVertexByName("2117"), (2.94 + 1.15) / 2, edges);
        addLane(getVertexByName("2117_B"), getVertexByName("2194"), 1.6, edges);
        addLane(getVertexByName("2194"), getVertexByName("2193"), 1.57, edges);
        addLane(getVertexByName("2194"), getVertexByName("2120"), 0, edges);
        addLane(getVertexByName("2120"), getVertexByName("2120A"), 2.09, edges);
    }
}
