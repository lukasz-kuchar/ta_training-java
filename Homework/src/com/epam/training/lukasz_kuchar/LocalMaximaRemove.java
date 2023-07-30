package com.epam.training.lukasz_kuchar;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
       /*
        int []array = new int[1000];
        Arrays.fill(array, 15);
        array[0] = -20;
        array[999] = 25;
        array[168] = 18;
        array[421] = 0;*/
        int[] array = new int[]{-20, 15, 15, 15, 18, 15, 15, 0, 15, 15, 15, 25};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){

        int[] temp = Arrays.copyOf(array, array.length); //copy of given array
        int numberOfZeros = 0; //counter of zeros, to further make an output array with proper length

        for(int i = 0; i < array.length; i++){ //for loop to go through given array and check for local maximum
            if (i == 0){ //if for first array element due to out of index problems
                if(array[i] > array[i+1]){
                    temp[i] = 9999999; //replacing local maximum of temp array with zeros
                    numberOfZeros++;
                }
            } else if (i == (array.length)-1) { // if for last array element due to out of index problems
                if(array[i] > array[i-1]){
                    temp[i] = 9999999;
                    numberOfZeros++;
                }
            }
            else{
                if((array[i] > array[i-1]) && (array[i] > array[i+1])){
                    temp[i] = 9999999;
                    numberOfZeros++;
                }
            }
        }
        int [] output = new int[array.length-numberOfZeros]; // proper output array declaration
        for(int i = 0, k = 0; i < temp.length; i++){ //iterate through temp and if not 0 (local maximum) then fill output with value
            if(temp[i] != 9999999){
                output[k] = temp [i];
                k++; //k is only increasing if putting value
            }
        }
        return output;
    }
}
