package de.svdragster.neural;

import java.util.Scanner;

/**
 * Created by z003p2yd on 16.01.2018.
 */
public class Main {

	private Perceptron perceptron;

	private int guesses = 0;

	private float[][] correctValues;

	public int mapToBit(float f) {
		return f == 1 ? 1 : 0;
	}

	public Main() {
		simple();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press any key to start");
		scanner.nextLine();
		new Main();
	}

	public void simple() {
		// AND
		/*correctValues = new float[][]{
				{-1, -1, -1},
				{-1, 1, -1},
				{1, -1, -1},
				{1, 1, 1},
		};*/

		// OR
		correctValues = new float[][]{
				{-1, -1, 	-1},
				{-1, 1, 	1},
				{1, -1, 	1},
				{1, 1,		1},
		};

		perceptron = new Perceptron(new float[]{1, 1}, new float[]{(float) (Math.random()*2-1), (float) (Math.random()*2-1)});

		Scanner scanner = new Scanner(System.in);

		int count = 0;
		while (true) {
			boolean done = true;
			System.out.println(" ");
			System.out.println(count + " ==============");
			for (int i=0; i<4; i++) {
				perceptron.setInput(new float[]{correctValues[i][0], correctValues[i][1]});

				float result = perceptron.getResult();
				float expected = correctValues[i][2];
				float delta = expected - result;
				if (delta != 0) {
					done = false;
				}

				System.out.println(mapToBit(perceptron.getInput()[0]) + "  " + mapToBit(perceptron.getInput()[1]) + " \t-> " + mapToBit(result) + " \t\tEXPECTED: " + mapToBit(expected) + ", \tdelta: " + delta + ", \t" + perceptron.getWeights()[0] + ", " + perceptron.getWeights()[1]);

				perceptron.adjust(delta);
			}
			count++;
			if (done) {
				System.out.println("    ");
				System.out.println("Done!");
				return;
			}
			//float expected = correct(perceptron.getInput(), result) ? 1 : -1;
		}
	}

}
