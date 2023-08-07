package com.epam.training.lukasz_kuchar;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    public static int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {

        super(capacity);
        this.actionLimit = actionLimit;
    }

    @Override
    public CarouselRun run(){

        LimitedRun carouselRun = null;
        if (!isRunning) {
            carouselRun = new LimitedRun(); // IF NOT RUNNING -> CREATE NEW CAROUSEL RUN (HAS NO REFERENCE, IS NOT NULL)
            isRunning = true;
        }
        return (CarouselRun) carouselRun;
    }

    public static void main(String[] args) {

        DecrementingCarousel carousel = new DecrementingCarouselWithLimitedRun(7, 10);

        carousel.addElement(20);
        carousel.addElement(30);
        carousel.addElement(10);

        CarouselRun run = carousel.run();

        System.out.println(run.isFinished()); //false

        System.out.println(run.next()); //20
        System.out.println(run.next()); //30
        System.out.println(run.next()); //10

        System.out.println(run.next()); //19
        System.out.println(run.next()); //29
        System.out.println(run.next()); //9

        System.out.println(run.next()); //18
        System.out.println(run.next()); //28
        System.out.println(run.next()); //8

        System.out.println(run.next()); //17

        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }

}
