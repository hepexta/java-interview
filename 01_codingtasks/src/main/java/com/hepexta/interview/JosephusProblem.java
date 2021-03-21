package com.hepexta.interview;

public class JosephusProblem {
    static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        else {
            int positionNotInCircle = josephus(n - 1, k) + k - 1;
            return positionNotInCircle % n + 1;
        }
    }
}
