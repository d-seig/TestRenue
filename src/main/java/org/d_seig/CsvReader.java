package org.d_seig;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {
    private static CsvReader instance = null;
    private List<String> buffer;
    private String filename;

    private CsvReader() {
        buffer = new ArrayList<>(100); // initial capacity equals 100, 'cause memory extracting only for a 100 element's list

    }
    public static CsvReader getInstance() {
        if(instance == null) {
            return new CsvReader();
        }
        return instance;
    }

    public void setFilename(String newFilename) {
        filename = newFilename;
    }
    public String getFilename() {
        return filename;
    }
    public void readFile() throws FileNotFoundException {
        buffer.clear();
        Scanner scanner = new Scanner(new File("\\Users\\vadim\\Downloads\\airports.csv")); // path to airports.csv
        scanner.useDelimiter(",");
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append(scanner.next() + "|");
        //buffer.add(stringBuilder.toString());
        /*while(scanner.hasNext()) {
            buffer.add(scanner.nextLine() + "|");
        }*/
        for(int j = 0; j < 4; ++j) {
            for (int i = 0; i < 13; i++) {
                String temp = scanner.next().replace("\"", "\\\"") + "|";
                System.out.println("Scanner string is a " + temp);
                stringBuilder.append(temp);//scanner.next().replace("\"", "\\\"") + "|");
            }
        }
        String temp_2 = scanner.next().replace("\"", "") + "|";
        // temp_2 == LAST COLUMN + \n + NEXT FIRST COLUMN
        //stringBuilder.append(scanner.next().replace("\"", "\\\"") + "|")
        //buffer.add(stringBuilder.toString());
        if(buffer.size() == 0) {
            buffer.add(stringBuilder.toString() + temp_2.substring(0, temp_2.length() - 2));
        } else {
            buffer.set(buffer.size() - 1, buffer.get(buffer.size() - 1) + temp_2.substring(0, temp_2.length() - 2));
        }
        buffer.add(temp_2.substring(temp_2.length() - 2));
        System.out.println("Done");
    }
    public void printBuffer() {
        for (int i = 0; i < buffer.size(); ++i) {
            System.out.println(buffer.get(i));
        }
    }

    public List<String> setFilters(String filters) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("\\Users\\vadim\\Downloads\\airports.csv"));
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()) {
            String tmp = reader.readLine();
            if (tmp.contains("")) {
                list.add(tmp);
            }
        }
        reader.close();
        return list;
    }
    public void printFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("\\Users\\vadim\\Downloads\\airports.csv")); // path to airports.csv
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }

}
