package org.d_seig;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Scanner console = new Scanner(System.in);

        CsvReader reader = CsvReader.getInstance();

        System.out.println("Hello world!");

        long startTime = System.nanoTime();

        //CsvReader.getInstance().printFile();
        ArrayList<String> list = new ArrayList<>(readFileByFilter("\\Users\\vadim\\Downloads\\airports.csv", "Bower"));
        //reader.readFile();

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        //reader.printBuffer();

        for(int i = 0; i < list.size(); ++i) {
            System.out.println("Founded: " + list.get(i));
        }

        System.out.println("\nDuration is a " + duration/1000000 + " millis");

        //filters();
        //System.out.println("Equation is" + setFilters("column[1]>10&column[5]='QEK'"));

         */
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        int[] values = new int[2];
        for(int i = 0; i < values.length; ++i) {
            values[i] = Integer.parseInt(in.readLine());
        }
        System.out.println(Sum(values[0], values[1]));
    }
    static int Sum(int x, int y) {
        return x + y;
    }
    public static void filters(String filters) {
        String regex = "";
        Scanner console = new Scanner(System.in);
        StringBuilder workString = new StringBuilder(), readString = new StringBuilder();
        while (!workString.toString().equals("!quit")) {
            //workString.append(console.nextLine());
            System.out.println("Please enter filters" +
                    " in format: \n" +
                    " column[<number from 1 till 14>]<operations <, =, >, <> (like non-equal)><logical operations & (like AND), || (like OR)>...");
            switch (workString.append(console.nextLine()).toString()) {
                case "column":
            }
            System.out.println("Searching...");

        }

    }

    public static long getTimeOfRunningFunction(){
        long startTime = System.nanoTime();

        //function

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        return duration;
    }

    public static List<String> readFileByFilter(String fileName, String filter) throws IOException { // buffered need to change to streams

        BufferedReader reader = new BufferedReader/*(new InputStreamReader(new FileInputStream("\\Users\\vadim\\Downloads\\airports.csv")));*/(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        //System.out.println("Number of lines is a " + reader.lines().count());
        reader.lines().forEach(System.out::println);

        while (reader.ready()) {
            String tmp = reader.readLine();

            //String[] strings = tmp.split(","); // delimiter string


            if (tmp.contains(filter)) { // have to rewriting
                list.add(tmp);
            }
        }
        reader.close();

        return list;
    }

    private static String findByFilter(String[] str, String filter) {
        String regex = "\\[([1-9]|1[0-4])\\]|([><=]{1,2})|([&,|]{1,2})|(-?(0|[1-9]\\d+)\\.(\\d+)?)|(0|[1-9]\\d+)|[’,',\\\"][a-zA-Z, ]+[’,',\\\"]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(filter);


        if((filter.matches(regex) && filter.contains("column")) || filter.matches(regex)) {
            //matcher.find();
            //String match = matcher.group();
            int iterator = 1;
            while (matcher.find()) {
                String match = matcher.group();
                int number_1 = 0, number_2 = 0;
                if (match.contains("[")) number_1 = Integer.parseInt(match.substring(1, match.length() - 2)) - 1;// 1 match is [<number>]
                else if (match.equals("<")) {
                    if(Integer.parseInt(str[number_1]) < Integer.parseInt(matcher.group())) { // for int columns

                    }
                }
                else if (match.equals(">")) {
                    if(Integer.parseInt(str[number_1]) > Integer.parseInt(matcher.group())) { // for int columns

                    }
                }
                else if (match.equals("=")) {
                    if(Integer.parseInt(str[number_1]) == Integer.parseInt(matcher.group())) { // for int or string columns

                    }
                }
                else if (match.equals("<>")) {
                    if(Integer.parseInt(str[number_1]) != Integer.parseInt(matcher.group())) { // for int or string columns

                    }
                }
                /*
                switch (iterator) {
                    case 1: // 1 match is [<number>]
                        int number = Integer.parseInt(match.substring(1, match.length() - 2)); // test solution // extract number
                        iterator++;
                        break;
                    case 2: // 2 match is param(<, >, =, <>)
                        //if (match.equals("<"))
                        iterator++;
                        break;
                    case 3: // 3 match is value

                        iterator++;
                        break;
                    case 4: // 4 match is logical operator

                        iterator = 1;
                        break;
                }*/
            }
        }

        return "";
    }
    public static boolean setFilters(String textFilters) {
        boolean filters = false;
        ArrayList<Object> columns;
        String regexp = "[0-9]{1-4}||[<>=]||<>||[&|]{2}||'[A-Z]{1-3}'"; // find numbers // or find operators
        // first number is column
        // first operator is operator
        // second number is value for a filter
        // second operator is logical operator

        if(textFilters.contains("column[")) {// find columns in string
            //columns.add();

            // column[1]>10&column[5]='QEK' is test string
            // need to find indexes '[' and ']' symbols
            // and number between them
            // after it, next symbol (after ']') will be operator '<', '>', '=', '<>'
            // after it, need to find logical operator
            // end or repeat it


        }

        return filters;
    }

    /*private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) { // Enter was pressed. Your code goes here.

            String[] lines = jTextArea1.getText().split("\\n");
            int nline = lines.length;
            String sCommand = lines[nline - 1];
            sCommand = sCommand.replaceAll("<< ", "");
            System.out.println("sCommand =: |" + sCommand + "|");

            if (sCommand.equals("quit")) {
                quitFlag = true;
                appendString("Are you sure (yes/no)?\n");
                // finalizing code goes here return;
            }

            if (sCommand.equals("Yes") || sCommand.equals("yes") || sCommand.equals("y")) {
                if (quitFlag) {
                    System.out.println("User confirmed quit");
                    Path p = Paths.get("./data/varmap.dat");
                    varmap.writeMap(p);
                    System.exit(0);
                }
            }

            if (sCommand.equals("No") || sCommand.equals("no") ||
                    sCommand.equals("n")) {
                if (quitFlag) {
                    System.out.println("User cancelled quit");
                    quitFlag = false;
                    jTextArea1.append("\n\n<< ");
                    return;
                }

                if (sCommand.equals("cls")) {
                    int nlineCount = jTextArea1.getLineCount();
                    System.out.println("nlineCount =: " + nlineCount);
                    sCommand = sCommand.replaceAll("<< ", "");
                    jTextArea1.setText("");
                    jTextArea1.selectAll();
                    jTextArea1.append("<< ");
                    return;
                }
            }
        }
    }

     */
}