package com.epam.training.lukasz_kuchar;

public class Bug extends Ticket {

    UserStory relatedUserStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if(!userStory.isCompleted || userStory == null){
            return null;
        } else{
            return new Bug(id, name, estimate, userStory);
        }

    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.relatedUserStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug " + id + "] "
                + relatedUserStory.name
                + ": " + this.name;
    }
}

