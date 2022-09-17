package com.heyhiheyhaha.blog.repository;

import com.heyhiheyhaha.blog.domain.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MusicRepository {

    private final EntityManager em;

    //저장
    public void save(Music music) {
        if (music.getId() == null) {
            em.persist(music);
        } else {
            em.merge(music);
        }
    }

    //
    public Music findOne(Long id) {
        return em.find(Music.class, id);
    }
}
