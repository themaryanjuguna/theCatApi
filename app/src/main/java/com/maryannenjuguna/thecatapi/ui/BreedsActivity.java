package com.maryannenjuguna.thecatapi.ui;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.maryannenjuguna.thecatapi.R;
import com.maryannenjuguna.thecatapi.models.TheCatBreedSearchResponse;
import com.maryannenjuguna.thecatapi.network.theCatApi;
import com.maryannenjuguna.thecatapi.network.theCatApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BreedsActivity extends AppCompatActivity {

    List<TheCatBreedSearchResponse> kittyDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);


        theCatApi feral = theCatApiClient.getClient();

        Call<List<TheCatBreedSearchResponse>> catFamily = feral.getBreeds();
        catFamily.enqueue(new Callback<List<TheCatBreedSearchResponse>>() {
            @Override
            public void onResponse(Call<List<TheCatBreedSearchResponse>> call, Response<List<TheCatBreedSearchResponse>> response) {

                if (response.isSuccessful()) {
                    kittyDetails = response.body();


                    ImageView imageView = findViewById(R.id.kittyImageView);
                    TextView kittyId = findViewById(R.id.kittyId);
                    TextView kittyName = findViewById(R.id.kittyName);
                    TextView kittyDescription = findViewById(R.id.description);
                    TextView kittyWikipedia = findViewById(R.id.wikipedia);
                    Button myLikeBtn = findViewById(R.id.likeKittyBtn);


                    Bundle bundle = getIntent().getExtras();


                    String id = bundle.getString("id");
                    String mDescription = bundle.getString("description");
                    String mName = bundle.getString("name");
                    String mWikipedia = bundle.getString("wikipedia");
                    String mImageView = bundle.getString("image");


                    Picasso.get().load(mImageView).into(imageView);
                    kittyId.setText(id);
                    kittyName.setText(mName.toUpperCase());
                    kittyDescription.setText(mDescription);
                    kittyWikipedia.setText(mWikipedia);

                }
            }

            @Override
            public void onFailure(Call<List<TheCatBreedSearchResponse>> call, Throwable t) {


            }


        });
    }
}