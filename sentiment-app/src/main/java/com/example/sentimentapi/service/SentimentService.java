package com.example.sentimentapi.service;

import com.vader.sentiment.analyzer.SentimentAnalyzer;
import com.vader.sentiment.analyzer.SentimentPolarities;
import org.springframework.stereotype.Service;

@Service
public class SentimentService {

    public String classify(String text) {
        if (text == null || text.isBlank()) {
            return "neutral";
        }

        SentimentPolarities polarities = SentimentAnalyzer.getScoresFor(text);
        double compound = polarities.getCompoundPolarity();

        if (compound >= 0.05) {
            return "positive";
        } else if (compound <= -0.05) {
            return "negative";
        } else {
            return "neutral";
        }
    }
}
