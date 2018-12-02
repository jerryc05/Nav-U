package dijkstra.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dijkstra.engine.DijkstraAlgorithm;
import dijkstra.model.Edge;
import dijkstra.model.Graph;
import dijkstra.model.Vertex;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OfficialTestCase {

    private List<Vertex> nodes;
    private List<Edge> edges;

    @Test
    public void testExecute() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Path_0", 0, 1, 85);
        addLane("Path_1", 0, 2, 217);
        addLane("Path_2", 0, 4, 173);
        addLane("Path_3", 2, 6, 186);
        addLane("Path_4", 2, 7, 103);
        addLane("Path_5", 3, 7, 183);
        addLane("Path_6", 5, 8, 250);
        addLane("Path_7", 8, 9, 84);
        addLane("Path_8", 7, 9, 167);
        addLane("Path_9", 4, 9, 502);
        addLane("Path_10", 9, 10, 40);
        addLane("Path_11", 1, 10, 600);

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

        assertNotNull(path);
        assertTrue(!path.isEmpty());

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }


    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}
