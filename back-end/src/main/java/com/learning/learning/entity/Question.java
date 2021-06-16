package com.learning.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Clivia-Han
 * @create 2021-04-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private String queId;
    private String problem;
    private String stdAns;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String analysis;
    private Double points;
    private Integer answererNumber;
    private Integer correctAnsNumber;
}
