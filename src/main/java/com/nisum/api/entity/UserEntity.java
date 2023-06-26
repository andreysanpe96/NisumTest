package com.nisum.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "userNisum")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String userId;
    private String name;
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userId")
    private List<PhoneEntity> phones;
    private String token;
    private Boolean isActive;

}
