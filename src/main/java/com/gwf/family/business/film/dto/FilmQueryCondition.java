package com.gwf.family.business.film.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by gaowenfeng on 2017/10/20.
 */
@Data
public class FilmQueryCondition {
    @ApiModelProperty("影片名称或者影片介绍的模糊查询")
    private String title;
    @ApiModelProperty("影片分类的模糊查询")
    private String category;
    @ApiModelProperty("发行年份,四位")
    private String releaseYear;
    @ApiModelProperty("语言id")
    private String languageId;
}
