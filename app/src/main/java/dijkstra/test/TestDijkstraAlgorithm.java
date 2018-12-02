package dijkstra.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import buildings.csic.FirstFloor;
import buildings.csic.SecondFloor;
import buildings.csic.ThirdFloor;
import dijkstra.engine.DijkstraAlgorithm;
import dijkstra.model.Edge;
import dijkstra.model.Graph;
import dijkstra.model.Vertex;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestDijkstraAlgorithm {

    private List<Vertex> nodes;
    private List<Edge> edges;

    @Test
    public void testCsicThirdFloor() {
        nodes = new ArrayList<>(Arrays.asList(ThirdFloor.getVertices()));
        edges = new ArrayList<>();

        SecondFloor.addLanes(edges);

        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(ThirdFloor.getVertexByName("3105"));
        LinkedList<Vertex> path = dijkstra.getPath(ThirdFloor.getVertexByName("3120"));

        assertNotNull(path);
        assertTrue(!path.isEmpty());

        System.out.println(path);
    }

    @Test
    public void testCsicSecondFloor() {
        nodes = new ArrayList<>(Arrays.asList(SecondFloor.getVertices()));
        edges = new ArrayList<>();

        SecondFloor.addLanes(edges);

        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(SecondFloor.getVertexByName("2197"));
        LinkedList<Vertex> path = dijkstra.getPath(SecondFloor.getVertexByName("2120A"));

        assertNotNull(path);
        assertTrue(!path.isEmpty());

        System.out.println(path);
    }

    @Test
    public void testCsicFirstFloor() {
        nodes = new ArrayList<>(Arrays.asList(FirstFloor.getVertices()));
        edges = new ArrayList<>();

        FirstFloor.addLanes(edges);

        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(FirstFloor.getVertexByName("1115B"));
        LinkedList<Vertex> path = dijkstra.getPath(FirstFloor.getVertexByName("1103"));

        assertNotNull(path);
        assertTrue(!path.isEmpty());

        System.out.println(path);
    }
}