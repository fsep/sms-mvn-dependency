package com.fsep.services.sms.retrofit.senders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit.Retrofit;

/**
 * 15.01.16
 * SendersStore
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class SendersStore {

    private GetBalanceSender getBalanceSender;
    private SendSmsSender sendSmsSender;
    private GetSmsStatusSender getSmsStatusSender;

    @Autowired
    public SendersStore(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .build();

        this.getBalanceSender = retrofit.create(GetBalanceSender.class);
        this.sendSmsSender = retrofit.create(SendSmsSender.class);
        this.getSmsStatusSender = retrofit.create(GetSmsStatusSender.class);
    }

    public GetBalanceSender getGetBalanceSender() {
        return this.getBalanceSender;
    }

    public SendSmsSender getSendSmsSender() {
        return this.sendSmsSender;
    }

    public GetSmsStatusSender getGetSmsStatusSender() {
        return this.getSmsStatusSender;
    }
}
