package de.alperen.require4testing.dao;

import java.util.List;

import de.alperen.require4testing.model.Requirement;
import de.alperen.require4testing.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class RequirementDAO {

    public void save(Requirement requirement) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(requirement);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Requirement> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Requirement r", Requirement.class).getResultList();
        } finally {
            em.close();
        }
    }
}