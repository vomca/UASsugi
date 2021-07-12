package com.sugi.sugiarto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sugi.sugiarto.Model.PostPutDelUser;
import com.sugi.sugiarto.REST.ApiClient;
import com.sugi.sugiarto.REST.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText edtNama1, edtNama2,edtEmail;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        edtNama1 = (EditText) findViewById(R.id.edtNama1);
        edtNama2 = (EditText) findViewById(R.id.edtNama2);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelUser> postUserCall = mApiInterface.postUser(edtNama1.getText().toString(), edtNama2.getText().toString(), edtEmail.getText().toString());
                postUserCall.enqueue(new Callback<PostPutDelUser>() {
                    @Override
                    public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}