package minesweeper;

import java.io.IOException;
import java.util.Scanner;

import support.cse131.minesweeper.MineSweeperUtils;
import support.cse131.minesweeper.game.Model;
import support.cse131.minesweeper.game.viz.Controller;
import support.cse131.minesweeper.game.viz.StreamToBoardAdapter;

public class MineSweeperGame {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		System.out.println("How many columns?");
		int cols = in.nextInt();
		System.out.println("How many rows?");
		int rows = in.nextInt();
		System.out.println("What is the probability of a mine?");
		double probability = in.nextDouble();

		//
		// Run the student's game, capturing the output to create the game board
		//
		String output = MineSweeperUtils.runMain(cols, rows, probability);

		//
		// Here is what the student's code printed
		//
		System.out.println("Output from student's code:");
		System.out.println("---------------------------------------");
		System.out.println(output);
		System.out.println("---------------------------------------");

		StreamToBoardAdapter myStream = new StreamToBoardAdapter(new String(output), cols, rows);
		Model model = new Model(myStream.getBoard());
		System.out.println("\nGame will be played based on this board:");
		model.print(true);
		Controller game = new Controller(model);
		game.run();
	}

}
