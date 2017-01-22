package com.fishbowl.taipeiparkspot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaipeiParkSpotActivity extends AppCompatActivity {

    private static final String TAG = TaipeiParkSpotActivity.class.getSimpleName();
    private ParkSpotAdapter parkSpotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taipei_park_spot_activity);

        parkSpotAdapter = new ParkSpotAdapter(this);

        ListView lvParkSpots = (ListView) findViewById(R.id.lv_parkspots);
        lvParkSpots.setAdapter(parkSpotAdapter);

        fireApi();

    }

    private void refreshData(ParkSpotResultDTO dto) {
        parkSpotAdapter.setData(dto.result.results);
    }

    private void fireApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://data.taipei/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ParkSpotsApi repo = retrofit.create(ParkSpotsApi.class);

        Call<ParkSpotResultDTO> call = repo.contributorsBySimpleGetCall();

        call.enqueue(new Callback<ParkSpotResultDTO>() {
            @Override
            public void onResponse(Call<ParkSpotResultDTO> call, Response<ParkSpotResultDTO> response) {
                Log.d(TAG, "onResponse");
                refreshData(response.body());
            }

            @Override
            public void onFailure(Call<ParkSpotResultDTO> call, Throwable t) {
                Log.e(TAG, "Failed!!");
            }
        });
    }
}
