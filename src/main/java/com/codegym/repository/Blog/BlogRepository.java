package com.codegym.repository.Blog;

import com.codegym.model.Blog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository {
    SessionFactory sessionFactory;
    EntityManager entityManager;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("SELECT b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        Query query = em.createQuery("SELECT B FROM Blog B where B.id = ?1");
        query.setParameter(1, id);
        return (Blog) query.getSingleResult();
    }

    @Override
    public void update(Blog model) {

        if (model.getId() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            em.remove(blog);
        }
    }

    @Override
    public void insert(Blog blog) {
        em.persist(blog);
    }
}
