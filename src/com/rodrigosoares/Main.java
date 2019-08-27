package com.rodrigosoares;

import com.rodrigosoares.readers.LineFileReader;
import com.rodrigosoares.trees.TreeBuilder;
import com.rodrigosoares.trees.TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Qual o nome do arquivo?");
        String fileName = reader.nextLine();
        ArrayList<String> lines = LineFileReader.readFileLines("src/com/rodrigosoares/" + fileName);
        TreeBuilder treeBuilder = new TreeBuilder(lines, ", ");
        System.out.println(treeBuilder.getRootNode().toString());
    }
}
