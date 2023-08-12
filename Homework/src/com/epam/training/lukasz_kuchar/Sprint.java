package com.epam.training.lukasz_kuchar;

public class Sprint {
    int capacity;
    int currentCapacity = 0;
    int numberOfTickets = 0;
    int ticketsLimit;
    Ticket[] tickets;
    int addingPosition = 0;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }


    public boolean addUserStory(UserStory userStory) { // uncompleted dependencies of userStory are already accepted to the sprint
        // loop over tickets array and loop over dependencies array at the same time to search for matches


        if(userStory == null){
            return false;
        }
        if(!(isSubset(tickets, userStory))){
            return false;
        }
        //boolean dependenciesAccepted = Arrays.asList(tickets).containsAll(Arrays.asList(userStory.getDependencies()));


        if(numberOfTickets + 1 > ticketsLimit){
            return false;
        }
        if(currentCapacity + userStory.estimate > capacity){
            return false;
        }

        if(userStory.isCompleted()){
            return false;

        } else {
            tickets[addingPosition] = userStory;
            addingPosition++;
            currentCapacity = currentCapacity + userStory.estimate;
            numberOfTickets++;
            return true;
        }
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null){
            return false;
        }
        if(numberOfTickets + 1 > ticketsLimit){
            return false;
        }
        if(currentCapacity + bugReport.estimate > capacity){
            return false;
        }
        if(bugReport.isCompleted()){
            return false;
        } else {
            tickets[addingPosition] = bugReport;
            addingPosition++;
            currentCapacity = currentCapacity + bugReport.estimate;
            numberOfTickets++;
            return true;
        }

    }

    public Ticket[] getTickets() {
        int actualTickets = 0;
        for(int i=0; i<tickets.length; i++){
            if(!(tickets[i] == null)){
                actualTickets++;
            }
        }
        Ticket [] defCopy = new Ticket [actualTickets];
        for(int i=0; i<defCopy.length; i++){
            defCopy[i]=tickets[i];
        }
        return defCopy;
    }

    public int getTotalEstimate() {
        return currentCapacity;
    }

    static boolean isSubset(Ticket[] tickets, UserStory userStory) {
        UserStory[] dependenciesArray = userStory.getDependencies();
        int i = 0;
        int j = 0;
        int n = dependenciesArray.length;
        int m = tickets.length;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++)
                if (dependenciesArray[i] == tickets[j])
                    break;

            /* If the above inner loop
            was not broken at all then
            arr2[i] is not present in
            arr1[] */
            if (j == m)
                return false;
        }

        /* If we reach here then all
        elements of arr2[] are present
        in arr1[] */
        return true;
    }
}
