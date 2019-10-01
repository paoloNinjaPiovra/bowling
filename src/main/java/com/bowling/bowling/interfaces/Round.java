package com.bowling.bowling.interfaces;

import com.bowling.bowling.enums.RoundType;
import com.bowling.bowling.util.ScoreWrapper;

import java.util.LinkedList;
import java.util.List;

public interface Round {
    Round calculateRoundScore(LinkedList<Round> rounds);
    RoundType getRoundType();
    int getScore();
    List<Integer> shoots();
    int getRoundId();
    ScoreWrapper printRoundScore();


}
