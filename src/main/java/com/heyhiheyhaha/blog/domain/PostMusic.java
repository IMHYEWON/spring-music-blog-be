package com.heyhiheyhaha.blog.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
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


    @Builder(builderMethodName = "createBuilder")
    public PostMusic(Music music) {
        this.music = music;
    }
}
