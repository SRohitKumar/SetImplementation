package com.packagemain;

import java.util.stream.IntStream;

public class Set {

	int[] inputData;
	int[] finalCopy;
	int[] nullCopy;
	int index;

	public Set() {
		index = 0;
		nullCopy = new int[0];
		if (finalCopy == null) {
			finalCopy = new int[index];
		}
	}

	public Set(int[] inputElement) {
		if (inputElement == null) {
			nullCopy = null;
		} else {
			nullCopy = new int[0];
			index = 0;
			inputData = new int[inputElement.length];
			
			for (int i = 0; i < inputElement.length; i++) {
				int element = inputElement[i];
				boolean checkExistence = IntStream.of(inputData).anyMatch(x -> x == element);
				if (!checkExistence) {
					inputData[index] = inputElement[i];
					index++;
				}
			}
			removeZero(IntStream.of(inputElement).anyMatch(x -> x == 0));
		}

	}

	public boolean isExists(int item) {
		if (finalCopy == null) {
			return false;
		}
		for (int i = 0; i < finalCopy.length; i++) {
			if (finalCopy[i] == item) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return finalCopy.length;
	}

	public boolean add(int item) {
		boolean emptyConstructorCheck = false;
		if (nullCopy == null) {
			finalCopy = nullCopy.clone();
		}
		if (finalCopy == null || finalCopy.length == 0) {
			index = 0;
			finalCopy = new int[index + 1];
			finalCopy[index] = item;
			index++;
			emptyConstructorCheck = true;
		}
		int temCopy[];
		int tempCounter = 0;
		if (IntStream.of(finalCopy).anyMatch(x -> x == item)) {
			if (emptyConstructorCheck) {
				return true;
			}
			return false;
		} else {
			tempCounter = finalCopy.length + 1;
			temCopy = new int[tempCounter];
			for (int i = 0; i < finalCopy.length; i++) {
				temCopy[i] = finalCopy[i];
				if (i == finalCopy.length - 1) {
					temCopy[i + 1] = item;
				}
			}
			finalCopy = temCopy.clone();
			return true;
		}
	}

	public boolean delete(int item) {
		int tempCopy[];
		int tempCounter = 0;
		boolean deleteFlag = false;
		for (int i = 0; i < finalCopy.length; i++) {
			if (finalCopy[i] != item)
				tempCounter++;
			else
				deleteFlag = true;
		}
		tempCopy = new int[tempCounter];

		for (int i = 0, j = 0; i < finalCopy.length; i++) {
			if (finalCopy[i] != item) {
				tempCopy[j] = finalCopy[i];
				j++;
			}
		}
		finalCopy = tempCopy.clone();
		return deleteFlag;
	}

	public String toString() {

		if (index == 0) {
			return "";
		} else {
			String toStr = "[";
			for (int i = 0; i < finalCopy.length; i++) {
				toStr += finalCopy[i] + ",";
			}
			toStr += "]";
			return toStr;
		}

	}

	private void removeZero(boolean containsZero) {
		int allowOneZeroCount = 0;
		int len = 0;
		for (int i = 0; i < inputData.length; i++) {
			if (inputData[i] != 0) {
				len++;
			} else if (allowOneZeroCount == 0 && inputData[i] == 0) {
				len++;
				allowOneZeroCount++;
			}

		}
		finalCopy = new int[len];
		for (int i = 0, index = 0; i < inputData.length; i++) {
			if (inputData[i] != 0) {
				finalCopy[index] = inputData[i];
				index++;
			}
		}
	}

	

}
