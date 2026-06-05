package com.example.passwordanalyzer.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PasswordAnalyzerService {

    public int calculateScore(String password) {

        int score = 0;

        if (password.length() >= 8)
            score += 20;

        if (password.matches(".*[A-Z].*"))
            score += 20;

        if (password.matches(".*[a-z].*"))
            score += 20;

        if (password.matches(".*\\d.*"))
            score += 20;

        if (password.matches(".*[^a-zA-Z0-9].*"))
            score += 20;

        return score;
    }

    public String getStrength(int score) {

        if (score < 40)
            return "Weak";

        if (score < 80)
            return "Medium";

        return "Strong";
    }

    public double calculateEntropy(String password) {

        int charsetSize = 0;

        if (password.matches(".*[a-z].*"))
            charsetSize += 26;

        if (password.matches(".*[A-Z].*"))
            charsetSize += 26;

        if (password.matches(".*\\d.*"))
            charsetSize += 10;

        if (password.matches(".*[^a-zA-Z0-9].*"))
            charsetSize += 32;

        return password.length()
                * (Math.log(charsetSize) / Math.log(2));
    }

    public List<String> getSuggestions(String password) {

        List<String> suggestions = new ArrayList<>();

        String lower = password.toLowerCase();

        if (lower.equals("123456") ||
            lower.equals("password") ||
            lower.equals("qwerty") ||
            lower.equals("admin") ||
            lower.equals("abc123")) {

            suggestions.add("Avoid common passwords");
        }

        if (!password.matches(".*[A-Z].*")) {
            suggestions.add("Add uppercase letters");
        }

        if (!password.matches(".*\\d.*")) {
            suggestions.add("Add numbers");
        }

        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            suggestions.add("Add special characters");
        }

        if (password.length() < 12) {
            suggestions.add("Use at least 12 characters");
        }

        return suggestions;
    }

    public String generatePassword(int length) {

        String chars =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz" +
                "0123456789" +
                "!@#$%^&*()";

        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }
}