package com.company;


import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Random;

public class Main {


    static double[] sinapsWeightOne = new double[30000];
    static double[] sinapsWeightTwo = new double[300];
    //GRADIENTS
    static double[] GRADweightOne = new double[30000];
    static double[] GRADweightTwo = new double[300];
    //DELTAS SINAPS
    static double[] deltasSinaps = {30000};



    static double[] inputDataHiddenNeyrons = new double[300];
    static double[] outputDataHiddenNeyrons = new double[300];
    static double[] deltasHiddensNeyrons = new double[300];


    static double inputDataOutputNeyron;
    static double outputDataOutputNeyron;
    static double deltaOutputNeyron;


    static int[][] inputNeurons = new int[2][1];


    //MOMENT AND SPEED LEARNING CONST
    final static double moment = 0.3;
    final static double epsilon = 0.7;
    final static double learnEquals = 0;




    public static void main(String[] args) {

        for (int i = 0; i<sinapsWeightOne.length; i++)
            sinapsWeightOne[i] = Math.random();

        for (int i = 0; i < inputDataHiddenNeyrons.length; i++)
            inputDataHiddenNeyrons[i] = mutpleSum(i+1);

        for (int i = 0; i<outputDataHiddenNeyrons.length; i++)
            outputDataHiddenNeyrons[i] = functionSygmoid(inputDataHiddenNeyrons[i]);

        inputDataOutputNeyron = mutpleSum();
        outputDataOutputNeyron = functionSygmoid(inputDataOutputNeyron);

        deltaOutputNeyron = deltaOutputNeyron(outputDataOutputNeyron, learnEquals);

        for (int i =0; i<deltasHiddensNeyrons.length;i++)
            deltasHiddensNeyrons[i] = deltasHiddensNeyrons(sinapsWeightTwo[i], deltaOutputNeyron, outputDataHiddenNeyrons[i]);

        for (int i = 0; i<GRADweightTwo.length; i++)
            GRADweightTwo[i] = gradientSinaps(deltaOutputNeyron, outputDataHiddenNeyrons[i]);

        for (int i = 0; i<GRADweightOne.length; i++)
            GRADweightOne[i] = gradientSinaps(deltasHiddensNeyrons[i], i);





    }






    private static double functionSygmoid(double inputNeyronData) {
        return 1 / (1 + Math.exp(-inputNeyronData));
    }

    private static double mutpleSum(int pos) {
        double sm = 0;
        for (int i = 0;i<inputNeurons.length;i++)
        {
            for (int q = 0; q<inputNeurons[i].length; q++)
            {
                for (int w = (pos*100)-100; w<pos*100; w++)
                {
                    sm = sm+(inputNeurons[i][q]*sinapsWeightOne[w]);
                }
            }
        }

        return sm;
    }

    private static double mutpleSum()
    {
        double sm = 0;
        for (int i = 0; i<outputDataHiddenNeyrons.length;i++)
        {
            sm = sm + (sinapsWeightTwo[i]*outputDataHiddenNeyrons[i]);
        }
        return sm;
    }


    private static double deltasHiddensNeyrons(double sinapsWeight, double deltaOutputNeyron, double outputDataHiddenNeyrons)
    {
        return (sinapsWeight*deltaOutputNeyron) * ((1-outputDataHiddenNeyrons)*outputDataHiddenNeyrons);
    }


    private static double deltaOutputNeyron(double outputDataOutputNeyron, double learnEquals) {
        return (learnEquals - outputDataOutputNeyron) * ((1 - outputDataOutputNeyron) * outputDataOutputNeyron);
    }




    /*private static double deltasHiddensNeyrons(double outputDataHiddenNeyron, double deltaOutputNeyron, int i) {
        return (sinapsWeight[i] * deltaOutputNeyron) * ((1 - outputDataHiddenNeyron) * outputDataHiddenNeyron);
    }*/

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
