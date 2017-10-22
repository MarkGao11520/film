package com.gwf.family.business.film.dto;

import com.gwf.family.business.actor.entity.Actor;
import com.gwf.family.business.category.entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/10/21.
 */
@Data
public class FilmResult {
    /** film_id */
    @ApiModelProperty(value = "电影id")
    private Short filmId;
    /** title */
    @ApiModelProperty(value = "电影标题")
    private String title;
    /** description */
    @ApiModelProperty(value = "电影描述")
    private String description;
    /** release_year */
    @ApiModelProperty(value = "发布年份")
    private String releaseYear;
    /** language_id */
    @ApiModelProperty(value = "语言")
    private String language;
    @ApiModelProperty(value = "类目列表")
    private List<Category> categoryList;
    @ApiModelProperty(value = "影片演员列表")
    private List<Actor> actorList;
}
