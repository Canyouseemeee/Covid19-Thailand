package com.adedom.covid19thailand;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid19.th-stat.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Covid19Api api = retrofit.create(Covid19Api.class);

        api.fetchCovid19().enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
                String confirm = response.body().getConfirmed() + "";
                Toast.makeText(getBaseContext(), confirm, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<CovidResponse> call, Throwable t) {
            }
        });

    }
}