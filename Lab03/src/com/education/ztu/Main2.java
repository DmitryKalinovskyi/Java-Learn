package com.education.ztu;

import com.education.ztu.comparators.ParticipantAgeComparator;
import com.education.ztu.comparators.ParticipantNameComparator;
import com.education.ztu.game.Schoolar;
import com.education.ztu.game.Team;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olga", 14);
        Schoolar schoolar5 = new Schoolar("Anton", 18);
        Schoolar schoolar6 = new Schoolar("Anton", 19);

        Team<Schoolar> schoolarTeam = new Team<>("DreamTeam");
        schoolarTeam.addNewParticipant(schoolar2);
        schoolarTeam.addNewParticipant(schoolar4);
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar3);
        schoolarTeam.addNewParticipant(schoolar6);
        schoolarTeam.addNewParticipant(schoolar5);

        System.out.println("Before sort: ");
        List<Schoolar> participants = schoolarTeam.getParticipants();
        for(Schoolar schoolar: participants){
            System.out.println(schoolar);
        }

        ParticipantNameComparator nameComparator = new ParticipantNameComparator();
        ParticipantAgeComparator ageComparator = new ParticipantAgeComparator();
        participants.sort(nameComparator.thenComparing(ageComparator));

        System.out.println("After sort: ");
        for(Schoolar schoolar: participants){
            System.out.println(schoolar);
        }
    }
}
