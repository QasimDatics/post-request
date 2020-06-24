package com.example.postintegration;

import android.telecom.Call;

import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")
    retrofit2.Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );
    @GET("posts")
    retrofit2.Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    @GET("posts/{id}/comments")
    retrofit2.Call<List<Comment>> getComments(@Path("id") int postId);

    @GET
    retrofit2.Call<List<Comment>> getComments(@Url String url);

    @POST("posts")
    retrofit2.Call<Post> createPost(@Body Post post);

    @PUT("posts/{id}")
    retrofit2.Call<Post> putPost(@Path("id")int id, @Body Post post);

    @PATCH("posts/{id}")
    retrofit2.Call<Post> patchPost(@Path("id")int id, @Body Post post);

    @DELETE("posts/{id}")
    retrofit2.Call<Void> deletePost(@Path("id") int id);

  /*  @FormUrlEncoded
    @POST("posts")
    retrofit2.Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );
    @FormUrlEncoded
    @POST("posts")
    retrofit2.Call<Post> createPost(@FieldMap Map<String, String> fields);*/
}
