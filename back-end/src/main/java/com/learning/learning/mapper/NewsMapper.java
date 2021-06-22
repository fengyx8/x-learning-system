package com.learning.learning.mapper;

import com.learning.learning.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface NewsMapper {
    /**
     *
     * @param id
     * @return
     */
    List<News> selectNewsByNewsIds(@Param("id") List<String> id);

    /**
     *
     * @param id
     * @return Query
     */
    @Select("SELECT * FROM news WHERE id = #{id}")
    List<News> selectNewsByNewsId(@Param("id") String id);

}
