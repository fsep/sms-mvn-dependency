package com.fsep.services.sms.dao;

import com.fsep.services.sms.models.Sms;

/**
 * 02.04.16
 * SmsDao
 *
 * @author Ildar Almakayev (First Software Engineering Platform)
 * @version v1.0
 */
public interface SmsDao {
    Sms saveSms(Sms sms);
}
