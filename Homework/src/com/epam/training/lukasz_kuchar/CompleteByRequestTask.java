package com.epam.training.lukasz_kuchar;

public class CompleteByRequestTask implements Task {
    boolean isCompleted;
    boolean isCompletedAndExecuted;

    @Override
    public void execute() {
        if(this.isCompleted){
            this.isCompletedAndExecuted = true;
        }
    }

    @Override
    public boolean isFinished() {
        if(this.isCompletedAndExecuted){
            return true;
        }
        else{
            return false;
        }
    }

    public void complete() {
        this.isCompleted = true;
    }
}

