package com.rodrigosoares.readers;

import java.io.*;
import java.util.ArrayList;

public class LineFileReader {
    /**
     * Reads the an text file and returns its lines as items from an ArrayList
     * @param filePath File path of the file to be read
     * @return An ArrayList of strings which every item of the ArrayList is a line of the file
     */
    public static ArrayList<String> readFileLines(String filePath) {
        File f = new File(filePath);
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader b = new BufferedReader(new FileReader(f))) {
            String readLine =  "";
            while ((readLine =  b.readLine()) != null) {
                lines.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}