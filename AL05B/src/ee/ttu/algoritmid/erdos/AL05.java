package ee.ttu.algoritmid.erdos;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
public class AL05 {
    public Graph graph = new Graph();

    private class Graph {
        private Map<String, List<String>> graph = new HashMap<>();
        private Map<String, Integer> erdosNumbers = new HashMap<>();

        private void addDirectedEdge(String one, String other) {
            if (!graph.containsKey(one)) {
                List<String> edges = new ArrayList<>();
                edges.add(other);
                graph.put(one, edges);
            } else if (!graph.get(one).contains(other)) {
                graph.get(one).add(other);
            }
        }

        /**
         * Add undirected edge to the graph.
         * @param one   one element of the edge
         * @param other the other element of edge
         */
        public void addEdge(String one, String other) {
            addDirectedEdge(one, other);
            addDirectedEdge(other, one);
            if (!erdosNumbers.containsKey(one)) {
                erdosNumbers.put(one, -1);
            }
            if (!erdosNumbers.containsKey(other)) {
                erdosNumbers.put(other, -1);
            }
        }
        /**
         * Return the graph.
         * @return the internal graph structure.
         */
        public Map<String, List<String>> getGraph() {
            return graph;
        }
        /**
         * Perform breadth first search.
         * @param  goal the goal vertex to find
         * @return the Erdos number of goal or -1 if there is no chain of coauthors leading from Erdös to goal.
         * Note that search should always start from "Paul Erdös" whose Erdös number is 0.
         */
        public Integer breadthFirstSearch(String goal){

            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.add("Paul Erdös");
            erdosNumbers.put("Paul Erdös", 0);
            String first;
            while(!queue.isEmpty()) {

                first = queue.poll();

                for (String partner : graph.get(first)) {
                    if(!visited.contains(partner)) {
                        queue.add(partner);
                        erdosNumbers.put(partner, erdosNumbers.get(first) + 1);
                    }
                    if (goal.equals(partner)) {
                        return erdosNumbers.get(partner);
                    }
                }
                visited.add(first);
            }
            return -1;
        }
    }


    /**
     * Use buildGraphAndFindErdosNumber to build a graph using the Graph class and then use its breadthFirstSearch to
     * return the Erdos number.
     * @param  coauthors the list of people who have coauthored scientific papers as pairs (e.g., [["Juhan", "Jaan"], ["Juhan", "Siiri"]] means that "Juhan" has published with "Jaan" and "Siiri")
     * @param  scientist the name of the scientist whose Erdös number needs to be determined or -1 if it can`t be done
     * @return the Erdos number of the scientist
     */
    public Integer buildGraphAndFindErdosNumber(List<SimpleEntry<String, String>> coauthors,
                                                String scientist) {
        Graph graph = new Graph();
        for (SimpleEntry<String, String> entry: coauthors) {
            String key = entry.getKey();
            String value = entry.getValue();
            graph.addEdge(key, value);
        }
        return graph.breadthFirstSearch(scientist);

    }
}
