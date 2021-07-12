package com.sugi.sugiarto.REST;

import android.renderscript.Sampler;

import com.sugi.sugiarto.Model.GetUser;
import com.sugi.sugiarto.Model.PostPutDelUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("users")
    Call<GetUser>getUser();
    @FormUrlEncoded
    @POST("users")
    Call<PostPutDelUser>postUser(@Field("first_name") String name1,
                                 @Field("last_name") String name2,
                                 @Field("email") String email);

    @FormUrlEncoded
    @PUT("users")
    Call<PostPutDelUser>putUser(String s, @Field("id") String id,
                                @Field("first_name") String name1,
                                @Field("last_name") String name2,
                                @Field("email") String email);

    @FormUrlEncoded
    @HTTP(method = "DELETE",path = "users",hasBody = true)
    Call<PostPutDelUser>deleteUser(@Field("id") String id);

    Call<PostPutDelUser> putUser(String toString, String toString1, String toString2, String toString3);
}

