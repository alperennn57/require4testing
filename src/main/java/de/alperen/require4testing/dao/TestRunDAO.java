package de.alperen.require4testing.dao;

import java.util.List;

import de.alperen.require4testing.model.TestRun;
import de.alperen.require4testing.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestRunDAO {

    public void save(TestRun testRun) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(testRun);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(TestRun testRun) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(testRun);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<TestRun> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT t FROM TestRun t", TestRun.class).getResultList();
        } finally {
            em.close();
        }
    }
}