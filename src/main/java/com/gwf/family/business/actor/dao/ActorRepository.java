package com.gwf.family.business.actor.dao;

import com.gwf.family.business.core.mapper.Mapper;
import com.gwf.family.business.actor.entity.Actor;

import java.util.List;

/**
* Created with gwf on 2017-10-21 17:14:15.
*/
@org.apache.ibatis.annotations.Mapper
public interface ActorRepository extends Mapper<Actor> {

    /**
     * 根据影片id查询演员列表
     * @param filmId
     * @return
     */
    List<Actor> findByFilmId(Integer filmId);
}

