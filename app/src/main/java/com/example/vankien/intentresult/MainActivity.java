package com.example.vankien.intentresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProvince;

    ArrayAdapter<String>adapter;
    String data[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvProvince.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item = data[position];
                ArrayList<String> item = new ArrayList<>();
                for(int i = 0;i<=position;i++){
                    item.add(data[i]);
                }
                Intent intent = new Intent(MainActivity.this,ProvinceActivity.class);
                Bundle bundle = new Bundle();
                //bundle.putString("province",item);
                bundle.putStringArrayList("province",item);
                intent.putExtra("DataSend",bundle);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        lvProvince = findViewById(R.id.lvProvince);

        data = getResources().getStringArray(R.array.provice);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        lvProvince.setAdapter(adapter);
    }
}
