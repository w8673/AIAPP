package com.seoul.myai;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    ArrayList<DataItem> list = new ArrayList<>();

    RecyclerView recyclerView;

    EditText editText;

    Button addButton;

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

        editText = findViewById(R.id.editview);
        addButton = findViewById(R.id.add_button);


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


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                Log.d("TEST","name " + name);
                Log.d("TEST","2 " + list.size() % 3);

                DataItem item = new DataItem();
                switch (list.size() % 3){
                    case 0:
                        item.setSrc(R.drawable.a);
                        break;
                    case 1:
                        item.setSrc(R.drawable.b);
                        break;
                    case 2:
                        item.setSrc(R.drawable.c);
                        break;
                }

                item.setName(name);
                list.add(item);
                geminiAdapter.setList(list);

            }
        });






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