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
        ExitValue exitValueVariable  = new ExitValue();
        String inputValue;
        int i = 0;

        do {
            if(i == 0) {
                System.out.println("Please, enter distance or Q for exit");
            } else {
                System.out.println("Please, enter weight or Q for exit");
            }

            inputValue = scanner.next();

            if (!exitValueVariable.isExitValue(inputValue)){
                if(CorrectDoubleValue.isCorrectDoubleValue(inputValue)){
                    enteredValues[i] = Double.parseDouble(inputValue);
                    i++;
                }
            }

            if (i == 2) {
                Oder oder = new Oder(enteredValues[0], enteredValues[1]);
                System.out.println(oder.calculation());
                oder.getInformationAboutOder();
                oder.writeToFile();
                i=0;
            }

        } while (!exitValueVariable.isExitValue(inputValue));

        System.out.println("Finish!");


    }


}


