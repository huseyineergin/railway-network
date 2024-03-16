package com.example;

import java.util.ArrayList;

public class LinkedList {

    private int size = 0;
    private Station last;
    private Station first;
    private final TransportLine transportLine;
    private final BSTree bsTree = BSTree.getInstance();

    public LinkedList(TransportLine transportLine) {
        this.transportLine = transportLine;
    }

    public void addBack(String stationName) {
        Station station = new Station(stationName, transportLine);

        if (size == 0) {
            first = last = station;
        } else {
            last.next = station;
            station.prev = last;
            last = station;
        }
        bsTree.insert(station);
        size++;
    }

    public static Station goNext(Station curr) {
        if (curr.next == null) {
            System.out.println("You're at the last station on this way.");
        } else {
            curr = curr.next;
        }
        return curr;
    }

    public static Station goPrev(Station curr) {
        if (curr.prev == null) {
            System.out.println("You're at the last station on this way.");
        } else {
            curr = curr.prev;
        }
        return curr;
    }

    public Station getLast() {
        return last;
    }

    public Station getFirst() {
        return first;
    }

    public TransportLine getMetroLine() {
        return transportLine;
    }

    public static class Station { // Node
        private Station prev;
        private Station next;
        private final String stationInfo;
        private final TransportLine transportLine;
        private final ArrayList<Station> transfers;

        public Station(String stationInfo, TransportLine transportLine) {
            transfers = new ArrayList<>();
            this.stationInfo = stationInfo;
            this.transportLine = transportLine;
        }

        public Station getPrev() {
            return prev;
        }

        public Station getNext() {
            return next;
        }

        public TransportLine getTransportLine() {
            return transportLine;
        }

        public ArrayList<Station> getTransfers() {
            return transfers;
        }

        public String getStationName() {
            return stationInfo.split("_")[0];
        }

        public String getTransferPoint() {
            String[] strings = stationInfo.split("_");
            if (strings.length == 2) {
                return strings[1];
            }
            return null;
        }
    }
}
