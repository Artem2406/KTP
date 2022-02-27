package com.company;

public class primes {
    public static void main(String[] args) {
        int n = 100;

        for(int i = 2; i <= n; ++i) {
            if (IsPrime(i)) {
                System.out.println(i + " - простое число");
            }
        }

    }

    public static boolean IsPrime(int n) {
        for(int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
