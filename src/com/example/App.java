package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final ArrayList<LinkedList> LINES = new InitLine().getLines();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final BSTree BS_TREE = BSTree.getInstance();
    private static LinkedList.Station currStation;
    private static BSTree.TreeNode currNode;
    private static LinkedList currLine;

    public static void main(String[] args) {
        startLocation();
        startMoving();
    }

    private static void startLocation() {
        System.out.print("Enter Starting Station: ");
        String startingStation = SCANNER.nextLine();
        currNode = BS_TREE.findNode(startingStation);

        if (currNode == null) {
            message("station");
            startLocation();
        }

        if (currNode.getStations().size() > 1) {
            System.out.println("\nSelect Starting Line:");
            ArrayList<LinkedList.Station> stations = currNode.getStations();

            stations.forEach(station -> System.out.println((stations.indexOf(station) + 1) + ". " + station.getTransportLine()));
            System.out.println("0. Exit");
            String startingLine = SCANNER.nextLine();

            switch (startingLine) {
                case "0" -> {

                }
                case "1" -> {
                    currStation = stations.get(0);
                    currLine = getLine();
                }
                case "2" -> {
                    currStation = stations.get(1);
                    currLine = getLine();
                }
                case "3" -> {
                    if (stations.size() > 2) {
                        currStation = stations.get(2);
                        currLine = getLine();
                    } else {
                        message("line");
                        startLocation();
                    }
                }
                case "4" -> {
                    if (stations.size() > 3) {
                        currStation = stations.get(3);
                        currLine = getLine();
                    } else {
                        message("line");
                        startLocation();
                    }
                }
                default -> {
                    message("line");
                    startLocation();
                }
            }
        } else {
            currStation = currNode.getStations().get(0);
            currLine = getLine();
        }
        System.out.println();
    }

    private static void startMoving() {
        if (currLine != null) {
            System.out.println("You're at line " + currLine.getMetroLine().getLineName() + ". Current station is " + currStation.getStationName() + ".");
            System.out.println("Select Direction:");

            if (currStation.getPrev() != null) {
                System.out.println("1. to " + currLine.getFirst().getStationName() + ".");
            }
            if (currStation.getNext() != null) {
                System.out.println("2. to " + currLine.getLast().getStationName() + ".");
            }
            System.out.println("0. Exit");
            String direction = SCANNER.nextLine();

            switch (direction) {
                case "0" -> {

                }
                case "1" -> {
                    if (currStation.getPrev() != null) {
                        currStation = LinkedList.goPrev(currStation);
                    }
                    System.out.println();
                    transfer();
                }
                case "2" -> {
                    if (currStation.getNext() != null) {
                        currStation = LinkedList.goNext(currStation);
                    }
                    System.out.println();
                    transfer();
                }
                default -> {
                    message("direction");
                    startMoving();
                }
            }
        }
    }

    private static void transfer() {
        ArrayList<LinkedList.Station> transfers = currStation.getTransfers();

        if (transfers.size() != 0) {
            System.out.println("You're at line " + currLine.getMetroLine().getLineName() + ". Current station is " + currStation.getStationName() + ".");
            System.out.println("At this station, you can transfer to other lines:");
            transfers.forEach(station -> {
                System.out.println((transfers.indexOf(station) + 1) + ". " + station.getTransportLine());
            });

            if (currStation.getPrev() != null) {
                System.out.println("3. Don't transfer, to " + currLine.getFirst().getStationName() + ".");
            }
            if (currStation.getNext() != null) {
                System.out.println("4. Don't transfer, to " + currLine.getLast().getStationName() + ".");
            }
            System.out.println("0. Exit");

            String transfer = SCANNER.nextLine();
            switch (transfer) {
                case "0" -> {

                }
                case "1" -> {
                    currStation = transfers.get(0);
                    currLine = getLine();
                    System.out.println();
                    transfer();
                }
                case "2" -> {
                    if (transfers.size() > 1) {
                        currStation = transfers.get(1);
                        currLine = getLine();
                    }
                    System.out.println();
                    transfer();
                }
                case "3" -> {
                    if (currStation.getPrev() != null) {
                        currStation = LinkedList.goPrev(currStation);
                    }
                    System.out.println();
                    transfer();
                }
                case "4" -> {
                    if (currStation.getNext() != null) {
                        currStation = LinkedList.goNext(currStation);
                    }
                    System.out.println();
                    transfer();
                }
                default -> {
                    System.out.println();
                    transfer();
                }
            }
        } else {
            startMoving();
        }
    }

    private static void message(String s) {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + String.format("\n===== Invalid %s. =====\n", s) + ANSI_RESET);
    }

    private static LinkedList getLine() {
        return LINES.stream().filter(line -> line.getMetroLine() == currStation.getTransportLine()).toList().get(0);
    }
}
