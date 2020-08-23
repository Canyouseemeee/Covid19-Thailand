package com.adedom.covid19thailand;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Covid19Api {

    @GET("/api/open/today")
    Single<CovidResponse> fetchCovid19();

}
