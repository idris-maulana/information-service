package com.idris.information.model;

import com.idris.information.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "banners")
public class Banner extends BaseEntity {

    @Column(name = "banner_name")
    private String bannerName;

    @Column(name = "banner_image")
    private String bannerImage;

    @Column(name = "description")
    private String description;

}
