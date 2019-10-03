package edu.umd.navU.core.buildings.csic;

import java.util.List;

import edu.umd.navU.core.dijkstra.model.Edge;
import edu.umd.navU.core.dijkstra.model.Vertex;

import static edu.umd.navU.core.buildings.Helper.addLane;

public class FirstFloor {
    private static final Vertex[] vertices = {
            new Vertex("1199"),
            new Vertex("1120"),
            new Vertex("1196"),
            new Vertex("1195"),
            new Vertex("1109"),
            new Vertex("1107"),
            new Vertex("11XX"),
            new Vertex("1111"),
            new Vertex("1112"),
            new Vertex("1113"),
            new Vertex("1197"),
            new Vertex("1121_A"),
            new Vertex("1122_A"),
            new Vertex("1122"),
            new Vertex("1122A"),
            new Vertex("1121_B"),
            new Vertex("1122_B"),
            new Vertex("1192"),
            new Vertex("1193"),
            new Vertex("1121"),
            new Vertex("1121A"),
            new Vertex("1119"),
            new Vertex("1117"),
            new Vertex("1115"),
            new Vertex("1115A"),
            new Vertex("1115B"),
            new Vertex("1105"),
            new Vertex("1101"),
            new Vertex("1103")
    };

    private FirstFloor() {
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
        addLane(getVertexByName("1199"), getVertexByName("1105"), 0.42, edges);
        addLane(getVertexByName("1199"), getVertexByName("1120"), 1.5, edges);
        addLane(getVertexByName("1105"), getVertexByName("1101"), 0.6, edges);
        addLane(getVertexByName("1101"), getVertexByName("1103"), 0.93, edges);
        addLane(getVertexByName("1120"), getVertexByName("1121_A"), 3, edges);
        addLane(getVertexByName("1120"), getVertexByName("1197"), 2.5, edges);
        addLane(getVertexByName("1199"), getVertexByName("1197"), 2.5, edges);
        addLane(getVertexByName("1197"), getVertexByName("1196"), 1.22, edges);
        addLane(getVertexByName("1196"), getVertexByName("1109"), 1.58, edges);
        addLane(getVertexByName("1109"), getVertexByName("1107"), 0.81, edges);
        addLane(getVertexByName("1107"), getVertexByName("11XX"), 0.5, edges);
        addLane(getVertexByName("1196"), getVertexByName("1195"), 0.78 + 3, edges);
        addLane(getVertexByName("1195"), getVertexByName("1111"), 0.02, edges);
        addLane(getVertexByName("1111"), getVertexByName("1112"), 0, edges);
        addLane(getVertexByName("1111"), getVertexByName("1113"), 1.53, edges);
        addLane(getVertexByName("1112"), getVertexByName("1113"), 1.53, edges);
        addLane(getVertexByName("1199"), getVertexByName("1119"), 4.5, edges);
        addLane(getVertexByName("1119"), getVertexByName("1117"), 1.16, edges);
        addLane(getVertexByName("1117"), getVertexByName("1115"), 0.5, edges);
        addLane(getVertexByName("1115"), getVertexByName("1115A"), 1.3 + 3.1, edges);
        addLane(getVertexByName("1115A"), getVertexByName("1115B"), 0.6, edges);
        addLane(getVertexByName("1199"), getVertexByName("1121_A"), 4.1, edges);
        addLane(getVertexByName("1121_A"), getVertexByName("1196"), 2.5, edges);
        addLane(getVertexByName("1121_A"), getVertexByName("1121"), 1.5, edges);
        addLane(getVertexByName("1121"), getVertexByName("1121A"), 2, edges);
        addLane(getVertexByName("1121_A"), getVertexByName("1122_A"), 1.5, edges);
        addLane(getVertexByName("1122_A"), getVertexByName("1122"), 1.3, edges);
        addLane(getVertexByName("1122"), getVertexByName("1122A"), 1.3, edges);
        addLane(getVertexByName("1122_A"), getVertexByName("1121_B"), 1.5, edges);
        addLane(getVertexByName("1121_B"), getVertexByName("1121"), 1.52, edges);
        addLane(getVertexByName("1121_B"), getVertexByName("1122_B"), 1.1, edges);
        addLane(getVertexByName("1122_B"), getVertexByName("1122"), 1.32, edges);
        addLane(getVertexByName("1122_B"), getVertexByName("1192"), 0.56, edges);
        addLane(getVertexByName("1192"), getVertexByName("1193"), 1.3, edges);
    }
}