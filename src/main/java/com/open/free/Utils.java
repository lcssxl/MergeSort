package com.open.free;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcssxl on 2/24/2018.
 */
public class Utils {
    public static void print(int array[]) {
        System.out.print("[ ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if(i < array.length-1){
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
    public static String toString(int array[]) {
        String resultStr = "[ ";
        for(int i=0; i<array.length; i++){
            resultStr += array[i];
            if(i < array.length-1){
                resultStr += ", ";
            }
        }
        resultStr += " ]";
        return resultStr;
    }



    public static int[] getFileArray(String filePath){
        List<Integer> list = new ArrayList<Integer>();
        BufferedReader bufReader = null;
        int[] array = null;
        try {
            String line = null;
            File file = new File(filePath);
            bufReader = new BufferedReader(new FileReader(file));
            while((line=bufReader.readLine()) != null){
                if(line!=null && !"".equals(line)){
                    line = line.replaceAll("\t", " ");
                    String[] tempArr = line.split(" ");
                    for(String temp:tempArr){
                        if(temp!=null && !"".equals(temp)){
                            list.add(Integer.valueOf(temp));
                        }
                    }
                }
            }
            bufReader.close();

            array = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                array[i] = list.get(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }


    public static void saveFile(String filePath, String content, boolean append){
        FileOutputStream fout = null;
        try{
            File file = new File(filePath);
            fout = new FileOutputStream(file, append);
            if ( !file.exists() ) {
                file.createNewFile();
            }
            fout.write(content.getBytes());
            fout.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeQuietly(fout);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null){
                closeable.close();
            }
        } catch (IOException localIOException) {
        }
    }
}
