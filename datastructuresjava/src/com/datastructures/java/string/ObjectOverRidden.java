package com.datastructures.java.string;

public class ObjectOverRidden {

    @Override
    public String toString() {
        //System.out.println(Integer.toHexString(hashCode()) + " " + this.hashCode());
        return Integer.toHexString(hashCode()) + " " + this.hashCode();
    }
}
