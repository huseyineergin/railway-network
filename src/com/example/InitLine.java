package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InitLine {
    private final ArrayList<LinkedList> lines;

    public InitLine() {
        lines = new ArrayList<>();
        createLines();
    }

    public ArrayList<LinkedList> getLines() {
        return lines;
    }

    private void createLines() {
        try {
            BufferedReader r = new BufferedReader(new FileReader("./lines/_lines.txt"));
            String lineCode;
            while ((lineCode = r.readLine()) != null) {
                String lineLocation = String.format("./lines/%s.txt", lineCode);
                LinkedList list = new LinkedList(TransportLine.findLine(lineCode));
                Files.lines(Paths.get(lineLocation)).forEach(stationName -> list.addBack(stationName.trim()));
                lines.add(list);
            }
            r.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
