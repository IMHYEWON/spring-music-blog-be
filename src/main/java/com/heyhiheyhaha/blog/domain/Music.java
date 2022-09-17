package com.heyhiheyhaha.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Music {

    @Id @GeneratedValue
    @Column(name="music_id")
    private Long id;

    @Column(name="music_title")
    private String title;

    private String artist;
}
