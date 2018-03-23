package de.svdragster.neural;

/**
 * Created by z003p2yd on 16.01.2018.
 */
public class Perceptron {

	float[] input;
	float[] weights;

	float learningRate = 0.01f;

	float bias = 0.1f;

	public Perceptron(float[] input, float[] weights) {
		this.input = input;
		this.weights = weights;
	}

	public float getResult() {
		float sum = bias;
		for (int i=0; i<input.length; i++) {
			sum += input[i] * weights[i];
		}
		return Math.signum(sum);
	}

	public void adjust(float delta) {
		for (int i=0; i<input.length; i++) {
			//System.out.println(" >>>>>> " + i + "\t\tweight " + weights[i] + " += " + (input[i] * delta * learningRate));
			weights[i] += input[i] * delta * learningRate;
		}
		bias += delta * learningRate;
	}


	public float[] getInput() {
		return input;
	}

	public void setInput(float[] input) {
		this.input = input;
	}

	public float[] getWeights() {
		return weights;
	}

	public void setWeights(float[] weights) {
		this.weights = weights;
	}
}
