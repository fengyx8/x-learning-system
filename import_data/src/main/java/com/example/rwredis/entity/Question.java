package com.example.rwredis.entity;

/**
 * @author: Clivia-Han
 * @projectName: redis_rw_test
 * @packageName: com.example.rwredis.entity
 * @Description:
 * @create: 2021-06-16
 */
public class Question {
    private String queId;
    private String problem;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String stdAns;
    private String analysis;
    private int points;
    private int answererNumber;
    private int correctAnsNumber;

    public Question(String problem, String optionA, String optionB, String optionC, String optionD, String stdAns, String analysis, int points, int answererNumber, int correctAnsNumber) {
        this.problem = problem;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.stdAns = stdAns;
        this.analysis = analysis;
        this.points = points;
        this.answererNumber = answererNumber;
        this.correctAnsNumber = correctAnsNumber;
    }

    public String getQueId() {
        return queId;
    }

    public void setQueId(String queId) {
        this.queId = queId;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getStdAns() {
        return stdAns;
    }

    public void setStdAns(String stdAns) {
        this.stdAns = stdAns;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAnswererNumber() {
        return answererNumber;
    }

    public void setAnswererNumber(int answererNumber) {
        this.answererNumber = answererNumber;
    }

    public int getCorrectAnsNumber() {
        return correctAnsNumber;
    }

    public void setCorrectAnsNumber(int correctAnsNumber) {
        this.correctAnsNumber = correctAnsNumber;
    }
}
