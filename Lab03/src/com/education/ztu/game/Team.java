package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<TParticipant extends Participant>  {
    private String name;
    private List<TParticipant> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
    public void addNewParticipant(TParticipant participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + participant.getName());
    }

    public void playWith(Team<TParticipant> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if(i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("The team " + winnerName + " is winner!");
    }

    public String getName() {
        return name;
    }

    public List<TParticipant> getParticipants() {
        return participants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(List<TParticipant> participants) {
        this.participants = participants;
    }

    public Team<TParticipant> deepClone() {
        Team<TParticipant> clone = new Team<>(name);

        for(TParticipant participant : participants){
            clone.addNewParticipant((TParticipant) participant.clone());
        }
        return clone;
    }
}
