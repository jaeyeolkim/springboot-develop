package com.toy.springbootdevelop.service;

import com.toy.springbootdevelop.domain.Article;
import com.toy.springbootdevelop.dto.AddAriticleRequest;
import com.toy.springbootdevelop.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddAriticleRequest addAriticleRequest) {
        return blogRepository.save(addAriticleRequest.toEntity());
    }
}
