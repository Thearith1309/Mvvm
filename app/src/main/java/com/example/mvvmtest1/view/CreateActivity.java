package com.example.mvvmtest1.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mvvmtest1.R;
import com.example.mvvmtest1.models.NicePlace;

public class CreateActivity extends AppCompatActivity {

    private EditText name, des;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        name = findViewById(R.id.etName);
        des = findViewById(R.id.etDes);
        mFab = findViewById(R.id.fab);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NicePlace item = new NicePlace(name.getText().toString(), des.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("NicePlace", item);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
