package org.example.api.service;

import org.example.model.Token;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("/auth")
    Call<Token> getAuthTokenByLoginAndPassword(
            @Query("login") String login,
            @Query("password") String password);
}
