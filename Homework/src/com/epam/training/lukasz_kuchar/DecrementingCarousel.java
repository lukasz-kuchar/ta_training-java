package com.epam.training.lukasz_kuchar;

public class DecrementingCarousel {

    static int [] arr;
    int addingPosition = 0;
    int capacity;
    private boolean isRunning;
    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];

    }

    public boolean addElement(int element){
        if (element <= 0 || addingPosition >= capacity || isRunning){
            return false;
        } else {
            arr[addingPosition] = element;
            addingPosition++;
            return true;
        }

        //throw new UnsupportedOperationException();
    }

    public CarouselRun run() {
        /*if(!isRunning){
        isRunning = true;
            CarouselRun CarouselRun = null;
        }
        return CarouselRun;}*/

        // throw new UnsupportedOperationException();
        // return new CarouselRun();

        CarouselRun carouselRun = null;
        if (!isRunning) {
            carouselRun = new CarouselRun(); // IF NOT RUNNING -> CREATE NEW CAROUSEL RUN (HAS NO REFERENCE, IS NOT NULL)
            isRunning = true;
        }
        return carouselRun;
    }


    public static void main(String[] args) {
        CarouselRun run = new DecrementingCarousel(7).run();
        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }
}