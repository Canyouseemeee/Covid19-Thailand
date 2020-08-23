package com.adedom.covid19thailand;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Gold {

    @GET("/latest?fbclid=IwAR1bDxDXyYOJ-zASRbq_OCf2X4SXG4DfrBeW-67L3fWs6kAsT-YcQEkCkYc")
    Single<GoldResponse> fetchGold();
}
