package com.company.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
class Alert {
    private String status;
    private Map<String, String> labels;
    private Map<String, String> annotations;
    private String startsAt;
    private String endsAt;
    private String generatorURL;
    private String fingerprint;

    // Getters and setters
}
