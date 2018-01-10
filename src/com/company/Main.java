package com.company;


import java.util.Random;

public class Main {


    private static double[] sinapsWeightOne = new double[30000];
    private static double[] sinapsWeightTwo = new double[300];
    //GRADIENTS
    private static double[] GRADweightOne = new double[30000];
    private static double[] GRADweightTwo = new double[300];
    //DELTAS SINAPS
    private static double[] deltasSinapsOne = new double[30000];
    private static double[] deltasSinapsTwo = new double[300];


    private static double[] inputDataHiddenNeyrons = new double[300];
    private static double[] outputDataHiddenNeyrons = new double[300];
    private static double[] deltasHiddensNeyrons = new double[300];

    static Random random = new Random();
    private static double inputDataOutputNeyron;
    private static double outputDataOutputNeyron;
    private static double deltaOutputNeyron;


    private static int[][] inputNeurons = new int[2][1];


    //MOMENT AND SPEED LEARNING CONST
    private final static double moment = 0.3;
    private final static double epsilon = 0.7;
    private static double learnEquals;


    public static void main(String[] args) {

        for (int i = 0; i < sinapsWeightOne.length; i++)
            sinapsWeightOne[i] = Math.random();

        for (int q = 0; q < 1000; q++) {

            inputNeurons[0][0] = random.nextInt(1000000);
            inputNeurons[1][0] = random.nextInt(1000000);
            learnEquals = inputNeurons[0][0] + inputNeurons[1][0];

            for (int i = 0; i < inputDataHiddenNeyrons.length; i++)
                inputDataHiddenNeyrons[i] = mutpleSum(i + 1);

            for (int i = 0; i < outputDataHiddenNeyrons.length; i++)
                outputDataHiddenNeyrons[i] = functionSygmoid(inputDataHiddenNeyrons[i]);

            inputDataOutputNeyron = mutpleSum();
            outputDataOutputNeyron = functionSygmoid(inputDataOutputNeyron);

            deltaOutputNeyron = deltaOutputNeyron(outputDataOutputNeyron, learnEquals);

            for (int i = 0; i < deltasHiddensNeyrons.length; i++)
                deltasHiddensNeyrons[i] = deltasHiddensNeyrons(sinapsWeightTwo[i], deltaOutputNeyron, outputDataHiddenNeyrons[i]);

            for (int i = 0; i < GRADweightTwo.length; i++)
                GRADweightTwo[i] = gradientSinaps(deltaOutputNeyron, outputDataHiddenNeyrons[i]);

            //при циклах выходмт за пределы массива deltasHiddensNeyrons, ииза этого программа вылетает
            for (int i = 0; i < GRADweightOne.length; i++)
                GRADweightOne[i] = gradientSinaps(deltasHiddensNeyrons[i], i);

            for (int i = 0; i < deltasSinapsTwo.length; i++)
                deltasSinapsTwo[i] = deltasSinaps(moment, epsilon, deltasSinapsTwo[i], GRADweightTwo[i]);

            for (int i = 0; i < deltasSinapsOne.length; i++)
                deltasSinapsOne[i] = deltasSinaps(moment, epsilon, deltasSinapsOne[i], GRADweightTwo[i]);

            for (int i = 0; i < sinapsWeightTwo.length; i++)
                sinapsWeightTwo[i] = summDeltaWSimpleW(sinapsWeightTwo[i], deltasSinapsTwo[i]);

            for (int i = 0; i < sinapsWeightOne.length; i++)
                sinapsWeightOne[i] = summDeltaWSimpleW(sinapsWeightOne[i], deltasSinapsOne[i]);
        }

        System.out.println(inputNeurons[0][0]);
        System.out.println(inputNeurons[1][0]);
        System.out.println(outputDataOutputNeyron);

    }


    private static double functionSygmoid(double inputNeyronData) {
        return 1 / (1 + Math.exp(-inputNeyronData));
    }

    private static double mutpleSum(int pos) {
        double sm = 0;
        for (int i = 0; i < inputNeurons.length; i++) {
            for (int q = 0; q < inputNeurons[i].length; q++) {
                for (int w = (pos * 100) - 100; w < pos * 100; w++) {
                    sm = sm + (inputNeurons[i][q] * sinapsWeightOne[w]);
                }
            }
        }

        return sm;
    }

    private static double mutpleSum() {
        double sm = 0;
        for (int i = 0; i < outputDataHiddenNeyrons.length; i++) {
            sm = sm + (sinapsWeightTwo[i] * outputDataHiddenNeyrons[i]);
        }
        return sm;
    }


    private static double deltasHiddensNeyrons(double sinapsWeight, double deltaOutputNeyron, double outputDataHiddenNeyrons) {
        return (sinapsWeight * deltaOutputNeyron) * ((1 - outputDataHiddenNeyrons) * outputDataHiddenNeyrons);
    }


    private static double deltaOutputNeyron(double outputDataOutputNeyron, double learnEquals) {
        return (learnEquals - outputDataOutputNeyron) * ((1 - outputDataOutputNeyron) * outputDataOutputNeyron);
    }


    private static double gradientSinaps(double deltaNeyron, double outputNeyron) {
        return deltaNeyron * outputNeyron;
    }

    private static double deltasSinaps(double moment, double epsilon, double deltaSinaps, double GRADweight) {
        return (epsilon * GRADweight) + (moment * deltaSinaps);
    }

    private static double summDeltaWSimpleW(double sinapsWeght, double deltaSinapsWeght) {
        return sinapsWeght + deltaSinapsWeght;
    }


}
