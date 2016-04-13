package com.fsep.services.sms;

import com.fsep.services.sms.dao.SmsDao;
import com.fsep.services.sms.models.Sms;
import com.fsep.services.sms.retrofit.RetrofitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 13.01.16
 * SmsServiceImpl
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private RetrofitService retrofitService;

    @Value("${sms.aero.password.hash}")
    private String passwordHash;

    @Autowired
    private SmsDao smsDao;

    @Value("${sms.aero.user}")
    private String user;

    @Value("${sms.aero.from}")
    private String from;

    public String getBalance() {
        return retrofitService.invokeGetBalanceSender(user, passwordHash);
    }

    public Sms sendSms(String receiverNumber, String text) {
        Sms sms = retrofitService.invokeSendSmsSender(user, passwordHash, receiverNumber, text, from);
        return smsDao.saveSms(sms);
    }

    public String getStatus(int aeroId) {
        return retrofitService.invokeGetSmsStatusSender(user, passwordHash, aeroId);
    }
}
