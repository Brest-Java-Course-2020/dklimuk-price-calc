package com.epam.brest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PriceFromFile {
    public static double getPrice(double enterNumKmOrKg, String pathName) {
        double enterNum = enterNumKmOrKg;
        double pricePer = 0;
        File priceFile = new File(pathName);
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

                if (enterNum >= arrayWithIntNumber[0]){
                    pricePer = arrayWithIntNumber[1];
                    flag = false;
                }
            }

            scanner.close();
        } catch (FileNotFoundException var14) {
            System.out.println("An error occurred.");
            var14.printStackTrace();
        }

        return pricePer;
    }
}
