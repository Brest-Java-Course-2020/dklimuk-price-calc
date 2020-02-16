package com.epam.brest;

public class CorrectDoubleValue {

    public static boolean isCorrectDoubleValue(String value){
        boolean checkResult;
        try{
            double enteredDoubleValue = Double.parseDouble(value);
            checkResult = enteredDoubleValue >= 0;

        } catch (NumberFormatException ex) {
            checkResult = false;
        }
        return checkResult;

    }
}
