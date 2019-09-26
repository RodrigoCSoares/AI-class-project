package com.rodrigosoares;

import com.rodrigosoares.graphs.GraphNode;
import com.rodrigosoares.graphs.search.strategies.GraphSearchBreadthFirst;
import com.rodrigosoares.graphs.search.strategies.GraphSearchDepthFirst;
import com.rodrigosoares.graphs.search.strategies.GraphSearchUniformCost;
import com.rodrigosoares.readers.LineFileReader;
import com.rodrigosoares.graphs.GraphBuilder;
import com.rodrigosoares.graphs.search.GraphSearcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main class
 */
public class Main {

    /**
     * Main method
     *
     * @param args Software arguments, unused for now
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        //Read nodes file
        System.out.println("Qual o nome do arquivo?");
        String fileName = reader.nextLine();
        ArrayList<String> lines = LineFileReader.readFileLines("src/com/rodrigosoares/" + fileName, ';');

        //Search for a node
        GraphBuilder graphBuilder = new GraphBuilder(lines, ", ", GraphSearchUniformCost.class);
        GraphSearcher graphSearcher = new GraphSearcher(new GraphSearchUniformCost(graphBuilder.getGraphNodesHashMap()));
        LinkedList<GraphNode> linkedList = graphSearcher.pathBetween(lines.get(lines.size() - 2), lines.get(lines.size() - 1));
        System.out.println(pathToString(linkedList));
    }

    /**
     * Returns a String of the values of a graph node list
     *
     * @param path The path to used to generate the String
     * @return The String with the node's values
     */
    private static String pathToString(LinkedList<GraphNode> path) {
        StringBuilder print = new StringBuilder("[");
        for (int i = 0; i < path.size() - 1; i++) {
            print.append(path.get(i).getNodeValue()).append(", ");
        }
        return print.append(path.getLast().getNodeValue()).append("]").toString();
    }
}
