package com.rodrigosoares;

import com.rodrigosoares.readers.LineFileReader;
import com.rodrigosoares.trees.TreeBuilder;
import com.rodrigosoares.trees.TreeNode;
import com.rodrigosoares.trees.search.TreeSearcher;
import com.rodrigosoares.trees.search.strategies.TreeSearchDepthFirst;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        //Read nodes file
        System.out.println("Qual o nome do arquivo?");
        String fileName = reader.nextLine();
        ArrayList<String> lines = LineFileReader.readFileLines("src/com/rodrigosoares/" + fileName);

        //Search for a node
        System.out.println("Qual o valor que deseja buscar?");
        String nodeValue = reader.nextLine();
        TreeBuilder treeBuilder = new TreeBuilder(lines, ", ");
        TreeSearcher treeSearcher = new TreeSearcher(new TreeSearchDepthFirst(treeBuilder.getRootNode()));
        System.out.println(treeSearcher.hasTreeNode(nodeValue));
    }
}
