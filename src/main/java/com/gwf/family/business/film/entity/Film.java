package com.gwf.family.business.film.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.*;
import lombok.NoArgsConstructor;

/**
* Created with gwf on 2017-10-19 21:50:28.
*/
@Entity
@Data
@Table(name = "film")
@NoArgsConstructor
@AllArgsConstructor
public class Film  implements Serializable{

    /** film_id */
    @Id
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
    @ApiModelProperty(value = "语言id")
    private Byte languageId;
    /** original_language_id */
    @ApiModelProperty(value = "源语言id")
    private Byte originalLanguageId;
    /** rental_duration */
    @ApiModelProperty(value = "rental_duration")
    private Byte rentalDuration;
    /** rental_rate */
    @ApiModelProperty(value = "rental_rate")
    private BigDecimal rentalRate;
    /** length */
    @ApiModelProperty(value = "时长")
    private Short length;
    /** replacement_cost */
    @ApiModelProperty(value = "replacement_cost")
    private BigDecimal replacementCost;
    /** rating */
    @ApiModelProperty(value = "rating")
    private String rating;
    /** special_features */
    @ApiModelProperty(value = "特别预期")
    private String specialFeatures;
    /** last_update */
    @ApiModelProperty(value = "最后更新")
    private Date lastUpdate;

}

