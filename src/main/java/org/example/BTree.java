package org.example;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BTree {
    private int size = 0;
    private TreeNode root;
    private static BTree bTree;
    private static Locale locale;
    private static Collator collator;
    private static Map<String, ArrayList<LinkedList.Station>> transferMap;

    public static BTree getInstance() {
        if (bTree == null) {
            bTree = new BTree();
            transferMap = new HashMap<>();
            locale = new Locale("tr", "TR");
            collator = Collator.getInstance(locale);
        }
        return bTree;
    }

    public TreeNode findNode(String str) {
        TreeNode curr = root;
        str = str.trim().toLowerCase(locale);

        while (curr != null) {
            String nodeName = curr.stations.get(0).getStationName().toLowerCase(locale);

            if (collator.compare(str, nodeName) < 0) {
                curr = curr.left;
            } else if (collator.compare(str, nodeName) > 0) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }

    public void insert(LinkedList.Station station) {
        if (size == 0) {
            root = new TreeNode();
            root.stations.add(station);
        } else {
            TreeNode curr = root;
            String stationName = station.getStationName();

            while (curr != null) {
                String nodeName = curr.stations.get(0).getStationName();

                if (collator.compare(stationName, nodeName) < 0) {
                    if (curr.left != null) {
                        curr = curr.left;
                    } else {
                        TreeNode node = new TreeNode();
                        node.stations.add(station);
                        curr.left = node;
                        break;
                    }
                } else if (collator.compare(stationName, nodeName) > 0) {
                    if (curr.right != null) {
                        curr = curr.right;
                    } else {
                        TreeNode node = new TreeNode();
                        node.stations.add(station);
                        curr.right = node;
                        break;
                    }
                } else { // Same Occurence
                    curr.stations.add(station);
                    break;
                }
            }
        }
        // B1, M1B, M2B = 17
        String transferPoint = station.getTransferPoint();

        if (transferPoint != null) {
            ArrayList<LinkedList.Station> transfers = transferMap.get(transferPoint);

            if (transfers == null) {
                transfers = new ArrayList<>();
                transferMap.put(transferPoint, transfers);
                transferMap.get(transferPoint).add(station);
            } else {
                transfers.add(station);

                transfers.forEach(s -> {
                    if (s != station) {
                        s.getTransfers().add(station);
                        station.getTransfers().add(s);
                    }
                });
            }
        }

        size++;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        root.stations.forEach(station -> {
            System.out.println(station.getStationName() + ": " + station.getMetroLine());
        });

        inorder(root.right);
    }

    public TreeNode getRoot() {
        return root;
    }

    public static class TreeNode {

        private TreeNode left;
        private TreeNode right;
        private final ArrayList<LinkedList.Station> stations;

        public TreeNode() {
            stations = new ArrayList<>();
        }

        public ArrayList<LinkedList.Station> getStations() {
            return stations;
        }
    }
}
