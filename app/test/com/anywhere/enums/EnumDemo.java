package com.anywhere.enums;

public class EnumDemo {
    
    private enum Color {
        RED, BLUE, GREEN
    }// there is not a ";"
    
    public static void main(String[] args) {
        for (Color s : Color.values()) {
            // enum的values()返回一个数组，这里就是Seasons[]
            System.out.println(s);
        }
    }
}