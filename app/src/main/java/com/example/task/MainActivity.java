package com.example.task;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<ModelClass> allUserList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        RetrofitUrl.getInstance().apiInterface.getData().enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
               allUserList=response.body();
//                for (int i=0;i<allUserList.size();i++){
//                    Log.e("api","Succes: "+allUserList.get(i).name);
//                }
                recyclerView.setAdapter(new UserAdapter(MainActivity.this,allUserList));

            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Log.e("api","onFailure: "+t.getLocalizedMessage());
            }
        });



    }
}