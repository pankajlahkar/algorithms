package edu.learn.sort;

public class MergeSorter implements Sorter{
	@Override
	public int[] sort(int[] input) {
		mergeSort(input, 0, input.length - 1);
		return input;
	}
	/*
	 * start is inclusive
	 * end is incclusive
	 */
	private void mergeSort(int[]input, int start, int end){
		if(start < end) {
			final int mid = (start + end)/2;
			mergeSort(input, start, mid);
			mergeSort(input, mid+1, end);
			merge(input, start, mid, end);
		}
	}
	private void merge(int[]input, int start, int mid, int end){
		final int leftArraySize = mid - start + 1;
		final int[]leftArray = new int[leftArraySize];
		for(int leftPointer = start; leftPointer <= mid; leftPointer++) {
			leftArray[leftPointer - start] = input[leftPointer];
		}
		
		final int rightArraySize = end - mid;
		final int[]rightArray = new int[rightArraySize];
		for(int rightPointer = mid + 1; rightPointer <= end; rightPointer++) {
			rightArray[rightPointer - mid - 1] = input[rightPointer];
		}
		
		int leftPointer = 0;
		int rightPointer = 0;
		for(int mergePointer = start; mergePointer <= end;) {
			if(leftPointer >= leftArraySize) {
				input[mergePointer++] = rightArray[rightPointer++];
			}else if(rightPointer >= rightArraySize) {
				input[mergePointer++] = leftArray[leftPointer++];
			}else if(leftArray[leftPointer] <= rightArray[rightPointer]) {
				input[mergePointer++] = leftArray[leftPointer++]; 
			} else {
				input[mergePointer++] = rightArray[rightPointer++];
			}
		}
	}
}
