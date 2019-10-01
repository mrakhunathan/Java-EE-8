/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.imaginovation.ee8.users;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import net.imaginovation.ee8.utils.EntityManagerUtil;

/**
 *
 * @author Rakhunathan
 */
public class UserDao {

    public List<User> getAllUsers() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            return em.createQuery("Select c from User c order by c.id").getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Transactional
    public void createUser(User user) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteUserById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(User.class, id));
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public User getUserById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            return em.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
