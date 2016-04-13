package com.fsep.services.sms;

import com.fsep.services.sms.models.Sms;

/**
 * 13.01.16
 * SmsService
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */
public interface SmsService {

    /**
     * Send message to client
     * @param receiverNumber phone number of client
     * @param text text of message
     * @return id and status of message
     */
    Sms sendSms(String receiverNumber, String text);

    /**
     * Get balance in SmsAero
     * @return balance in rubles
     */
    String getBalance();

    /**
     * Get status of the sms
     * @param aeroId id of sms in SmsAero system
     * @return status of message
     */
    String getStatus(int aeroId);
}
