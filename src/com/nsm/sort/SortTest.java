package com.nsm.sort;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
	public static void main(String[] args) {
		Random ran = new Random();
		int[] array1 = new int[100000000];
		int[] array2 = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = ran.nextInt(array1.length+1);
			array2[i] = array1[i];
		}
		long begin;
		long end;
		//System.out.println(Arrays.toString(array1));
		begin = System.currentTimeMillis()/1000;
		QuickSort.sort(array1);
		end = System.currentTimeMillis()/1000;
		//System.out.println(Arrays.toString(array1));
		System.out.println("QuickSort: "+(end-begin));
		
		//System.out.println(Arrays.toString(array2));
		begin = System.currentTimeMillis()/1000;
		MergeSort.sort(array2);
		end = System.currentTimeMillis()/1000;
		//System.out.println(Arrays.toString(array2));
		System.out.println("MergeSort: "+(end-begin));
		
	}
}
