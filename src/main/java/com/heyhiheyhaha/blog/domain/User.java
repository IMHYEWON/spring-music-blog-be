package com.heyhiheyhaha.blog.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private Long Id;

    private String name;

    @OneToMany
    private List<Post> posts = new ArrayList<>();
}
