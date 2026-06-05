package com.example.passwordanalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.passwordanalyzer.model.PasswordRequest;
import com.example.passwordanalyzer.model.PasswordResponse;
import com.example.passwordanalyzer.service.PasswordAnalyzerService;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    @Autowired
    private PasswordAnalyzerService service;

    @PostMapping("/analyze")
    public PasswordResponse analyze(
            @RequestBody PasswordRequest request) {

        int score =
                service.calculateScore(
                        request.getPassword());

        String strength =
                service.getStrength(score);

        double entropy =
                service.calculateEntropy(
                        request.getPassword());

        return new PasswordResponse(
                score,
                strength,
                entropy,
                "Analysis Completed",
                service.getSuggestions(
                        request.getPassword()));
    }

    @GetMapping("/generate")
    public String generatePassword(
            @RequestParam(defaultValue = "12")
            int length) {

        return service.generatePassword(length);
    }
}