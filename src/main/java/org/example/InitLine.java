package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InitLine {
    private final ArrayList<LinkedList> lines;

    public InitLine() {
        lines = new ArrayList<>();
        createLines();
    }

    private void createB1() {
        LinkedList list = new LinkedList(MetroLine.B1);
        readStations("B1", list);
        lines.add(list);
    }

    private void createB2() {
        LinkedList list = new LinkedList(MetroLine.B2);
        readStations("B2", list);
        lines.add(list);
    }

    private void createBRT() {
        LinkedList list = new LinkedList(MetroLine.BRT);
        readStations("BRT", list);
        lines.add(list);
    }

    private void createF1() {
        LinkedList list = new LinkedList(MetroLine.F1);
        readStations("F1", list);
        lines.add(list);
    }

    private void createF2() {
        LinkedList list = new LinkedList(MetroLine.F2);
        readStations("F2", list);
        lines.add(list);
    }

    private void createF3() {
        LinkedList list = new LinkedList(MetroLine.F3);
        readStations("F3", list);
        lines.add(list);
    }

    private void createF4() {
        LinkedList list = new LinkedList(MetroLine.F4);
        readStations("F4", list);
        lines.add(list);
    }

    private void createM1A() {
        LinkedList list = new LinkedList(MetroLine.M1A);
        readStations("M1A", list);
        lines.add(list);
    }

    private void createM1B() {
        LinkedList list = new LinkedList(MetroLine.M1B);
        readStations("M1B", list);
        lines.add(list);
    }

    private void createM2A() {
        LinkedList list = new LinkedList(MetroLine.M2A);
        readStations("M2A", list);
        lines.add(list);
    }

    private void createM2B() {
        LinkedList list = new LinkedList(MetroLine.M2B);
        readStations("M2B", list);
        lines.add(list);
    }

    private void createM3() {
        LinkedList list = new LinkedList(MetroLine.M3);
        readStations("M3", list);
        lines.add(list);
    }

    private void createM4() {
        LinkedList list = new LinkedList(MetroLine.M4);
        readStations("M4", list);
        lines.add(list);
    }

    private void createM5() {
        LinkedList list = new LinkedList(MetroLine.M5);
        readStations("M5", list);
        lines.add(list);
    }

    private void createM6() {
        LinkedList list = new LinkedList(MetroLine.M6);
        readStations("M6", list);
        lines.add(list);
    }

    private void createM7() {
        LinkedList list = new LinkedList(MetroLine.M7);
        readStations("M7", list);
        lines.add(list);
    }

    private void createM8() {
        LinkedList list = new LinkedList(MetroLine.M8);
        readStations("M8", list);
        lines.add(list);
    }

    private void createM9() {
        LinkedList list = new LinkedList(MetroLine.M9);
        readStations("M9", list);
        lines.add(list);
    }

    private void createM11() {
        LinkedList list = new LinkedList(MetroLine.M11);
        readStations("M11", list);
        lines.add(list);
    }

    private void createT1() {
        LinkedList list = new LinkedList(MetroLine.T1);
        readStations("T1", list);
        lines.add(list);
    }

    private void createT2() {
        LinkedList list = new LinkedList(MetroLine.T2);
        readStations("T2", list);
        lines.add(list);
    }

    private void createT4() {
        LinkedList list = new LinkedList(MetroLine.T4);
        readStations("T4", list);
        lines.add(list);
    }

    private void createT5() {
        LinkedList list = new LinkedList(MetroLine.T5);
        readStations("T5", list);
        lines.add(list);
    }

    private void createLines() {
        createB1();
        createB2();
        createBRT();
        createF1();
        createF2();
        createF3();
        createF4();
        createM1A();
        createM1B();
        createM2A();
        createM2B();
        createM3();
        createM4();
        createM5();
        createM6();
        createM7();
        createM8();
        createM9();
        createM11();
        createT1();
        createT2();
        createT4();
        createT5();
    }

    public ArrayList<LinkedList> getLines() {
        return lines;
    }

    private void readStations(String fileName, LinkedList list) {
        String fileLocation = String.format("./lines/%s.txt", fileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
            String stationName = reader.readLine();

            while (stationName != null) {
                list.addBack(stationName.trim());
                stationName = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
