package com.nsm.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	
	public static void sort(int[] array){
		int[] temp=new int[array.length];
		sort(0, array.length-1, array, temp);
	}
	public static void sort(int left,int right,int[] array,int []temp){
		if(left<right){
			int mid = (left+right)/2;
			sort(left, mid, array, temp);
			sort(mid+1, right, array, temp);
			merge(left, right, mid, array, temp);
		}
	}
	
	public static void merge(int left,int right,int mid,int[] array,int []temp){
		int i = left;
		int j = mid+1;
		int t = 0;
		while(i<=mid&&j<=right){
			if(array[i]<=array[j]){
				temp[t++]=array[i++];
			}else{
				temp[t++]=array[j++];
			}
		}
		while(i<=mid){
			temp[t++]=array[i++];
		}
		while(j<=right){
			temp[t++]=array[j++];
		}
		t=0;
		while(left<=right){
			array[left++]=temp[t++];
		}
	}
	
	public static void main(String[] args) {
		Random ran = new Random();
		int[] array = new int[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = ran.nextInt(6);
		}
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
