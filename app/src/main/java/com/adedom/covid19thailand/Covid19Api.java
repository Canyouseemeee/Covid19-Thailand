package com.adedom.covid19thailand;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Covid19Api {

    @GET("/api/open/today")
    Call<CovidResponse> fetchCovid19();

}
