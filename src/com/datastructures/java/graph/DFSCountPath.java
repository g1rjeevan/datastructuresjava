package com.datastructures.java.graph;

import java.util.*;

public class DFSCountPath {

    //A->B->C
    //    \ |
    //      E->D

    public static void main(String[] args) {

        String[][] edges = {{"A","B"},{"B","C"},{"C","E"},{"E","D"}, {"B","E"}};
        //{"A", ["B"]}, {"B",["C","E"]}, {"C", ["E"]}, {"E",["D"]}
        HashMap<String, List<String>> nodes = new HashMap<>();

        for(String[] edge:edges){
            String src=edge[0], dst = edge[1];

            if(!nodes.containsKey(src)){
                nodes.put(src,new ArrayList<>());
            }
            if(!nodes.containsKey(dst)){
                nodes.put(dst,new ArrayList<>());
            }
            nodes.get(src).add(dst);
        }
        nodes.forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println(getDFSCountPath("A","E",nodes,new HashSet<>()));
    }

    public static int getDFSCountPath(String node, String target, HashMap<String,
            List<String>> nodes, HashSet<String> visits){
        int count= 0;


        if(visits.contains(node)){
            return 0;
        }

        if(Objects.equals(node, target)){
            return 1;
        }


        visits.add(node);
        for(String neighbour: nodes.get(node)){
            count+=getDFSCountPath(neighbour, target, nodes, visits);
        }
        System.out.println("removing node"+node);

        //visits.remove(node);
        return count;
    }


}
