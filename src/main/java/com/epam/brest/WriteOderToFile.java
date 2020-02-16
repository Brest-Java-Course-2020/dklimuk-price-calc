package com.epam.brest;

import java.io.FileWriter;
import java.io.IOException;

public class WriteOderToFile {

    static FileWriter writer;

    static {
        try {
            writer = new FileWriter("calculationDataFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WriteOderToFile() throws IOException {
    }
    static int count = 0;
    public static void write(double numOfKm, double pricePerKm, double numOfKg, double pricePerKg, double resultCalculation) throws IOException {

        writer.write( count++ + ") " +
                "distance: " + numOfKm+
                " price per km: " +pricePerKm +
                " weight: " + numOfKg +
                " price per kg: " + pricePerKg +
                " Price: " + resultCalculation +"$!" + '\n');
        writer.flush();


    }

}

