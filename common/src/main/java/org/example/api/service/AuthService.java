package org.example.api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.api.model.Token;
import org.example.api.model.User;
import org.example.util.PropertiesLoader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;

import java.io.IOException;

public class NetService implements Callback<Token> {

    public static final String BASE_URL = new PropertiesLoader().getBaseURL();
    private static final Logger logger = LogManager.getLogger();

    public void getToken(User user) throws IOException {
        var retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        var apiService = retrofit.create(APIService.class);

        var response = apiService.getAuthTokenByLoginAndPassword(user.getLogin(), user.getPassword()).execute();
        assert response.body() != null;

        user.setAuthToken(response.body().getToken());
    }

    @Override
    @EverythingIsNonNull
    public void onResponse(Call<Token> call, Response<Token> response) {
        if (response.isSuccessful()) {
            var token = response.body();
            logger.info("Recived data: {}", token);
        } else {
            logger.error("Recived error data: {}", response.errorBody());
        }
    }

    @Override
    @EverythingIsNonNull
    public void onFailure(Call<Token> call, Throwable t) {
        t.printStackTrace();
    }
}
