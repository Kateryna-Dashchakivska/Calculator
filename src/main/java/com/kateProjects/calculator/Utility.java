package com.kateProjects.calculator;

public class Utility {
    private static double threshold = 0.0000000000000000000001;

    public boolean isZero(double value){
        return value >= -threshold && value <= threshold;
    }

}
