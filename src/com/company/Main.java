package com.company;


import java.util.Random;

public class Main {

    private static double[][] inputNeurons = new double[2][1];

    private static double[] inputDataHiddenNeyrons = new double[300];
    private static double[] outputDataHiddenNeyrons = new double[300];
    private static double[] deltasHiddensNeyrons = new double[300];

    private static double inputDataOutputNeyron;
    private static double outputDataOutputNeyron;
    private static double deltaOutputNeyron;

    private static double[] sinapsWeightOne = new double[ inputNeurons.length * inputDataHiddenNeyrons.length ];
    private static double[] sinapsWeightTwo = new double[ 1 * outputDataHiddenNeyrons.length ];
    //GRADIENTS
    private static double[] GRADweightOne = new double[ inputNeurons.length * inputDataHiddenNeyrons.length ];
    private static double[] GRADweightTwo = new double[ 1 * outputDataHiddenNeyrons.length ];
    //DELTAS SINAPS
    private static double[] deltasSinapsOne = new double[ inputNeurons.length * inputDataHiddenNeyrons.length ];
    private static double[] deltasSinapsTwo = new double[ 1 * outputDataHiddenNeyrons.length ];


    static Random random = new Random();


    //MOMENT AND SPEED LEARNING CONST
    private final static double moment = 0.3;
    private final static double epsilon = 0.7;

    //правильный ответ
    private static double learnEquals;


    public static void main(String[] args) {

        for (int i = 0; i < sinapsWeightOne.length; i++) {
            sinapsWeightOne[i] = Math.random();
            if (random.nextInt(10)%5 == 0)
                sinapsWeightOne[i] = Math.random()-1;
        }
        for (int i = 0; i < sinapsWeightTwo.length; i++) {
            sinapsWeightTwo[i] = Math.random();
            if (random.nextInt(10) % 5 == 0)
                sinapsWeightTwo[i] = Math.random() - 1;
        }

        for (int q = 0; q < 1000; q++) {
            inputDataOutputNeyron = 0;
            outputDataOutputNeyron = 0;
            deltaOutputNeyron = 0;

            double rand1 = random.nextInt(1000);
            double rand2 = random.nextInt(1000);
            inputNeurons[0][0] = (rand1)/10000;
            inputNeurons[1][0] = (rand2)/10000;
            learnEquals = (rand1 + rand2)/10000;

            for (int i = 0; i < inputDataHiddenNeyrons.length; i++)
                inputDataHiddenNeyrons[i] = mutpleSum(i);

            for (int i = 0; i < outputDataHiddenNeyrons.length; i++)
                outputDataHiddenNeyrons[i] = functionSygmoid(inputDataHiddenNeyrons[i]);

            inputDataOutputNeyron = mutpleSum();
            outputDataOutputNeyron = functionSygmoid(inputDataOutputNeyron);


            deltaOutputNeyron = deltaOutputNeyron(outputDataOutputNeyron, learnEquals);

            for (int i = 0; i < deltasHiddensNeyrons.length; i++)
                deltasHiddensNeyrons[i] = deltasHiddensNeyrons(sinapsWeightTwo[i], deltaOutputNeyron, outputDataHiddenNeyrons[i]);

            for (int i = 0; i < outputDataHiddenNeyrons.length; i++)
                GRADweightTwo[i] = gradientSinaps(deltaOutputNeyron, outputDataHiddenNeyrons[i]);

            int num = 0;
            for (double deltasHiddensNeyron : deltasHiddensNeyrons) {
                GRADweightOne[num] = gradientSinaps(deltasHiddensNeyron, inputNeurons[0][0]);
                num++;
                GRADweightOne[num] = gradientSinaps(deltasHiddensNeyron, inputNeurons[1][0]);
                num++;
            }
            for (int i = 0; i < deltasSinapsTwo.length; i++)
                deltasSinapsTwo[i] = deltasSinaps(moment, epsilon, deltasSinapsTwo[i], GRADweightTwo[i]);

            for (int i = 0; i < deltasSinapsOne.length; i++)
                deltasSinapsOne[i] = deltasSinaps(moment, epsilon, deltasSinapsOne[i], GRADweightOne[i]);

            for (int i = 0; i < sinapsWeightTwo.length; i++)
                sinapsWeightTwo[i] = summDeltaWSimpleW(sinapsWeightTwo[i], deltasSinapsTwo[i]);

            for (int i = 0; i < sinapsWeightOne.length; i++)
                sinapsWeightOne[i] = summDeltaWSimpleW(sinapsWeightOne[i], deltasSinapsOne[i]);
        }

        System.out.println(inputNeurons[0][0]);
        System.out.println(inputNeurons[1][0]);
        System.out.println(outputDataOutputNeyron);
        System.out.println();

    }


    private static double functionSygmoid(double inputNeyronData) {
        return inputNeyronData;//1 / (1 + Math.exp(-inputNeyronData));
    }

    private static double mutpleSum(int pos) {
        return (inputNeurons[0][0]*sinapsWeightOne[pos])+(inputNeurons[1][0]*sinapsWeightOne[pos+1]);
    }

    private static double mutpleSum() {
        double sm = 0;
        for (int i = 0; i < outputDataHiddenNeyrons.length; i++) {
            sm = sm + (sinapsWeightTwo[i] * outputDataHiddenNeyrons[i]);
        }
        return sm;
    }


    private static double deltasHiddensNeyrons(double sinapsWeight, double deltaOutputNeyron, double outputDataHiddenNeyrons) {
        return (sinapsWeight * deltaOutputNeyron);// * ((1 - outputDataHiddenNeyrons) * outputDataHiddenNeyrons);
    }


    private static double deltaOutputNeyron(double outputDataOutputNeyron, double learnEquals) {
        return (learnEquals - outputDataOutputNeyron);// * ((1 - outputDataOutputNeyron) * outputDataOutputNeyron);
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
