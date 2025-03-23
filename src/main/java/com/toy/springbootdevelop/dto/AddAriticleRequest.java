package com.toy.springbootdevelop.dto;

import com.toy.springbootdevelop.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddAriticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder().title(title).content(content).build();
    }
}
