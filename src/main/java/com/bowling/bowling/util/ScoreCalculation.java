package com.bowling.bowling.util;

import com.bowling.bowling.interfaces.Round;

import java.util.LinkedList;

public class ScoreCalculation {

    public static void scoreCalculation(LinkedList<Round> rounds ) {
        for (int i = 0; i < rounds.size(); i++) {
            rounds.get(i).calculateRoundScore(rounds);
        }
    }
}
