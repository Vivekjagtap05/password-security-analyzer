package com.example.passwordanalyzer.model;

import java.util.List;

public class PasswordResponse {

    private int score;
    private String strength;
    private double entropy;
    private String message;
    private List<String> suggestions;

    public PasswordResponse() {
    }

    public PasswordResponse(int score, String strength,
            double entropy, String message,
            List<String> suggestions) {

        this.score = score;
        this.strength = strength;
        this.entropy = entropy;
        this.message = message;
        this.suggestions = suggestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public double getEntropy() {
        return entropy;
    }

    public void setEntropy(double entropy) {
        this.entropy = entropy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }
}