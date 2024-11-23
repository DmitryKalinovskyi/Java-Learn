package com.education.ztu.comparators;

import com.education.ztu.game.Participant;

import java.util.Comparator;

public class ParticipantAgeComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant o1, Participant o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
