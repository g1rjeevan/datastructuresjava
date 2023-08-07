package com.datastructures.java.array;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequence {

    public static void main(String[] args) {


        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;
        int[] sa= topKFrequentOnn(nums, k);
        int[] ssa= topKFrequentOnLogn(nums, k);
        System.out.println(LocalDateTime.now());

        Arrays.stream(sa).forEach(x->System.out.println(x+","));
        System.out.println(LocalDateTime.now());

        System.out.println(LocalDateTime.now());
        Arrays.stream(ssa).forEach(x->System.out.println(x+","));
        System.out.println(LocalDateTime.now());


    }
    public static int[] topKFrequentOnLogn(int[] nums, int k){
        final int[] distinct = new int[k];

        final Map<Integer,Integer> map = new HashMap<>();

        final PriorityQueue<Map.Entry<Integer,Integer>> pq =
                new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        int counter=0;

        for(int i: nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(entry);
        }
        while(k>0){
            distinct[counter++] = pq.poll().getKey();
            k--;
        }
        return distinct;
    }

    public static int[] topKFrequentOnn(int[] nums, int k) {
        int[] distinct = new int[k];
        final int[] counter = {0};
        final int[] sK = {k};
        if (k <= 0) {
            return new int[]{};
        }
        if (nums.length == k) {
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> in = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int c = map.get(nums[i]);
                c++;
                map.put(nums[i], c);
            } else {
                map.put(nums[i], 1);
                in.add(nums[i]);
            }
        }
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).forEach(entry -> {
                    if (sK[0] < 0) {
                        distinct[counter[0]++] = entry.getKey();
                        sK[0]--;
                    }
                });

        return distinct;
    }
}
