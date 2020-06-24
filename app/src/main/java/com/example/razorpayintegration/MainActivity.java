package com.example.razorpayintegration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.squareup.picasso.Picasso;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    Button pay;

    EditText amount;
    ListView listView;
    private String TAG="main";

    final String API_SECRET="mbWvR6ReJObB0WRBVPI5GY5b";
    final String API_ID="rzp_test_kNQNdLAtufV1cc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pay=findViewById(R.id.pay);
        amount=findViewById(R.id.amount);
        listView=findViewById(R.id.listView);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(ApiInterFace.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterFace apiInterFace=retrofit.create(ApiInterFace.class);

        Call<List<PaymentDetails>> call=apiInterFace.getPaymenDetails();

        call.enqueue(new Callback<List<PaymentDetails>>() {
            @Override
            public void onResponse(Call<List<PaymentDetails>> call, Response<List<PaymentDetails>> response) {

                List<PaymentDetails> details=response.body();

                String [] id=new String[details.size()];

                for (int i=0;i<details.size();i++)
                {
                    id[i]=  details.get(i).getId();
                }

                listView.setAdapter(new ArrayAdapter<String >(
                        getApplicationContext(),android.R.layout.simple_list_item_1,id
                ));

                for (PaymentDetails d: details)
                {

                    Log.d("id",d.getId());
                    Log.d("entity",d.getEntity());
                    Log.d("amount",d.getAmount());
                    Log.d("currency",d.getCurrency());
                    Log.d("status",d.getStatus());
                }
            }

            @Override
            public void onFailure(Call<List<PaymentDetails>> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amount.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter amount", Toast.LENGTH_SHORT).show();
                }
                
                else 
                {
                    startPayment();
                }
            }
        });





    }

    private void startPayment() {

        Checkout co=new Checkout();
        try {

            JSONObject option=new JSONObject();
            option.put("name","Ultracures");
            option.put("description","App Payment");
            option.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            option.put("order_id", "order_9A33XWu170gUtm");
            option.put("currency", "INR");

            String str_amount=amount.getText().toString();

            double total= Double.parseDouble(str_amount);
            total=total*100;
            option.put("amount",total);

            JSONObject prefill=new JSONObject();

            prefill.put("email","xyz123@gmail.com");
            prefill.put("contact","9438392890");
            option.put("prefill",prefill);

            co.open(this,option);



        }
        catch (Exception e)
        {
            Log.e("error","error: "+e.toString());
            e.printStackTrace();
        }

    }

    @Override
    public void onPaymentSuccess(String s) {

        Log.e(TAG, " payment successfull "+ s.toString());
        Toast.makeText(this, "Payment successfully done! " +s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {

        Log.e(TAG,  "error code "+String.valueOf(i)+" -- Payment failed "+s.toString()  );
        try {
            Toast.makeText(this, "Payment error please try again", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("OnPaymentError", "Exception in onPaymentError", e);
        }
    }


}
