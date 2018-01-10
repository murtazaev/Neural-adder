package com.company;

public class Neyron {
//static double[] sinapsWeight = {0.6764399855903294, 0.461611507901923, 1.5322983284622838, 0.5826412070643445, 0.8523655464494229, 1.6553641843590576, 1.0422704569885655, 0.5372376025978274, 1.6393997475575648, 0.5866636768334645, 0.6867263754417885, 0.8581432634068344};//0.5,0.4,0.6,0.4,0.8,0.7,0.9,0.5,0.6,0.4,0.5,0.7


//static double inputDataOneHiddenNeyron;
    //static double outputDataOneHiddenNeyron;
//
    //static double inputDataTwoHiddenNeyron;
    //static double outputDataTwoHiddenNeyron;
//
    //static double inputDataTreeHiddenNeyron;
    //static double outputDataTreeHiddenNeyron;


    //static double inputDataOutputNeyron;
    //static double outputDataOutputNeyron;
//
    //static int inputNeyronOne = 1;
    //static int inputNeyronTwo = 0;
    //static int inputNeyronTree = 0;


    //DELTAS
    // static double deltaOneHiddenNeyron;
    // static double deltaTwoHiddenNeyron;
    // static double deltaTreeHiddenNeyron;
    // static double deltaOutputNeyron;


    //Random random = new Random();
    //int[][] array = {
    //        {1, 1, 1},
    //        {1, 0, 1},
    //        {1, 0, 1},
    //        {1, 0, 1},
    //        {1, 1, 1}}; //{условие, условие, нужный ответ}
    //for (int z = 0; z < 100; z++) {
            /*for (int f = 0; f < array.length; f++) {
                array[f][0] = random.nextInt(2);
                array[f][1] = random.nextInt(2);

                if (array[f][0] == 1 & array[f][1] == 1)
                    array[f][2] = 0;
                else if (array[f][0] == 0 & array[f][1] == 0)
                    array[f][2] = 0;
                else array[f][2] = 1;
            }*/


    ///for (int f = 0; f < array.length; f++) {
    //inputNeyronOne = array[f][0];//
    //inputNeyronTwo = array[f][1];//
    //inputNeyronTree = array[f][2];
    //inputDataOneHiddenNeyron = mutpleSum(0, 1, 9, (double) inputNeyronOne, (double) inputNeyronTwo, (double) inputNeyronTree);
    //outputDataOneHiddenNeyron = functionSygmoid(inputDataOneHiddenNeyron);
//
    //inputDataTwoHiddenNeyron = mutpleSum(3, 4, 10, (double) inputNeyronOne, (double) inputNeyronTwo, (double) inputNeyronTree);
    //outputDataTwoHiddenNeyron = functionSygmoid(inputDataTwoHiddenNeyron);
//
    //inputDataTreeHiddenNeyron = mutpleSum(6, 7,11, (double) inputNeyronOne, (double) inputNeyronTwo, (double) inputNeyronTree);
    //outputDataTreeHiddenNeyron = functionSygmoid(inputDataTreeHiddenNeyron);
//
    //inputDataOutputNeyron = mutpleSum(2, 5, 8, outputDataOneHiddenNeyron, outputDataTwoHiddenNeyron, outputDataTreeHiddenNeyron);
    //outputDataOutputNeyron = functionSygmoid(inputDataOutputNeyron);
//
//
    //deltaOutputNeyron = deltaOutputNeyron(outputDataOutputNeyron, 1);//array[f][2]);//
//
    //deltaOneHiddenNeyron = deltasHiddensNeyrons(outputDataOneHiddenNeyron, deltaOutputNeyron, 2);
//
    //deltaTwoHiddenNeyron = deltasHiddensNeyrons(outputDataTwoHiddenNeyron, deltaOutputNeyron, 5);
//
    //deltaTreeHiddenNeyron = deltasHiddensNeyrons(outputDataTreeHiddenNeyron, deltaOutputNeyron, 8);
//
    //GRADweight[0] = gradientSinaps(deltaOneHiddenNeyron, inputNeyronOne);
    //GRADweight[1] = gradientSinaps(deltaOneHiddenNeyron, inputNeyronTwo);
    //GRADweight[9] = gradientSinaps(deltaOneHiddenNeyron, inputNeyronTree);
    //GRADweight[2] = gradientSinaps(deltaOutputNeyron, outputDataOneHiddenNeyron);
//
    //GRADweight[3] = gradientSinaps(deltaTwoHiddenNeyron, inputNeyronOne);
    //GRADweight[4] = gradientSinaps(deltaTwoHiddenNeyron, inputNeyronTwo);
    //GRADweight[10] = gradientSinaps(deltaTwoHiddenNeyron, inputNeyronTree);
    //GRADweight[5] = gradientSinaps(deltaOutputNeyron, outputDataTwoHiddenNeyron);
//
    //GRADweight[6] = gradientSinaps(deltaTreeHiddenNeyron, inputNeyronOne);
    //GRADweight[7] = gradientSinaps(deltaTreeHiddenNeyron, inputNeyronTwo);
    //GRADweight[11] = gradientSinaps(deltaTreeHiddenNeyron, inputNeyronTree);
    //GRADweight[8] = gradientSinaps(deltaOutputNeyron, outputDataTreeHiddenNeyron);
//
//
    //for (int i = 0; i < deltasSinaps.length; i++)
    //    deltasSinaps[i] = deltasSinaps(moment, epsilon, deltasSinaps[i], GRADweight[i]);
//
    //for (int i = 0; i < sinapsWeight.length; i++)
    //    sinapsWeight[i] = summDeltaWSimpleW(sinapsWeight[i], deltasSinaps[i]);
//}






    /* private static double mutpleSum(int i, int g, int f, double inputDataOne, double inputDataTwo, double inputDataTree) {
        return (inputDataOne * sinapsWeight[i]) + (inputDataTwo * sinapsWeight[g]) + (inputDataTree * sinapsWeight[f]);
    }*/
}
