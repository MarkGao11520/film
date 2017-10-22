package com.gwf.family.business.film.dao;

import com.gwf.family.business.core.mapper.Mapper;
import com.gwf.family.business.film.dto.FilmQueryCondition;
import com.gwf.family.business.film.dto.FilmResult;
import com.gwf.family.business.film.entity.Film;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created with gwf on 2017-10-19 21:50:28.
*/
@org.apache.ibatis.annotations.Mapper
public interface FilmRepository extends Mapper<Film> {

    /**
     * 根据条件查询电影列表
     * @param condition
     * @return
     */
    List<FilmResult> findByQueryCondition(FilmQueryCondition condition);

    /**
     * 根据演员id获取电影列表
     * @param actorId
     * @return
     */
    List<FilmResult> findByActorId(Integer actorId);
}

