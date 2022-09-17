package com.heyhiheyhaha.blog.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class Post {

    @Id @GeneratedValue
    @Column(name= "post_id")
    private long Id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private PostType type;

    @OneToMany
    private List<postMusic> postMusics = new ArrayList<>();

    private LocalDateTime postDate;

}
