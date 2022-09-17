package com.heyhiheyhaha.blog.api;

import com.heyhiheyhaha.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostApi {

    @Autowired
    private PostService postService;

    @PostMapping
    public Long createPost(@RequestParam("userId") Long userId,
                             @RequestParam("musicId") Long musicId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {
        // dto > entity 변환 과정추가 예정
        return postService.post(userId, musicId, title, content);
    }
}
