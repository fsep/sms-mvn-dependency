package com.fsep.services.sms.retrofit;

import com.fsep.services.sms.dao.SmsDao;
import com.fsep.services.sms.models.Sms;
import com.fsep.services.sms.retrofit.senders.GetBalanceSender;
import com.fsep.services.sms.retrofit.senders.GetSmsStatusSender;
import com.fsep.services.sms.retrofit.senders.SendSmsSender;
import com.fsep.services.sms.retrofit.senders.SendersStore;
import com.squareup.okhttp.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit.Call;

import java.io.IOException;
import java.util.Calendar;

/**
 * 15.01.16
 * RetrofitService
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class RetrofitService {

    @Autowired
    private SendersStore sendersStore;

    @Autowired
    private SmsDao smsDao;

    public String invokeGetBalanceSender(String user, String passwordHash) {
        GetBalanceSender sender = sendersStore.getGetBalanceSender();

        Call<ResponseBody> result = sender.getBalance(user, passwordHash);

        String response = getResultAsString(result);

        return extractBalance(response);
    }

    public Sms invokeSendSmsSender(String user, String passwordHash, String to, String text, String from) {
        SendSmsSender sender = sendersStore.getSendSmsSender();

        Call<ResponseBody> result = sender.sendSms(user, passwordHash, to, text, from);

        String response = getResultAsString(result);

        String aeroId = extractSmsAeroId(response);
        String state = extractState(response);

        Sms sms = new Sms(aeroId, Calendar.getInstance().getTime(), to, state, text);
        return smsDao.saveSms(sms);
    }

    public String invokeGetSmsStatusSender(String user, String password, int aeroId) {
        GetSmsStatusSender sender = sendersStore.getGetSmsStatusSender();

        Call<ResponseBody> result = sender.getStatus(user, password, aeroId);

        String response = getResultAsString(result);

        return extractSmsState(response);
    }

    private String getResultAsString(Call<ResponseBody> result) {
        try {
            return result.execute().body().string();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private String extractBalance(String response) {
        String[] stringSplit = response.split("=");
        return stringSplit[1];
    }

    private String extractState(String response) {
        String[] stringSplit = response.split("=");
        return stringSplit[1];
    }

    private String extractSmsAeroId(String response) {
        String[] stringSplit = response.split("=");
        return stringSplit[0];
    }

    private String extractSmsState(String response) {
        String[] stringsSplit = response.split("=");
        return stringsSplit[1];
    }
}
