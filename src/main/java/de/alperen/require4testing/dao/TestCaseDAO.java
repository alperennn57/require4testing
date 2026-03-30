package de.alperen.require4testing.dao;

import java.util.List;

import de.alperen.require4testing.model.TestCase;
import de.alperen.require4testing.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestCaseDAO {

    public void save(TestCase testCase) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(testCase);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<TestCase> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT t FROM TestCase t", TestCase.class).getResultList();
        } finally {
            em.close();
        }
    }
}