package com.liang.myapplication;

import org.junit.Test;

public class TestJava {
    @Test
    public void testBubbleSore(){
        int[] arr = new int[]{20,10,8,30,2,9,3,13,42,4,13};
        int[] newArr = bubbleSore(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }

    @Test
    public void testQuicklySore(){
        int[] arr = new int[]{20,10,8,30,2,9,3,13,42,4,13};
        quicklySore(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] bubbleSore(int[] arr){
        //一共进行多少趟排序
        for (int i=0;i<arr.length;i++){
            //第i趟排序 arr.length-i不参与排序，因为已经排好了
            for (int j = 0; j < arr.length-i-1; j++) {
                //如果前一个数大于后一个数，则前一个大的数跟后面小的数调换位置
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public void quicklySore(int arr[],int low ,int height){
        //第一个元素设为标准值，用一个temp变量装起来，从高位跟低位2边开始遍历数组，先从高位开始找一个小于标准值的数，如果不满足则高位--，如果满足并高位大于低位
        //则把高位的值赋值给低位，在从低位开始找一个大于标准值的数，若不满足则低位++，若满足则把低位的值赋值给高位，再重复高位和低位的动作，若低位大于等于高位则
        //把标准值放再这个i=j的位置，此时分成了2个数组，每个数组重复这个动作
        if (low<height) {
            int index = getIndex(arr, low, height);
            quicklySore(arr, low, index - 1);
            quicklySore(arr, index + 1, height);
        }
    }

    public int getIndex(int arr[],int low,int height){
        int temp = arr[low];
        while (low<height) {
            while (low < height && arr[height] >= temp) {
                height--;
            }
            arr[low] = arr[height];
            while (low < height && arr[low] <= temp) {
                low++;
            }
            arr[height] = arr[low];
        }
        arr[low]= temp;
        return low;
    }

}
