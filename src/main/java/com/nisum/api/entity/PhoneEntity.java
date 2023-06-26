package com.nisum.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "phone")
@Data
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phoneId;

    private String number;

    private String cityCode;

    private String countryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity user;

}