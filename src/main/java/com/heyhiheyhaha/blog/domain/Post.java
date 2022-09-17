package com.heyhiheyhaha.blog.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Post {

    @Id @GeneratedValue
    @Column(name= "post_id")
    private long Id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Setter
    private String title;

    @Setter
    private String content;

    @Enumerated(EnumType.STRING)
    private PostType type;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostMusic> postMusics = new ArrayList<>();

    private LocalDateTime postDate;

    //==연관관계 메서드==//
    public void setUser(User user) {
        this.user = user;
        user.getPosts().add(this); //애매함
    }

    public void addPostMusic(PostMusic postMusic) {
        postMusics.add(postMusic);
        postMusic.setPostMusic(this); //애매함
    }

    //==생성관계 메서드==//
    @Builder(builderMethodName = "createBuilder")
    public Post(User user, String title, String content, PostMusic postMusic) {
        setUser(user);
        this.title = title;
        this.content = content;
        addPostMusic(postMusic);
/*        for (PostMusic postMusic : postMusics) {
            addPostMusic(postMusic);
        }*/
        this.type = PostType.MUSIC;
        this.postDate = LocalDateTime.now();
    }

    //==조회 메소드==//
    public int getMusicCount() {
        return getPostMusics().size();
    }
}
