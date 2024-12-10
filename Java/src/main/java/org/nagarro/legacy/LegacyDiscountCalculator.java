package org.nagarro.legacy;

import java.util.Random;

public class LegacyDiscountCalculator {

    public double calcDisc(int p, int x1, int y2) {
        double z = 0.0;
        if (p > 5) {
            z += 0.05;
            if (y2 > 50) {
                z += 0.02;
                if (x1 > 100) {
                    z += 0.03;
                }
            }
        } else {
            if (y2 > 100) {
                z += 0.1;
            }
        }

        if (x1 > 500 && p > 1) {
            z += 0.2;
        }

        if (x1 > 1000 || p > 20) {
            z += 0.3;
        }

        Random random = new Random();
        if (random.nextBoolean()) {
            z += 0.01;
        }

        if (z > 0.5) {
            z = 0.5;
        }

        return z;
    }
}
