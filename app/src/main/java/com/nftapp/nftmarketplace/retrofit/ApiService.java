package com.nftapp.nftmarketplace.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nftapp.nftmarketplace.model.Item;
import com.nftapp.nftmarketplace.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyy").create();
    ApiService apiService = new Retrofit.Builder()
//                .baseUrl("http://localhost:3000/openeye/")
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
//    @GET("user/all")
//    Call<List<User>> getAllUser();

//    @GET("user/{username}")
//
//    @PUT("user/update/{username}")
//
//    @PUT("user/changePassword/{username}")
//
//    @PUT("user/balance/deduct/{username}")
//
//    @PUT("user/updateProfileImage/{username}")

//    @POST("/user.save")
//    Call<User> save(@Body User user);
    @GET("posts")
    Call<List<Item>> getListItem(@Query("userId") int userId);
}
