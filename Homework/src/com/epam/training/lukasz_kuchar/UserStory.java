package com.epam.training.lukasz_kuchar;

import java.util.Arrays;

public class UserStory extends Ticket {
    UserStory [] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.isCompleted = false;
        this.dependencies = new UserStory[dependsOn.length];
        if(dependencies.length>0){
            for(int i=0; i<dependencies.length; i++){
                dependencies[i]=dependsOn[i];
            }
        }

    }

    @Override
    public void complete() {
        if(this.dependencies.length == 0){
            isCompleted = true;
        }else{
            isCompleted = true;
            for(int i=0; i<this.dependencies.length; i++){
                if(!this.dependencies[i].isCompleted){
                    isCompleted = false;
                }
            }
        }

    }

    public UserStory[] getDependencies() {
        UserStory [] defCopy = new UserStory [this.dependencies.length];
        for(int i=0; i<defCopy.length; i++){
            defCopy[i]=this.dependencies[i];
        }
        return defCopy;
    }

    @Override
    public String toString() {
        return "[US " + id + "] "
                + name;
    }


    public static void main(String[] args) {

    }
}

