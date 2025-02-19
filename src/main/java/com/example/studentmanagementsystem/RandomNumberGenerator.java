package com.example.studentmanagementsystem;

import java.security.SecureRandom;

public class RandomNumberGenerator {
    public Long generateStudentID() {
        SecureRandom randomNumberGenerator = new SecureRandom();
        return 1000000000L + randomNumberGenerator.nextLong(9000000000L);
    }
}
