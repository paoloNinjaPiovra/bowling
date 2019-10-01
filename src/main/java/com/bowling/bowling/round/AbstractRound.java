package com.bowling.bowling.round;

import com.bowling.bowling.enums.RoundType;
import com.bowling.bowling.interfaces.Round;
import com.bowling.bowling.util.ScoreWrapper;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractRound implements Round {
    private int roundId;
    private List<Integer> shoots;
    private int score;
    private RoundType roundType;

    public AbstractRound(int roundId, RoundType roundType, int score, List<Integer> shoots) {
        this.roundId = roundId;
        this.shoots = shoots;
        this.score = score;
        this.roundType = roundType;
    }

    public int getRoundId() {
        return roundId;
    }

    @Override
    public ScoreWrapper printRoundScore() {
        return null;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Integer> getShoots() {
        return shoots;
    }

    public RoundType getRoundType() {
        return roundType;
    }

    @Override
    public List<Integer> shoots() {
        return shoots;
    }
}
