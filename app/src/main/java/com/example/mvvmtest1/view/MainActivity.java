package com.example.mvvmtest1.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvmtest1.R;
import com.example.mvvmtest1.adapters.AdapterNicePlaces;
import com.example.mvvmtest1.models.NicePlace;
import com.example.mvvmtest1.viewModels.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mMainActivityViewModel;
    private RecyclerView mRecyclerView;
    private TextView mTextView;
    private FloatingActionButton mFab;
    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        mTextView = findViewById(R.id.tvNoData);
        mFab = findViewById(R.id.fab);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlace().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(@Nullable List<NicePlace> nicePlaces) {
                if (nicePlaces.size() > 0) {
                    mRecyclerView.setVisibility(View.VISIBLE);
                    mTextView.setVisibility(View.GONE);
                    adapterNicePlaces.notifyDataSetChanged();

                } else {
                    mRecyclerView.setVisibility(View.GONE);
                    mTextView.setVisibility(View.VISIBLE);

                }

            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

        initRecyclerView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                NicePlace item = (NicePlace) data.getSerializableExtra("NicePlace");
                mMainActivityViewModel.setNicePlace(item);

            }
        }
    }

    AdapterNicePlaces adapterNicePlaces;
    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterNicePlaces = new AdapterNicePlaces(this, mMainActivityViewModel.getNicePlace().getValue());
        mRecyclerView.setAdapter(adapterNicePlaces);

    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
