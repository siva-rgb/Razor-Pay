package com.example.razorpayintegration;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterFace {

   String BASE_URL="https://api.razorpay.com/v1/";

   @GET("payments")
    Call<List<PaymentDetails>>getPaymenDetails(

   );
}
