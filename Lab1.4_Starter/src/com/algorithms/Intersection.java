package com.algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Intersection {

    public List<Integer> intersection(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>(a.length);
        for (int x : a) {
            for (int y : b) {
                if (x == y) result.add(x);
            }
        }
        return result;
    }

	public List<Integer> intersectionFast(int[]a, int[]b){
        List<Integer> results =new ArrayList<Integer>();
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        for(int indexA=0, indexB=0; indexA<a.length && indexB<b.length; ){
            if(a[indexA]==b[indexB]){
                results.add(a[indexA]);
                indexA++;
                indexB++;
            } else if (a[indexA]<b[indexB]) {
                indexA++;
            }
            else{
                indexB++;
            }
        }
        System.out.print(results);
        return results;
	}

    public List<Integer> intersectionHash(int[]a, int[]b){
        List<Integer> results =new ArrayList<Integer>();
        Set<Integer> setA= IntStream.of(a).boxed().collect(Collectors.toSet());
        return IntStream.of(b).boxed().filter((value)-> setA.contains(value)).collect(Collectors.toList());
    }

    public static void main(String args[]) {
        Intersection simpleIntersection = new Intersection();
//        System.out.println(simpleIntersection.intersection(new int[]{4, 7, 5, 2, 3}, new int[]{4, 2, 3, 9, 1}));

        System.out.print(simpleIntersection.intersectionHash(new int[]{4, 7, 5, 2, 3,9}, new int[]{4, 2, 3, 9, 1}));

    }
}
