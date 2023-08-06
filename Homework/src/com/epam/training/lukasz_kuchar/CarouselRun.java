package com.epam.training.lukasz_kuchar;

import java.util.stream.IntStream;

public class CarouselRun {
    int currentIndex = 0;
    int arr[] = DecrementingCarousel.arr;

    /*public int next() {
        while(currentIndex < arr.length && IntStream.of(DecrementingCarousel.arr).sum() > 0){
            if(currentIndex == arr.length){
                currentIndex = 0;
            }

            while(arr[currentIndex] == 0){
                    currentIndex++;
                    if(currentIndex == arr.length){
                        currentIndex = 0;}
                }
                int value = arr[currentIndex];
                arr[currentIndex]--;
                currentIndex++;
                return value;
            }

       return -1;
    }*/

    public int next() {
        if(IntStream.of(arr).sum() == 0){
            currentIndex = 0;
        }
        while (arr[currentIndex] == 0 && currentIndex < arr.length && IntStream.of(arr).sum() > 0) {
            if (currentIndex == arr.length - 1) {
                currentIndex = 0;

            }
            else {
                currentIndex++;
            }
        }
        if (arr[currentIndex] == 0) {
            currentIndex++;
        }
        int element = arr[currentIndex];

        if (element == 0) {
            return -1;
        }


        arr[currentIndex]--;
        currentIndex++;

        if (currentIndex == arr.length) {
            currentIndex = 0;
        }


        return element;
    }

    public boolean isFinished() {
        while(IntStream.of(arr).sum() > 0 || IntStream.of(arr).sum() < 0){
            return false;
        }
        return true;
    }

}
