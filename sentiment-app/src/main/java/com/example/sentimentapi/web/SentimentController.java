package com.example.sentimentapi.web;

import com.example.sentimentapi.service.SentimentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SentimentController {

    private final SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @GetMapping("/api/sentiment")
    public Map<String, String> getSentiment(@RequestParam String text) {
        String sentiment = sentimentService.classify(text);
        return Map.of("sentiment", sentiment);
    }
}
