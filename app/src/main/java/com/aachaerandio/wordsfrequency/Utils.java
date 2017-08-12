package com.aachaerandio.wordsfrequency;

public class Utils {

    public static boolean isPrime(String StringNumber) {
        long number = Long.valueOf(StringNumber);
        for (int i = 2; i <= number/2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
