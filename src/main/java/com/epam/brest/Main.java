package com.epam.brest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args ) throws IOException {

        Double[] enteredValues = new Double[4];
        Scanner scanner = new Scanner(System.in);
        String inputValue;
        WriteCalculationData writer = new WriteCalculationData();
        int i = 0;

        do {
            if(i == 0) {
                System.out.println("Please, enter distance or Q for exit");
            } else {
                System.out.println("Please, enter weight or Q for exit");
            }

            inputValue = scanner.next();

            if (!isExitValue(inputValue)){
                if(isCorrectDoubleValue(inputValue)){
                    enteredValues[i] = Double.parseDouble(inputValue);
                    i++;
                }
            }

            if (i == 2) {
                double calcResult = enteredValues[0]*getPricePerKm(enteredValues[0])+enteredValues[1]*getPricePerKg(enteredValues[1]);
                System.out.println("Price $ " + calcResult);
                i=0;
                writer.writeToFile(enteredValues[0], getPricePerKm(enteredValues[0]), enteredValues[1], getPricePerKg(enteredValues[1]), calcResult);

            }

        } while (!isExitValue(inputValue));

        System.out.println("Finish!");


    }

    private static boolean isExitValue (String value){

        return (value.equalsIgnoreCase("Q"));
    }

    private static boolean isCorrectDoubleValue (String value)
    {
        boolean checkResult;
        try{
            double enteredDoubleValue = Double.parseDouble(value);
            checkResult = enteredDoubleValue >= 0;

        } catch (NumberFormatException ex) {
            checkResult = false;
        }
        return checkResult;
    }


    public static double getPricePerKm(double enterNumOfKm) {
        double numberOfKm = enterNumOfKm;
        double pricePerKm = 0;
        File priceFile = new File("pricePerKm.txt");
        double[] arrayWithIntNumber = new double[2];

        try {
            Scanner scanner = new Scanner(priceFile);
            boolean flag = true;
            int counter;
            while (scanner.hasNextLine() && flag) {
                String lineWithKeyAndNumberOfKm = scanner.nextLine();
                String[] arrayWithStringNumber = lineWithKeyAndNumberOfKm.split(" ");
                counter = 0;
                for (String number: arrayWithStringNumber){
                    arrayWithIntNumber[counter++] = Integer.parseInt(number);
                }

                if (numberOfKm >= arrayWithIntNumber[0]){
                    pricePerKm = arrayWithIntNumber[1];
                    flag = false;
                }

            }

            scanner.close();
        } catch (FileNotFoundException var14) {
            System.out.println("An error occurred.");
            var14.printStackTrace();
        }

        return pricePerKm;
    }

    public static double getPricePerKg(double enterNumOfKg) {
        double numberOfKm = enterNumOfKg;
        double pricePerKg = 0;
        File priceFile = new File("pricePerKg.txt");
        double[] arrayWithIntNumber = new double[2];

        try {
            Scanner scanner = new Scanner(priceFile);
            boolean flag = true;
            int counter;
            while (scanner.hasNextLine() && flag) {
                String lineWithKeyAndNumberOfKm = scanner.nextLine();
                String[] arrayWithStringNumber = lineWithKeyAndNumberOfKm.split(" ");
                counter = 0;
                for (String number: arrayWithStringNumber){
                    arrayWithIntNumber[counter++] = Integer.parseInt(number);
                }

                if (numberOfKm >= arrayWithIntNumber[0]){
                    pricePerKg = arrayWithIntNumber[1];
                    flag = false;
                }

            }

            scanner.close();
        } catch (FileNotFoundException var14) {
            System.out.println("An error occurred.");
            var14.printStackTrace();
        }

        return pricePerKg;
    }

}


