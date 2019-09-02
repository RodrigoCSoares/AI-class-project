package com.rodrigosoares;

import com.rodrigosoares.graphs.GraphNode;
import com.rodrigosoares.readers.LineFileReader;
import com.rodrigosoares.graphs.GraphBuilder;
import com.rodrigosoares.graphs.search.GraphSearcher;
import com.rodrigosoares.graphs.search.strategies.GraphSearchBreadthFirst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main class
 */
public class Main {

    /**
     * Main method
     * @param args Software arguments, unused for now
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        //Read nodes file
        System.out.println("Qual o nome do arquivo?");
        String fileName = reader.nextLine();
        ArrayList<String> lines = LineFileReader.readFileLines("src/com/rodrigosoares/" + fileName, ';');

        //Search for a node
        GraphBuilder graphBuilder = new GraphBuilder(lines, ", ");
        GraphSearcher graphSearcher = new GraphSearcher (new GraphSearchBreadthFirst(graphBuilder.getGraphNodesHashMap()));
        LinkedList<GraphNode> linkedList  = graphSearcher.pathBetween(lines.get(lines.size() - 2), lines.get(lines.size() - 1));
        System.out.println(linkedList.size());
    }
}
