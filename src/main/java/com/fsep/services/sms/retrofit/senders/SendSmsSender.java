package com.fsep.services.sms.retrofit.senders;

import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * 15.01.16
 * SendSmsSender
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */
public interface SendSmsSender {

    @POST("/send/")
    Call<ResponseBody> sendSms(@Query("user") String user, @Query("password") String password,
                                  @Query("to") String to, @Query("text") String text, @Query("from") String from);
}
