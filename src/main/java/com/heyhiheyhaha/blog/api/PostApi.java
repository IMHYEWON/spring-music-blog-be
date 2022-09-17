package com.heyhiheyhaha.blog.api;

import com.heyhiheyhaha.blog.domain.Post;
import com.heyhiheyhaha.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostApi {

    @Autowired
    private PostService postService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{title}")
    public List<Post> findPost(@PathVariable("title") String title){
        logger.info("find post by title : "+ title);
        return postService.findPosts(title);
    }
    @PostMapping()
    public Long createPost(@RequestParam("userId") Long userId,
                             @RequestParam("musicId") Long musicId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {
        // dto > entity 변환 과정추가 예정
        logger.info("create post : " + title + "/" + content);
        return postService.post(userId, musicId, title, content);
    }
}
