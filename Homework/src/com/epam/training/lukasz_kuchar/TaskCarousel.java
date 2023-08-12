package com.epam.training.lukasz_kuchar;

public class TaskCarousel {
    int capacity;
    Task[] taskCarousel;
    int currentPosition;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.taskCarousel = new Task[capacity];
    }

    public boolean addTask(Task task) {
        if (task.isFinished() || isFull()) {
            return false;
        } else {
            int i = 0;
            while(this.taskCarousel[i] != null){
                i++;
            }
            this.taskCarousel[i] = task;
        } return true;
    }

    /*public boolean addTask(CompleteByRequestTask task) {
        if (task.isFinished() || isFull()) {
            return false;
        } else {
            for (int i = 0; i < this.taskCarousel.length - 1; i++) {
                if (this.taskCarousel[i] == null) {
                    this.taskCarousel[i] = task;
                    break;
                }
            }
        } return true;
    } */

    public boolean execute() {
        if(isEmpty()){
            return false;
        }
        else{
            while(taskCarousel[this.currentPosition] == null){
                this.currentPosition++;
                if(currentPosition > (taskCarousel.length -1)){
                    currentPosition = 0;
                }
            }
            taskCarousel[this.currentPosition].execute();
            if(taskCarousel[this.currentPosition].isFinished()){
                taskCarousel[this.currentPosition] = null;
            }
            currentPosition++;
            if(currentPosition > (this.taskCarousel.length -1)){
                currentPosition = 0;
            }
            return true;
        }
    }

    public boolean isFull() {
        boolean isFull = true;
        for (Task task : taskCarousel){
            if(task == null){
                isFull = false;
            }
        } return isFull;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for (Task task : taskCarousel){
            if(task != null){
                isEmpty = false;
            }
        } return isEmpty;
    }

    public static void main(String[] args) {
        TaskCarousel carousel = new TaskCarousel(3);

        CountDownTask task1 = new CountDownTask(2);
        CountDownTask task2 = new CountDownTask(2);
        CompleteByRequestTask task3 = new CompleteByRequestTask();

        System.out.println(carousel.addTask(task1)); //true
        System.out.println(carousel.addTask(task2)); //true
        System.out.println(carousel.addTask(task3)); //true

        System.out.println(carousel.isFull()); // true

        for(int i = 0; i < 100; i++){
            System.out.println(carousel.execute()); // true
        }

        System.out.println(task1.isFinished()); // true
        System.out.println(task2.isFinished()); // true
        System.out.println(task3.isFinished()); // false

        task3.complete();

        System.out.println(task3.isFinished()); // false
        System.out.println(carousel.execute()); // true
        System.out.println(task3.isFinished()); // true

        System.out.println(carousel.isEmpty()); // true





    }

}