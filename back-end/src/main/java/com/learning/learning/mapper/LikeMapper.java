package com.learning.learning.mapper;

import com.learning.learning.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jbk-xiao
 * @version 2021-06-05-15:39
 */
@Mapper
@Repository
public interface LikeMapper {

    int add(Like like);

    int delete(Like like);

    List<String> getByContentId(String contentId);
}
