/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.imaginovation.ee8.utils;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rakhunathan
 */
public class EntityManagerUtil {

    private static EntityManagerFactory entityManagerFactory = null;

    private static final String URL_PREFIX = "jdbc:postgresql://";
    private static final String DBNAME = "test";

    /**
     * Singleton Factory to prepare Entity Manager Instance.
     *
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("ee8",
                        readEnvironmentSettings());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entityManagerFactory.createEntityManager();
    }

    /**
     * Construction of Environment based Configuration Parameters for Entity
     * Manager.
     *
     * @return Map Environment Settings
     */
    private static Map<String, Object> readEnvironmentSettings() {
        Map<String, Object> configOverrides = new HashMap<>();
        configOverrides.put("hibernate.connection.username", "postgres");
        configOverrides.put("hibernate.connection.url", URL_PREFIX + "localhost:5432/test");
        configOverrides.put("hibernate.connection.password", "postgres");
        return configOverrides;
    }

    /**
     * Close the entity manager factory.
     */
    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        EntityManagerUtil.entityManagerFactory = entityManagerFactory;
    }
}
