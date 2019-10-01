package com.bowling.bowling.round;

import com.bowling.bowling.enums.RoundType;
import com.bowling.bowling.interfaces.Round;
import com.bowling.bowling.util.ScoreWrapper;

import java.util.LinkedList;
import java.util.List;

public class Basic extends AbstractRound {

    public Basic(int roundId, RoundType roundType, int score, List<Integer> shoots) {
        super(roundId, roundType, score, shoots);
    }

    @Override
    public Round calculateRoundScore(LinkedList<Round> rounds) {
        return this;
    }

    @Override
    public ScoreWrapper printRoundScore() {
        return new ScoreWrapper(this.getScore(), this.getScore() + "-", 2, this.getRoundType());
    }
}
