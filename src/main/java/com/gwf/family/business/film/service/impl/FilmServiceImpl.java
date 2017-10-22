package com.gwf.family.business.film.service.impl;

import com.gwf.family.business.film.dao.FilmRepository;
import com.gwf.family.business.film.dto.FilmQueryCondition;
import com.gwf.family.business.film.dto.FilmResult;
import com.gwf.family.business.film.entity.Film;
import com.gwf.family.business.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import com.gwf.family.business.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by gwf on 2017-10-19 21:50:28.
 */
@Service
@Transactional
public class FilmServiceImpl extends AbstractService<Film> implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<FilmResult> findbyQueryCondition(FilmQueryCondition filmQueryCondition) {
        return filmRepository.findByQueryCondition(filmQueryCondition);
    }

    @Override
    public List<FilmResult> findByActorId(Integer actorId) {
        return filmRepository.findByActorId(actorId);
    }
}
