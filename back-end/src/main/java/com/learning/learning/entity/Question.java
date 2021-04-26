package com.learning.learning.entity;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.entity
 * @Description:
 * @create: 2021-04-25
 */
public class Question {
    private String queId;
    private String problem;
    private String stdAns;
    private String analysis;
    private float points;
    private int answererNumber;
    private int correctAnsNumber;

    public Question(String queId, String problem, String stdAns, String analysis, float points, int answererNumber, int correctAnsNumber) {
        this.queId = queId;
        this.problem = problem;
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

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
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
