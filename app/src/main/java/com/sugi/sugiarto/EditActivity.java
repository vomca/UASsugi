package com.sugi.sugiarto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class EditActivity extends AppCompatActivity {

    EditText edtId, edtNama1, edtNama2,edtEmail;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNama1 = (EditText) findViewById(R.id.edtNama1);
        edtNama2 = (EditText) findViewById(R.id.edtNama2);
        edtNama2 = (EditText) findViewById(R.id.edtNama2);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama1.setText(mIntent.getStringExtra("First Name"));
        edtNama2.setText(mIntent.getStringExtra("Last Name"));
        edtEmail.setText(mIntent.getStringExtra("Email"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelUser> updateUserCall = mApiInterface.putUser(
                        edtId.getText().toString(),
                        edtNama1.getText().toString(),
                        edtEmail.getText().toString(),
                        edtNama2.getText().toString());

                updateUserCall.enqueue(new Callback<PostPutDelUser>() {
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
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelUser> deleteUser = mApiInterface.deleteUser(edtId.getText().toString());
                    deleteUser.enqueue(new Callback<PostPutDelUser>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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