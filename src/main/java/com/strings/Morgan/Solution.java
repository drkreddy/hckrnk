package com.strings.Morgan;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static boolean nextStack(String a,String b,int i,int j){
        if(i<a.length() && j <b.length() && a.charAt(i)==b.charAt(j)){

           return nextStack(a,b,i+1,j+1);
        }

        if(i==a.length()){
            i--;
        }
        if(j==a.length()){
            j--;
        }
        return a.charAt(i)-b.charAt(j)<0;
    }
    static String morganAndString(String a, String b) {
        StringBuilder sb  = new StringBuilder("");

        int i=0,j=0,k=0;
        for(;i<a.length() && j<b.length();){
            if( a.charAt(i) == b.charAt(j) ) {
                sb.append(a.charAt(i));
                k++;
                i++;
                j++;
            }
            else if( a.charAt(i) < b.charAt(j)){
                sb.append(a.charAt(i));
                j=j-k;
                k=0;
                i++;
            }else {
                sb.append(b.charAt(j));
                i=i-k;
                k=0;
                j++;
            }
        }

        if( i == j && k >0 ){
            i=i-k;
        }

        if(i< a.length()){
            sb.append(a.substring(i));
        }
        if(j<b.length()){
            sb.append(b.substring(j));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String a = in.next();
            String b = in.next();
            String result = morganAndString(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
