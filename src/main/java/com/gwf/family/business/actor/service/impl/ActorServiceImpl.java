package com.gwf.family.business.actor.service.impl;

import com.gwf.family.business.actor.dao.ActorRepository;
import com.gwf.family.business.actor.entity.Actor;
import com.gwf.family.business.actor.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import com.gwf.family.business.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by gwf on 2017-10-21 17:14:15.
 */
@Service
@Transactional
public class ActorServiceImpl extends AbstractService<Actor> implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

}
