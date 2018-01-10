package com.company;



public class Utill
{
    static int[] sinapsWeight = {};

    Utill(int[] sinapsWeight)
    {
        this.sinapsWeight = sinapsWeight;
    }

    private static double functionSygmoid(double inputNeyronData) {
        return 1 / (1 + Math.exp(-inputNeyronData));
        //return Math.tanh(inputNeyronData);
        //return inputNeyronData;
    }

    private static double mutpleSum(int i, int g, int f, double inputDataOne, double inputDataTwo, double inputDataTree) {
        return (inputDataOne * sinapsWeight[i]) + (inputDataTwo * sinapsWeight[g]) + (inputDataTree * sinapsWeight[f]);
    }

    private static double mutpleSum(int i, int g, double inputDataOne, double inputDataTwo) {
        return (inputDataOne * sinapsWeight[i]) + (inputDataTwo * sinapsWeight[g]);
    }

    private static double deltaOutputNeyron(double outputDataOutputNeyron, int learnEquals) {
        return (learnEquals - outputDataOutputNeyron) * ((1 - outputDataOutputNeyron) * outputDataOutputNeyron);
    }

    private static double deltasHiddensNeyrons(double outputDataHiddenNeyron, double deltaOutputNeyron, int i) {
        return (sinapsWeight[i] * deltaOutputNeyron) * ((1 - outputDataHiddenNeyron) * outputDataHiddenNeyron);
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
