package com.toy.springbootdevelop.controller;

import com.toy.springbootdevelop.domain.Article;
import com.toy.springbootdevelop.dto.AddAriticleRequest;
import com.toy.springbootdevelop.dto.ArticleResponse;
import com.toy.springbootdevelop.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody AddAriticleRequest request) {
        Article article = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ArticleResponse(article));
    }
}
