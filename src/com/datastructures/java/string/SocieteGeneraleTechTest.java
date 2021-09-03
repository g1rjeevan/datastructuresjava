package com.datastructures.java.string;

import java.util.*;

public class SocieteGeneraleTechTest {

    static class Pair extends ObjectOverRidden {
        String a;
        String b;

        Pair(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;
            System.out.println(o.toString());
            System.out.println(o.hashCode());
            return Objects.equals(a, pair.a) && Objects.equals(b, pair.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, "jeevan");
        }
    }

    static class Entry {
        Pair key;
        int value;

        Entry(Pair key, int value) {
            this.key = key;
            this.value = value;
        }

    }


    public static void main(String... args) {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(new Pair("one", "1"), 1));
        entries.add(new Entry(new Pair("two", "2"), 2));
        entries.add(new Entry(new Pair("three", "3"), 3));
        entries.add(new Entry(new Pair("four", "4"), 4));
        entries.add(new Entry(new Pair("five", "5"), 5));
        System.out.println(getFindEntriesGetValue(entries, new Entry(new Pair("five", "5"), 5)));
        Map<Pair, Integer> pairMap = new HashMap();
        pairMap.put(new Pair("one", "1"), 1);
        pairMap.put(new Pair("two", "2"), 2);
        pairMap.put(new Pair("three", "3"), 3);
        pairMap.put(new Pair("four", "4"), 4);
        pairMap.put(new Pair("five", "5"), 5);
        System.out.println(pairMap.get(new Pair("five", "5")));
    }

    private static int getFindEntriesGetValue(List<Entry> entries, Entry entry) {
        for (Entry ent : entries) {
            if (ent.key.a == entry.key.a && ent.key.b == entry.key.b) {
                return ent.value;
            }
        }
        return -1;
    }


}
