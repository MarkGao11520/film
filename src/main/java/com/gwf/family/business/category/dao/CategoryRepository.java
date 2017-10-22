package com.gwf.family.business.category.dao;

import com.gwf.family.business.core.mapper.Mapper;
import com.gwf.family.business.category.entity.Category;

import java.util.List;

/**
* Created with gwf on 2017-10-20 11:37:15.
*/
@org.apache.ibatis.annotations.Mapper
public interface CategoryRepository extends Mapper<Category> {

    /**
     * 根据电影id查询类目列表
     * @param filmId
     * @return
     */
    List<Category> findByFilmId(Integer filmId);
}

