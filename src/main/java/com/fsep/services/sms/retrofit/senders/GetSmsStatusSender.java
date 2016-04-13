package com.fsep.services.sms.retrofit.senders;

import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * 16.01.16
 * GetSmsStatusSender
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */
public interface GetSmsStatusSender {

    @GET("/status")
    Call<ResponseBody> getStatus(@Query("user") String user, @Query("password") String password,
                                 @Query("id") int id);

}
