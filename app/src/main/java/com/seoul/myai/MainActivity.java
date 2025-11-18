package com.seoul.myai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        recyclerView = findViewById(R.id.list);


        ArrayList<DataItem> list = new ArrayList<>();
        DataItem item1 = new DataItem();
        item1.setSrc(R.drawable.a);
        item1.setName("연예인 1");
        list.add(item1);

        DataItem item2 = new DataItem();
        item2.setSrc(R.drawable.b);
        item2.setName("연예인 2");
        list.add(item2);

        DataItem item3 = new DataItem();
        item3.setSrc(R.drawable.c);
        item3.setName("연예인 3");
        list.add(item3);


        GeminiAdapter geminiAdapter = new GeminiAdapter();
        recyclerView.setAdapter(
                geminiAdapter
        );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        geminiAdapter.setList(list);


        /*for(int i = 0; i < 100; i++) {
            list.add("" + i);
        }

        geminiAdapter.setList(list);*/

    }









}