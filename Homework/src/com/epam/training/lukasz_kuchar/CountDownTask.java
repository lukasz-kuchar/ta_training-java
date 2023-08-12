package com.epam.training.lukasz_kuchar;

public class CountDownTask implements Task{
    int initCountdown;

    public CountDownTask(int value) {
        if(value < 0){
            this.initCountdown = 0;
        }
        else{
            this.initCountdown = value;
        }
    }

    public int getValue() {
        return this.initCountdown;
    }


    @Override
    public void execute() {
        if(initCountdown > 0){
            initCountdown--;
        }
    }

    @Override
    public boolean isFinished() {
        if(this.initCountdown == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
