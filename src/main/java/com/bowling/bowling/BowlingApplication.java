package com.bowling.bowling;

import com.bowling.bowling.interfaces.Round;
import com.bowling.bowling.util.Rounds;
import com.bowling.bowling.util.ScoreCalculation;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;

@SpringBootApplication
public class BowlingApplication {

	public static void main(String[] args) {
		LinkedList<Round> rounds = new LinkedList<>();
		Rounds.addRounds(rounds);
		/*System.out.println("--------AGGIUNTA_INIZIO--------");
		Rounds.print(rounds);
		System.out.println("--------AGGIUNTA_FINE----------");*/
		ScoreCalculation.scoreCalculation(rounds);
		/*System.out.println("------CALCOLO_INIZIO------");
		Rounds.print(rounds);
		System.out.println("------CALCOLO_FINE--------");*/
		Rounds.printScore(rounds);
	}
}
