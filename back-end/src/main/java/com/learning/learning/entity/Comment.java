package com.learning.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.entity
 * @Description:
 * @create: 2021-04-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String commentId;
    private String content;
    private Timestamp time;
    private String userId;
    private String noteId;
    private Integer status;
}
