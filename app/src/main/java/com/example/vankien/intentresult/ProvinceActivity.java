package com.example.vankien.intentresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ProvinceActivity extends AppCompatActivity {
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);
        addControls();
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("DataSend");
//        String item = bundle.getString("province");
//        txtResult.setText(item);
        ArrayList<String> items = bundle.getStringArrayList("province");
        String text = items.get(0);
        for(int i =1;i<items.size();i++){
            text += " - "+items.get(i);
        }
        txtResult.setText(text);
    }

    private void addControls() {
        txtResult = findViewById(R.id.txtResult);
    }
}
