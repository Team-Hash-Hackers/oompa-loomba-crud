package com.napptilus.willywonka.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Entity Object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_OOMPA_LOOMPA")
@Builder(toBuilder = true)
public class OompaLoompa implements Serializable {

    /**
     * Property serialVersionUID To Track Changes of Entity Serialization
     */
    private static final long serialVersionUID = 0L;

    /**
     * Property ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Property NAME
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Property AGE
     */
    @Column(name = "AGE")
    private short age;

    /**
     * Property JOB(Title or Designation)
     */
    @Column(name = "JOB")
    private String jobTitle;

    /**
     * Property HEIGHT
     */
    @Column(name = "HEIGHT")
    private float height;

    /**
     * Property WEIGHT
     */
    @Column(name = "WEIGHT")
    private float weight;

    /**
     * Property DESCRIPTION
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * Property CREATED AT(DATE CREATED)
     */
    @ApiModelProperty(hidden = true)
    @Column(name = "CREATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private Date createdAt;

    /**
     * Property UPDATED AT(DATE UPDATED)
     */
    @ApiModelProperty(hidden = true)
    @Column(name = "UPDATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private Date updatedAt;

}
