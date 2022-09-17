package com.heyhiheyhaha.blog.repository;

import com.heyhiheyhaha.blog.domain.Post;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    private final EntityManager em;

    public PostRepository(EntityManager em) {this.em = em;}

    public void save(Post post) {
        em.persist(post);
    }

    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    // 글 제목으로 검색
    public List<Post> findAllByTitle(String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> p = cq.from(Post.class);

        List<Predicate> criteria = new ArrayList<>();

        if (StringUtils.hasText(title)) {
            Predicate titleResult = cb.like(p.get("title"), "%" + title + "%");
            criteria.add(titleResult);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Post> query = em.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }
}
