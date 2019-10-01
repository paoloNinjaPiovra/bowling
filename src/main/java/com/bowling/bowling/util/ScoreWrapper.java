package com.bowling.bowling.util;

import com.bowling.bowling.enums.RoundType;

public class ScoreWrapper {
    private int score;
    private String point;
    private int rolls;
    private RoundType roundType;

    public ScoreWrapper(int score, String point, int rolls, RoundType roundType) {
        this.score = score;
        this.point = point;
        this.rolls = rolls;
        this.roundType = roundType;
    }

    public int getScore() {
        return score;
    }

    public String getPoint() {
        return point;
    }

    public int getRolls() {
        return rolls;
    }

    public RoundType getRoundType() {
        return roundType;
    }

}
