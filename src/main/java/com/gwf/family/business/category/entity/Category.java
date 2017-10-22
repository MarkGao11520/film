package com.gwf.family.business.category.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import io.swagger.annotations.*;

/**
* Created with gwf on 2017-10-20 11:37:15.
*/
@Entity
@Data
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category  implements Serializable{

    /** category_id */
    @Id
    @ApiModelProperty(value = "类目id")
    private Byte categoryId;
    /** name */
    @ApiModelProperty(value = "类目名称")
    private String name;
    /** last_update */
    @ApiModelProperty(value = "最后修改时间")
    private Date lastUpdate;

}

