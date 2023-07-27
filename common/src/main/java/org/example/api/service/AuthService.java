package org.example.api.service;

import lombok.extern.log4j.Log4j2;
import org.example.model.Token;
import org.example.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;

import java.io.IOException;

@Log4j2
public class AuthService implements Callback<Token> {

    public static final String BASE_URL = PropertiesService.getBaseURL();

    public void getToken(User user) throws IOException {
        var retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        var apiService = retrofit.create(APIService.class);

        var response = apiService.getAuthTokenByLoginAndPassword(user.getLogin(), user.getPassword()).execute();
        assert response.body() != null;

        user.setAuthToken(response.body());
    }

    @Override
    @EverythingIsNonNull
    public void onResponse(Call<Token> call, Response<Token> response) {
        if (response.isSuccessful()) {
            var token = response.body();
            log.info("Recived data: {}", token);
        } else {
            log.error("Recived error data: {}", response.errorBody());
        }
    }

    @Override
    @EverythingIsNonNull
    public void onFailure(Call<Token> call, Throwable t) {
        t.printStackTrace();
    }
}
