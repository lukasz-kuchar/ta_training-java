package com.epam.training.lukasz_kuchar;

import java.util.stream.IntStream;

public class HalvingRun extends CarouselRun {

    int currentIndex = 0;
    int arr[] = HalvingCarousel.arr;


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


        arr[currentIndex]=arr[currentIndex]/2;
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


