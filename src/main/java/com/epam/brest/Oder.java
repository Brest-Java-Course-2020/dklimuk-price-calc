package com.epam.brest;

import java.io.IOException;

public class Oder {

    public Oder(double numOfKm, double numOfKg) throws IOException {
        this.numOfKm = numOfKm;
        this.numOfKg = numOfKg;
    }

    private double numOfKm;
    private double numOfKg;
    private double pricePerKm;
    private double pricePerKg;
    private double result;

    public double calculation(){
        pricePerKg = PriceFromFile.getPrice(numOfKg, "pricePerKg.txt");
        pricePerKm = PriceFromFile.getPrice(numOfKm, "pricePerKm.txt");
        return result = numOfKm * pricePerKm + numOfKg * pricePerKg;
    }

    public void getInformationAboutOder(){
        System.out.println("Distance: " + numOfKm +
                ", price per km: " + pricePerKm + ";" +
                ";\nWeight: " + numOfKg +
                ", price per kg: " + pricePerKg +
                "\nPrice: " + result + " $!");
    }
    public void writeToFile() throws IOException {
        WriteOderToFile.write(numOfKm, pricePerKm, numOfKg, pricePerKg, result);
    }

}
