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
     * @param newsId
     * @return
     */
    List<News> selectNewsByNewsIds(@Param("skuIds") List<String> newsId);

    /**
     *
     * @param newsId
     * @return Query
     */
    @Select("SELECT * FROM News WHERE newsId = #{newsId}")
    List<News> selectNewsByNewsId(@Param("newsId") String newsId);

}
