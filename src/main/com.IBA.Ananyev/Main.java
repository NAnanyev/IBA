package com.IBA.Ananyev;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by life_love_asap on 05.07.16.
 */

/*
Description: Your task is to find all different words in a text and calculate frequency.
Input: input.txt file
Output: output.txt - filename
first line - the number of diff words
the next lines contain couples of values: the word - quantity
Please, example in attach file
 */

public class Main {
    static String inputFile = "src/main/resources/input.txt";
    static String outputFile = "src/main/resources/output.txt";
    static String delimiters = "\t\n\r,. ";

    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    static FileInputStream fis = null;
    static BufferedReader input = null;
    static FileWriter writer = null;

    public static void main(String[] args) {
        readDataFromFile();
        writeDataToFile();
    }

    public static void readDataFromFile() {
        try {
            fis = new FileInputStream(inputFile);
            input = new BufferedReader(new InputStreamReader(fis));
            while (input.ready()) {
                String line = input.readLine();
                processData(line, delimiters);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void processData(String line, String delim) {
        try {
            int integ = Integer.parseInt(line);
        } catch (NumberFormatException isNumber) {
            StringTokenizer st = new StringTokenizer(line, delim);
            while (st.hasMoreTokens()) {
                String nextWord = st.nextToken().toUpperCase();
                if (map.containsKey(nextWord)) {
                    map.put(nextWord, map.get(nextWord) + 1);
                } else {
                    map.put(nextWord, 1);
                }
            }
        }
    }

    public static void writeDataToFile() {
        try {
            writer = new FileWriter(outputFile);
            writer.write(map.size() + "\n");
            writer.write(map.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
