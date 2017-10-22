package com.gwf.family.business.language.service.impl;

import com.gwf.family.business.language.dao.LanguageRepository;
import com.gwf.family.business.language.entity.Language;
import com.gwf.family.business.language.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import com.gwf.family.business.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by gwf on 2017-10-20 11:37:15.
 */
@Service
@Transactional
public class LanguageServiceImpl extends AbstractService<Language> implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

}
