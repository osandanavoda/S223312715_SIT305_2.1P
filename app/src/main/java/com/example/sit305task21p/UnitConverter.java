package com.example.sit305task21p;

import android.util.Log;

public class UnitConverter {


    //Length Conversions
    public static double convertLength(double value, String sourceUnit, String destinationUnit) {

        double result = 0;
        switch (sourceUnit) {
            case "Inch":
                result = convertInch(value, destinationUnit);
                break;
            case "Foot":
                result = convertFoot(value, destinationUnit);
                break;
            case "Yard":
                result = convertYard(value, destinationUnit);
                break;
            case "Mile":
                result = convertMile(value, destinationUnit);
                break;
        }
        return result;
    }

    //InchConvertion
    private static double convertInch(double value, String destinationUnit) {
        switch (destinationUnit) {
            case "Centimeter":
                return (value * 2.54);
            case "Meter":
                return (value * 0.0254);
            case "Kilometer":
                return (value / 39370);
            default:
            return value;
        }

    }
    //FootConverstion
    private static double convertFoot(double value, String destinationUnit) {
        switch (destinationUnit) {
            case "Centimeter":
                return (value * 30.48);
            case "Meter":
                return (value / 0.3048);
            case "Kilometer":
                return (value / 3281);
            default:
                return value;
        }

    }

    //YardConversion

    private static double convertYard(double value, String destinationUnit) {
        switch (destinationUnit) {
            case "Centimeter":
                return (value * 91.44);
            case "Meter":
                return (value / 1.094);
            case "Kilometer":
                return (value / 1094);
            default:
                return value;
        }

    }

    private static double convertMile(double value, String destinationUnit) {
        switch (destinationUnit) {
            case "Centimeter":
                return (value * 160934);
            case "Meter":
                return (value * 1609.34);
            case "Kilometer":
                return (value * 1.609);
            default:
                return value;
        }

    }


// Weight Conversions
public static double convertWeight(double value, String sourceUnit, String destinationUnit) {
    double result = 0;
    System.out.println(value);
    System.out.println(sourceUnit);
    System.out.println(destinationUnit);

    Log.d("TestApp","THIS IS THE VALUE");
    switch (sourceUnit) {
        case "Pound":
            result = convertPound(value, destinationUnit);
            break;
        case "Ounce":
            result = convertOunce(value, destinationUnit);
            break;
        case "Ton":
            result = convertTon(value, destinationUnit);
            break;
    }
    return result;
}

    //PoundConversion
    private static double convertPound(double value, String destinationUnit){
        switch (destinationUnit){
            case "Kilogram":
                return (value / 2.205);
            case "Gram":
                return (value * 453.6);
            case "Ton":
                return (value / 2000);
            default:
                return value;
        }
    }

    //OunceConversion
    private static double convertOunce(double value, String destinationUnit){
        switch (destinationUnit){
            case "Kilogram":
                return (value / 35.274);
            case "Gram":
                return (value * 28.3495);
            case "Ton":
                return (value / 32000);
            default:
                return value;
        }
    }

    //TonConversion
    private static double convertTon(double value, String destinationUnit){
        switch (destinationUnit){
            case "Kilogram":
                return (value * 907.185);
            case "Gram":
                return (value * 28.35);
            case "Ton":
                return (value / 32000);
            default:
                return value;
        }
    }


    // Temperature Conversions
    public static double convertTemperature(double value, String sourceUnit, String destinationUnit) {
        double result = 0;
        switch (sourceUnit) {
            case "Celsius":
                result = convertCelsius(value, destinationUnit);
                break;
            case "Fahrenheit":
                result = convertFahrenheit(value, destinationUnit);
                break;
            case "Kelvin":
                result = convertKelvin(value, destinationUnit);
                break;
        }
        return result;
    }

    private static double convertCelsius(double value, String destinationUnit) {
        switch (destinationUnit) {
            case "Fahrenheit":
                return (value * 1.8) + 32;
            case "Kelvin":
                return value + 273.15;
            default:
                return value;
        }
    }

    private static double convertFahrenheit(double value, String destinationUnit) {
        switch (destinationUnit) {
            case "Celsius":
                return (value - 32) / 1.8;
            case "Kelvin":
                return (value + 459.67) * 5 / 9;
            default:
                return value;
        }
    }

    private static double convertKelvin(double value, String destinationUnit) {
        switch (destinationUnit) {
            case "Celsius":
                return value - 273.15;
            case "Fahrenheit":
                return (value * 9 / 5) - 459.67;
            default:
                return value;
        }
    }


    }

