package com.learning.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点赞记录
 * @author jbk-xiao
 * @version 2021-06-05-15:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    String userId;
    String contentId;
}
