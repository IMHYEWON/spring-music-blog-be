package com.heyhiheyhaha.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private Long Id;

    private String name;
}
