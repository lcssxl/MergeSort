package com.open.free;

/**
 * Created by lcssxl on 2/24/2018.
 */
public class MergeSort {
    private int wayNum;
    private int[] array;
    private int[] tempMergArr;

    public void sort(int wayNum, int inputArr[]) {
        this.wayNum = wayNum;
        this.array = inputArr;
        this.tempMergArr = new int[inputArr.length];
        doMergeSort(0, inputArr.length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int step = (higherIndex - lowerIndex) / wayNum;
            // Below step sorts the left first side of the array
            doMergeSort(lowerIndex, lowerIndex+step);
            // Below step sorts the middle sides of the array
            for(int i=2; i<wayNum; i++){
                doMergeSort(lowerIndex+(i-1)*step+1, lowerIndex+i*step);
            }
            // Below step sorts the right last side of the array
            doMergeSort(lowerIndex+(wayNum-1)*step+1, higherIndex);

            // Now merge all sides
            mergeAllParts(lowerIndex, step, higherIndex);
            Utils.print(array);
        }
    }

    private void mergeAllParts(int lowerIndex, int step, int higherIndex) {
        for(int i=1; i<wayNum-1; i++){
            mergeBothParts(lowerIndex, lowerIndex+i*step, lowerIndex+(i+1)*step);
        }
        mergeBothParts(lowerIndex, lowerIndex+(wayNum-1)*step, higherIndex);
    }

    private void mergeBothParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
