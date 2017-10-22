package com.gwf.family.business.category.service.impl;

import com.gwf.family.business.category.dao.CategoryRepository;
import com.gwf.family.business.category.entity.Category;
import com.gwf.family.business.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import com.gwf.family.business.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by gwf on 2017-10-20 11:37:15.
 */
@Service
@Transactional
public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

}
