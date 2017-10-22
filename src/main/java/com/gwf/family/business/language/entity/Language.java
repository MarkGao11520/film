package com.gwf.family.business.language.entity;

import com.alibaba.druid.sql.visitor.functions.Char;
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
@Table(name = "language")
@NoArgsConstructor
@AllArgsConstructor
public class Language  implements Serializable{

    /** language_id */
    @Id
    @ApiModelProperty(value = "语言id")
    private Byte languageId;
    /** name */
    @ApiModelProperty(value = "语言名")
    private String name;
    /** last_update */
    @ApiModelProperty(value = "最后更新时间")
    private Date lastUpdate;

}

