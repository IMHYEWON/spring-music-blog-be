package com.heyhiheyhaha.blog.service;

import com.heyhiheyhaha.blog.domain.Music;
import com.heyhiheyhaha.blog.domain.Post;
import com.heyhiheyhaha.blog.domain.PostMusic;
import com.heyhiheyhaha.blog.domain.User;
import com.heyhiheyhaha.blog.repository.MusicRepository;
import com.heyhiheyhaha.blog.repository.PostRepository;
import com.heyhiheyhaha.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    private final MusicRepository musicRepository;

    @Transactional
    public Long post(Long userId, Long musicId, String title, String content) {
        //엔티티 조회
        User user = userRepository.findOne(userId);
        Music music = musicRepository.findOne(musicId);

        //글-음악
        PostMusic postMusic = PostMusic.createBuilder()
                .music(music)
                .build();

/*        List<PostMusic> postMusicList = new ArrayList<>();
        postMusicList.add(postMusic);*/

        //글
        Post post = Post.createBuilder()
                .user(user)
                .title(title)
                .content(content)
                .postMusic(postMusic)
                .build();

        postRepository.save(post);

        return post.getId();
    }

    public List<Post> findPosts(String title) {
        return postRepository.findAllByTitle(title);
    }
}
