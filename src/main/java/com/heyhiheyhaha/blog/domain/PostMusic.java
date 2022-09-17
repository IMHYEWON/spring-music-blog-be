package com.heyhiheyhaha.blog.domain;

import javax.persistence.*;

@Entity
public class PostMusic {

    @Id @GeneratedValue
    @Column(name="postmusic_id")
    private String id;

    @ManyToOne
    @JoinColumn(name="music_id")
    private Music music;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    public void setPostMusic(Post post) {
    }
}
