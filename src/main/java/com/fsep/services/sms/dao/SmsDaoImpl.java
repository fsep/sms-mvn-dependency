package com.fsep.services.sms.dao;

import com.fsep.services.sms.models.Sms;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 02.04.16
 * SmsDaoImpl
 *
 * @author Ildar Almakayev (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class SmsDaoImpl implements SmsDao {
    @PersistenceContext
    private EntityManager em;

    public Sms saveSms(Sms sms) {
        em.persist(sms);
        return sms;
    }
}
