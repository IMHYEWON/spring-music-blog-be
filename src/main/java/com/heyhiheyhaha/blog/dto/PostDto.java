package com.heyhiheyhaha.blog.dto;

import com.heyhiheyhaha.blog.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    public Long userId;
    public Long musicId;
    public String title;
    public String content;



}
