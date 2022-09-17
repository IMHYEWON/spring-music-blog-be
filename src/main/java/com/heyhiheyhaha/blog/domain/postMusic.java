package com.heyhiheyhaha.blog.domain;

import javax.persistence.*;

@Entity
public class postMusic {

    @Id @GeneratedValue
    @Column(name="postMusic_id")
    private String id;

    @ManyToOne
    @JoinColumn(name="music_id")
    private Music music;

}
