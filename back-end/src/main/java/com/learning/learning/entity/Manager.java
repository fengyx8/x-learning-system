package com.learning.learning.entity;

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
public class Manager {
    private String name;
    private String managerId;
    private String password;
    private String mail;
}
