package com.epam.brest;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCalculationData {

    FileWriter writer = new FileWriter("calculationDataFile");

    public WriteCalculationData() throws IOException {
    }
    int count = 0;
    public void writeToFile(double valueOfKm, double pricePerKm, double valueOfKg, double pricePerKg, double calcResult) throws IOException {

        writer.write( count++ + ") " +
                "distance: " + valueOfKm +
                " price per km: " +pricePerKm +
                " weight: " + valueOfKg +
                " price per kg: " + pricePerKg +
                "   Price: " + calcResult +"$!" + '\n');
        writer.flush();


    }

}

