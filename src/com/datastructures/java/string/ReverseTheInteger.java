package com.datastructures.java.string;

public class ReverseTheInteger {

    public int reverse(int x) {
        boolean negative = false;
        if(x<0&&x>-2147483648){
            negative=true;
            x=x*-1;
        }else if(x<=-2147483648){
            return 0;
        }
        StringBuilder sb=new StringBuilder(String.valueOf(x));
        sb.reverse();
        Long re = negative?Long.valueOf("-"+sb.toString()):Long.valueOf(sb.toString());
        if(re>2147483647L||-2147483648L>re){
            return 0;
        }
        return re.intValue();
    }


}
