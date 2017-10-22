package com.gwf.family.business.actor.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import io.swagger.annotations.*;

/**
* Created with gwf on 2017-10-21 17:14:15.
*/
@Entity
@Data
@Table(name = "actor")
public class Actor  implements Serializable{
    public Actor(){
    }

    public Actor(Integer actorId,String firstName,String lastName,Date lastUpdate){
        this.actorId=actorId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.lastUpdate=lastUpdate;
    }

    /** actor_id */
    @Id
    @ApiModelProperty(value = "actor_id")
    private Integer actorId;
    /** first_name */
    @ApiModelProperty(value = "first_name")
    private String firstName;
    /** last_name */
    @ApiModelProperty(value = "last_name")
    private String lastName;
    /** last_update */
    @ApiModelProperty(value = "last_update")
    private Date lastUpdate;

}

