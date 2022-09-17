package com.heyhiheyhaha.blog.repository;

import com.heyhiheyhaha.blog.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    //저장
    public void save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    //
    public User findOne(Long id) {
        return em.find(User.class, id);
    }
}
