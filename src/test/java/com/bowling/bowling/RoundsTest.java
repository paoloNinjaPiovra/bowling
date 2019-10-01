package com.bowling.bowling;

import com.bowling.bowling.enums.RoundType;
import com.bowling.bowling.interfaces.Round;
import com.bowling.bowling.util.Rounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundsTest {

    @Test
    public void addRoundsTest() {
        LinkedList<Round> rounds = new LinkedList<>();
        Rounds.addRounds(rounds);

        assertTrue(rounds.size() == 10);
    }

    @Test
    public void createRoundBonusTest() {
        Round bonus = Rounds.createRoundBonus(0, 10);

        assertTrue(bonus != null);
        assertTrue(bonus.getRoundId() == 0);
        assertTrue(bonus.getRoundType().equals(RoundType.BONUS));
        assertTrue(bonus.getScore() == 10);
        assertTrue(bonus.shoots().size() == 1);
    }

    @Test
    public void createRoundTest() {
        Round roundToTest = Rounds.createRound(1);

        assertTrue(roundToTest != null);
        assertTrue(roundToTest.getRoundId() == 1);
        assertTrue(roundToTest.getRoundType().equals(RoundType.SPARE) ||
                roundToTest.getRoundType().equals(RoundType.STRIKE) ||
                roundToTest.getRoundType().equals(RoundType.BASIC));
        assertTrue(roundToTest.getScore() >= 0);
        assertTrue(roundToTest.shoots().size() > 1);
    }
}
