package driver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import buildings.csic.FirstFloor;
import buildings.csic.SecondFloor;
import buildings.csic.ThirdFloor;
import dijkstra.engine.DijkstraAlgorithm;
import dijkstra.model.Edge;
import dijkstra.model.Graph;
import dijkstra.model.Vertex;

public class Driver {
    private static String origin;
    private static String destination;

    public static void main(String[] args) {
        promptInput();
        System.out.println(findPath(origin, destination));
    }

    private static LinkedList<Vertex> findPath(String origin, String destination) {
        List<Vertex> nodes = null;
        List<Edge> edges;
        LinkedList<Vertex> result = new LinkedList<>();
        Class clazz = null;
        char originFloor = origin.charAt(0);
        char destinationFloor = destination.charAt(0);

        try {
            switch (originFloor) {
                case '1':
                    clazz = Class.forName("buildings.csic.FirstFloor");
                    break;
                case '2':
                    clazz = Class.forName("buildings.csic.SecondFloor");
                    break;
                case '3':
                    clazz = Class.forName("buildings.csic.ThirdFloor");
                    break;
                default:
                    throw new UnsupportedOperationException("Error Floor Number!");
            }
            Vertex[] vertices = (Vertex[]) (clazz.getDeclaredMethod("getVertices").invoke(null));
            nodes = new ArrayList<>(Arrays.asList(vertices));

            edges = new ArrayList<>();
            clazz.getDeclaredMethod("addLanes", List.class).invoke(null, edges);

            Graph graph = new Graph(nodes, edges);
            DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

            Method getVertexByName = clazz.getDeclaredMethod("getVertexByName", String.class);
            Vertex vertex = (Vertex) (getVertexByName.invoke(null, origin));
            dijkstra.execute(vertex);


            if (originFloor == destinationFloor) {
                return dijkstra.getPath((Vertex) (getVertexByName.invoke(null, destination)));
            } else {
                String stair = Character.getNumericValue(originFloor) + "197";
                int shortestDistance;

                LinkedList<Vertex> stair1 = findPath(origin,
                        Character.getNumericValue(originFloor) + "197");
                Map<Vertex, Integer> distance = dijkstra.getDistance();
                shortestDistance = distance.get((Vertex) (getVertexByName.invoke(null,
                        Character.getNumericValue(originFloor) + "197")));

                if (distance.get((Vertex) (getVertexByName.invoke(null,
                        Character.getNumericValue(originFloor) + "196"))) < shortestDistance) {
                    stair = Character.getNumericValue(originFloor) + "196";
                    shortestDistance = distance.get((Vertex) (getVertexByName.invoke(null,
                            Character.getNumericValue(originFloor) + "196")));
                }
                if (distance.get((Vertex) (getVertexByName.invoke(null,
                        Character.getNumericValue(originFloor) + "193"))) < shortestDistance) {
                    stair = Character.getNumericValue(originFloor) + "193";
                }

                result.addAll(dijkstra.getPath((Vertex) (getVertexByName.invoke(null, stair))));
                result.addAll(findPath(
                        Character.getNumericValue(destinationFloor) + stair.substring(1), destination));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void promptInput() {
        Scanner s = new Scanner(System.in);

        System.out.print("Origin: ");
        origin = s.nextLine();
        while (!isRoomValid(origin)) {
            System.out.println("No room found! Retry: ");
            origin = s.nextLine();
        }

        System.out.print("Destination: ");
        destination = s.nextLine();
        while (!isRoomValid(destination)) {
            System.out.println("No room found! Retry: ");
            destination = s.nextLine();
        }
        s.close();
    }

    private static boolean isRoomValid(final String string) {
        if (string.isEmpty()) {
            return false;
        }
        switch (string.charAt(0)) {
            case '1':
                try {
                    FirstFloor.getVertexByName(string);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            case '2':
                try {
                    SecondFloor.getVertexByName(string);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            case '3':
                try {
                    ThirdFloor.getVertexByName(string);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            default:
                return false;
        }
    }
}
