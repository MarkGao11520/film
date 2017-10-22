package com.gwf.family.business.film.service;
import com.gwf.family.business.film.dto.FilmQueryCondition;
import com.gwf.family.business.film.dto.FilmResult;
import com.gwf.family.business.film.entity.Film;
import com.gwf.family.business.core.service.Service;

import java.util.List;


/**
 * Created by gwf on 2017-10-19 21:50:28.
 */
public interface FilmService extends Service<Film> {

    /**
     * 根据条件获取电影列表
     * @param filmQueryCondition
     * @return
     */
    List<FilmResult> findbyQueryCondition(FilmQueryCondition filmQueryCondition);

    /**
     * 根据演员id获取电影列表
     * @param actorId
     * @return
     */
    List<FilmResult> findByActorId(Integer actorId);
}
