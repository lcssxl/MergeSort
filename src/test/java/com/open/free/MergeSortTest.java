package com.open.free;

import org.junit.Test;

/**
 * Created by lcssxl on 2/24/2018.
 */
public class MergeSortTest {
    @Test
    public void main(){
        int wayNum = 15;
        String fileName = "numbers";
        String filePath = getClass().getResource("/").getPath();
        int[] inputArr = Utils.getFileArray(filePath+"/"+fileName);
        MergeSort mms = new MergeSort();
        mms.sort(wayNum, inputArr);
        Utils.saveFile(filePath+"/"+fileName+"_sorted", Utils.toString(inputArr), false);
    }

    @Test
    public void testMergeSort(){
        int wayNum = 15;
        int[] inputArr = {4, 2, 6, 1};
        MergeSort mms = new MergeSort();
        mms.sort(wayNum, inputArr);
    }


}
