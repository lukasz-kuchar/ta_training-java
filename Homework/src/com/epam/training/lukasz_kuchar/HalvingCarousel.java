package com.epam.training.lukasz_kuchar;

import java.util.stream.IntStream;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {

        super(capacity);
    }
    @Override
    public CarouselRun run(){

        HalvingRun carouselRun = null;
        if (!isRunning) {
            carouselRun = new HalvingRun(); // IF NOT RUNNING -> CREATE NEW CAROUSEL RUN (HAS NO REFERENCE, IS NOT NULL)
            isRunning = true;
        }
        return (CarouselRun) carouselRun;
    }

    public static void main(String[] args) {
        DecrementingCarousel carousel = new HalvingCarousel(7);

        carousel.addElement(20);
        carousel.addElement(30);
        carousel.addElement(10);

        CarouselRun run = carousel.run();

        System.out.println(run.isFinished()); //false

        System.out.println(run.next()); //20
        System.out.println(run.next()); //30
        System.out.println(run.next()); //10

        System.out.println(run.next()); //10
        System.out.println(run.next()); //15
        System.out.println(run.next()); //5

        System.out.println(run.next()); //5
        System.out.println(run.next()); //7
        System.out.println(run.next()); //2

        System.out.println(run.next()); //2
        System.out.println(run.next()); //3
        System.out.println(run.next()); //1

        System.out.println(run.next()); //1
        System.out.println(run.next()); //1

        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }

}

