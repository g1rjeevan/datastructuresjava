package com.datastructures.java.array;

import java.util.*;

public class GroupAnagramString {

    public static void main(String[] args) {
        new GroupAnagramString().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();

        for(String s: strs){
            String c = getSortedArray(s);
            List<String> lString;
            if(groupMap.containsKey(c)){
                lString = groupMap.get(c);
                lString.add(s);
                groupMap.remove(c);
                groupMap.put(c, lString);
            }else{
                lString = new ArrayList<>();
                lString.add(s);
                groupMap.put(c, lString);
            }
        }
        List ys = new ArrayList(groupMap.values());
        System.out.println(ys);
        return ys;
    }

    public static String getSortedArray(String s){
        char[] cS = s.toCharArray();
        Arrays.sort(cS);
        return String.valueOf(cS);
    }

}
