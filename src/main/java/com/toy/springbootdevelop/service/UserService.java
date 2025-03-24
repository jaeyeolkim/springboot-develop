package com.toy.springbootdevelop.service;

import com.toy.springbootdevelop.domain.User;
import com.toy.springbootdevelop.dto.AddUserRequest;
import com.toy.springbootdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest request) {
        User user = request.toEntity();
        user.encodePassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }
}
