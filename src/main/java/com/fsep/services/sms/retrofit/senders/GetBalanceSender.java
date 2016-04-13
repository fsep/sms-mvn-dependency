package com.fsep.services.sms.retrofit.senders;

import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * 15.01.16
 * GetBalanceSender
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */
public interface GetBalanceSender {

    @GET("/balance")
    Call<ResponseBody> getBalance(@Query("user") String user, @Query("password") String password);
}
