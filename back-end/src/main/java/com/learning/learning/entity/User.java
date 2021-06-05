package com.learning.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String userId;
    private String name;
    private String secureQue;
    private String secureAns;
    private String mail;
    private String org;
    private Double score;
}
