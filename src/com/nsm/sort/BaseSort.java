package com.nsm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BaseSort {
	public static void insertSort(int[] array){
		int temp;
		int index;
		for (int i = 1; i < array.length; i++) {
			index = i;
			for (int j=i-1; j>=0; j--){
				if(array[index]<array[j]){
					temp = array[j];
					array[j] = array[index];
					array[index] = temp;
					index=j;
				}else{
					break;
				}
			}
			//System.out.println(Arrays.toString(array));
		}
	}
	
	public static void bubbleSort(int[] array){
		int temp;
		int index;
		for(int i=array.length-1;i>0;i--){
			index = i;
			for(int j=i-1;j>=0;j--){
				if(array[index]<array[j]){
					temp = array[j];
					array[j] = array[index];
					array[index] = temp;
					index=j;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[5];
		Random ran = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = ran.nextInt(array.length+1);
		}
		System.out.println(Arrays.toString(array));
		insertSort(array);
		//bubbleSort(array);
		System.out.println(Arrays.toString(array));
	
	}
}
