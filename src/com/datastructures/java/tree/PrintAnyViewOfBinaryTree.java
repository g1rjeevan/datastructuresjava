package com.datastructures.java.tree;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PrintAnyViewOfBinaryTree {


    public static void main(String[] vars) {
        Map<Integer, List<Integer>> result = new ConcurrentHashMap<>();
        NodeWithLevel nodeWithLevel = new NodeWithLevel(1, 1);
        nodeWithLevel.left = new NodeWithLevel(2, 2);
        nodeWithLevel.right = new NodeWithLevel(3, 2);
        NodeWithLevel nodeWithLevel34 = new NodeWithLevel(4, 3);
        nodeWithLevel.left.left = nodeWithLevel34;
        nodeWithLevel34.left = new NodeWithLevel(8, 4);
        nodeWithLevel34.right = new NodeWithLevel(9, 4);
        NodeWithLevel nodeWithLevel35 = new NodeWithLevel(5, 3);
        nodeWithLevel.left.right = nodeWithLevel35;
        nodeWithLevel35.left = new NodeWithLevel(10, 4);
        nodeWithLevel35.right = new NodeWithLevel(11, 4);
        NodeWithLevel nodeWithLevel36 = new NodeWithLevel(6, 3);
        nodeWithLevel.right.left = nodeWithLevel36;
        nodeWithLevel36.left = new NodeWithLevel(12, 4);
        nodeWithLevel36.right = new NodeWithLevel(13, 4);
        NodeWithLevel nodeWithLevel37 = new NodeWithLevel(7, 3);
        nodeWithLevel.right.right = nodeWithLevel37;
        nodeWithLevel37.left = new NodeWithLevel(14, 4);
        nodeWithLevel37.right = new NodeWithLevel(15, 4);
        PrintLeftView printLeftView = new PrintLeftView();
        printLeftView.printLeftView(nodeWithLevel, result);
        result.entrySet().stream().forEach(integerListEntry -> {
            System.out.print(integerListEntry.getKey() + "::");
            integerListEntry.getValue().stream().forEach(s -> {
                System.out.print(s + " ");
            });
            System.out.println("");
        });
    }
}


class NodeWithLevel {
    NodeWithLevel left, right;
    int data;
    int level;

    public NodeWithLevel(int data, int level) {
        this.data = data;
        this.left = this.right = null;
    }
}

/**
 * 1*                         1
 * 2*                  2             3
 * 3*             4       5       6      7
 * 4 *           8   9  10  11  12  13  14  15
 **/
class PrintLeftView {

    final Set<Integer> levelCheck = new HashSet<>();

    public void printLeftView(NodeWithLevel node, Map<Integer, List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (!levelCheck.contains(node.level)) {
            levelCheck.add(node.level);
            final List<Integer> dataList = new ArrayList<>();
            dataList.add(node.data);
            result.put(node.level, dataList);
        } else {
            final List<Integer> dataList = result.get(node.level);
            dataList.add(node.data);
            result.put(node.level, dataList);
        }
        printLeftView(node.left, result);
        printLeftView(node.right, result);
    }


}
