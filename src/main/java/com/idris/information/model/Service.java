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
@Table(name = "services")
public class Service extends BaseEntity {

    @Column(name = "service_code", unique = true)
    private String serviceCode;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "service_icon")
    private String serviceIcon;

    @Column(name = "service_tarif")
    private Long serviceTarif;
}
