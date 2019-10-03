package edu.umd.navU.core.buildings.csic;

import java.util.List;

import edu.umd.navU.core.dijkstra.model.Edge;
import edu.umd.navU.core.dijkstra.model.Vertex;

import static edu.umd.navU.core.buildings.Helper.addLane;

public class ThirdFloor {
    private static final Vertex[] vertices = {
            new Vertex("3195"),
            new Vertex("3107"),
            new Vertex("3107A"),
            new Vertex("3109"),
            new Vertex("3111"),
            new Vertex("3113"),
            new Vertex("3197_A"),
            new Vertex("3197"),
            new Vertex("3196"),
            new Vertex("3197_B"),
            new Vertex("3198"),
            new Vertex("3105"),
            new Vertex("3101"),
            new Vertex("3199"),
            new Vertex("3103"),
            new Vertex("3117_A"),
            new Vertex("3118"),
            new Vertex("3118A"),
            new Vertex("3117"),
            new Vertex("3117_B"),
            new Vertex("3117A"),
            new Vertex("3117B"),
            new Vertex("3194"),
            new Vertex("3193"),
            new Vertex("3120"),
            new Vertex("3120A")};

    private ThirdFloor() {
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
        addLane(getVertexByName("3195"), getVertexByName("3107"), 1.11, edges);
        addLane(getVertexByName("3107"), getVertexByName("3107A"), 0.38 + 3.06, edges);
        addLane(getVertexByName("3195"), getVertexByName("3109"), 0.47, edges);
        addLane(getVertexByName("3109"), getVertexByName("3111"), 0.55, edges);
        addLane(getVertexByName("3111"), getVertexByName("3113"), 0.32, edges);
        addLane(getVertexByName("3113"), getVertexByName("3197_A"), 0.79, edges);
        addLane(getVertexByName("3197_A"), getVertexByName("3197"), 1.0 / 2 + 0.02, edges);
        addLane(getVertexByName("3197_A"), getVertexByName("3197_B"), 1, edges);
        addLane(getVertexByName("3197_B"), getVertexByName("3197"), 1.0 / 2, edges);
        addLane(getVertexByName("3113"), getVertexByName("3196"), 0.83, edges);
        addLane(getVertexByName("3196"), getVertexByName("3197_B"), 1.3, edges);
        addLane(getVertexByName("3196"), getVertexByName("3117_A"), 0.98, edges);
        addLane(getVertexByName("3197_B"), getVertexByName("3198"), 1.91, edges);
        addLane(getVertexByName("3198"), getVertexByName("3105"), 0.57, edges);
        addLane(getVertexByName("3105"), getVertexByName("3101"), 0.62, edges);
        addLane(getVertexByName("3101"), getVertexByName("3199"), 0.64, edges);
        addLane(getVertexByName("3199"), getVertexByName("3103"), 0.3, edges);
        addLane(getVertexByName("3117_A"), getVertexByName("3118"), 2.94, edges);
        addLane(getVertexByName("3118"), getVertexByName("3117_B"), 1.15, edges);
        addLane(getVertexByName("3117_B"), getVertexByName("3117A"), 0, edges);
        addLane(getVertexByName("3117A"), getVertexByName("3117B"), 2.94 + 1.15, edges);
        addLane(getVertexByName("3118"), getVertexByName("3118A"), 2.04, edges);
        addLane(getVertexByName("3117_A"), getVertexByName("3117"), (2.94 + 1.15) / 2 + 0.02, edges);
        addLane(getVertexByName("3117_B"), getVertexByName("3117"), (2.94 + 1.15) / 2, edges);
        addLane(getVertexByName("3117_B"), getVertexByName("3194"), 1.6, edges);
        addLane(getVertexByName("3194"), getVertexByName("3193"), 1.57, edges);
        addLane(getVertexByName("3194"), getVertexByName("3120"), 0, edges);
        addLane(getVertexByName("3120"), getVertexByName("3120A"), 2.09, edges);
    }
}
