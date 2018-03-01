package com.strings.bearNGene;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean balanced(int N, Map<Character, Integer> map) {
        if (map.get('A') <= N && map.get('C') <= N && map.get('G') <= N
                && map.get('T') <= N)
            return true;

        return false;
    }

    public static int steadyGene(String s) {
        int N= s.length()/4;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        while (i < s.length() && j < s.length()) {
            if (!balanced(N, map)) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                System.out.print("j= "+j);
                System.out.println(map);
                j++;
            } else {
                min = Math.min(min, j - i);
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                System.out.print("i= "+i);
                System.out.println(map);
                i++;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int N = n / 4;
        String gene = in.next();
        int result = steadyGene(gene);
        System.out.println(result);
        in.close();
    }

}
