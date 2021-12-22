package com.example.smarthunter.retrofit;

import com.example.smarthunter.model.DataFavorite;
import com.example.smarthunter.model.DataLogin;
import com.example.smarthunter.model.EventAccount;
import com.example.smarthunter.model.EventJenisList;
import com.example.smarthunter.model.MessageLogOut;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface eventClient {

    @FormUrlEncoded
    @POST("login")
    Call<DataLogin> checkLogin(@Field("username") String username, @Field("password") String password);

    @GET("api/seminar/{jenis}")
    Call<EventJenisList> getEventJenis(@Header("token") String token, @Path("jenis") Integer jenis);

    @GET("api/favorite/{id}")
    Call<DataFavorite> getDataFav(@Header("token") String token, @Path("id") Integer id);

    @GET("logout")
    Call<MessageLogOut> getOut(@Header("token") String token);

    @GET("api/myevent/{user_id}/{jenis}")
    Call<EventAccount> getEvent(@Header("token") String token, @Path("user_id") Integer id, @Path("jenis") Integer jenis);
}
