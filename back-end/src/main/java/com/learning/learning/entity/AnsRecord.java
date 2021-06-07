package com.learning.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author Clivia-Han
 * @create 2021-04-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnsRecord {
    private String ansId;
    private String queId;
    private String userId;
    private String ans;
    private Boolean isCorrect;
    private Timestamp time;
    public AnsRecord(String queId, String userId, String ans, Boolean isCorrect) {
        this.queId = queId;
        this.userId = userId;
        this.ans = ans;
        this.isCorrect = isCorrect;
    }
}
