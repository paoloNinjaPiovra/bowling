package com.bowling.bowling.util;

import com.bowling.bowling.enums.RoundType;
import com.bowling.bowling.interfaces.Round;
import com.bowling.bowling.round.Basic;
import com.bowling.bowling.round.Bonus;
import com.bowling.bowling.round.Spare;
import com.bowling.bowling.round.Strike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Rounds {

    public static void printScore(LinkedList<Round> rounds) {
        ScoreWrapper scoreWrapper;
        int totalScore = 0;
        int rolls = 0;
        int frames = 0;
        for (Round roundItem : rounds) {
            scoreWrapper = roundItem.printRoundScore();
            scoreWrapper.getPoint();
            totalScore += scoreWrapper.getScore();
            rolls += scoreWrapper.getRolls();
            if (!RoundType.BONUS.equals(scoreWrapper.getRoundType()))
                frames++;
            System.out.print(" " + scoreWrapper.getPoint());
        }
        System.out.println(" (" + frames + " frames, " + rolls + " rolls) Total score:" + totalScore);
    }

    public static void addRounds(LinkedList<Round> rounds) {
        for (int i = 0; i < 10; i++) {
            rounds.add(createRound(i));
        }
        if (rounds.get(rounds.getLast().getRoundId() - 1).getRoundType().equals(RoundType.STRIKE)) {
            rounds.add(createRoundBonus(10, Shoot.shoot(0, 10)));
        }
        if (rounds.getLast().getRoundType().equals(RoundType.STRIKE)) {
            if (rounds.size() == 10)
                rounds.add(createRoundBonus(10, Shoot.shootBonus()));
            rounds.add(createRoundBonus(11, Shoot.shootBonus()));
        }

        if (rounds.getLast().getRoundType().equals(RoundType.SPARE)) {
            rounds.add(createRoundBonus(10, Shoot.shootBonus()));
        }
    }

    public static void print(LinkedList<Round> rounds) {
        for(Round roundItem : rounds) {
            if (roundItem instanceof Strike) {
                Strike strike = (Strike) roundItem;
                System.out.println("ID: " + strike.getRoundId() + " Strike - score: " + strike.getScore());
            }
            if (roundItem instanceof Spare) {
                Spare spare = (Spare) roundItem;
                System.out.println("ID: " + spare.getRoundId() + " Spare - score: " + spare.getScore()/* + " s1: " + spare.getShoots().get(0) + " s2: " + spare.getShoots().get(1)*/);
            }
            if (roundItem instanceof Basic) {
                Basic basic = (Basic) roundItem;
                System.out.println("ID: " + basic.getRoundId() + " Basic - score: " + basic.getScore() + " s1: " + basic.getShoots().get(0) + " s2: " + basic.getShoots().get(1));
            }
            if (roundItem instanceof Bonus) {
                Bonus bonus = (Bonus) roundItem;
                System.out.println("ID: " + bonus.getRoundId() + " Bonus - score: " + bonus.getScore() + " s1: " + bonus.getShoots().get(0));
            }
        }
    }

    public static Round createRoundBonus(int roundId, int score) {
        return new Bonus(roundId, RoundType.BONUS, score, Arrays.asList(score));
    }

    public static Round createRound(int roundId) {
        Round round = null;
        List<Integer> shoots = new ArrayList<>();
        int shoot1 = Shoot.shoot(0, 10);
        shoots.add(shoot1);
        if (shoot1 == 10) {
            round = new Strike(roundId, RoundType.STRIKE, shoot1, shoots);
        }
        if (shoot1 < 10) {
            int shoot2 = Shoot.shoot(0, 10 - shoot1);
            shoots.add(shoot2);
            int score = shoot1 + shoot2;
            if (score == 10) {
                round = new Spare(roundId, RoundType.SPARE,  score, shoots);
            } else {
                round = new Basic(roundId, RoundType.BASIC,  score, shoots);
            }
        }
        return round;
    }
}
