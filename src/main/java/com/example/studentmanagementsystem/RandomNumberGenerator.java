package com.example.studentmanagementsystem;

import java.util.Random;

public class RandomNumberGenerator {
    public Long generateStudentID() {
        Random randomNumberGenerator = new Random();
        return 1000000000L + randomNumberGenerator.nextLong(9000000000L);
    }
}
