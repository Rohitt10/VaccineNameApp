package com.example.vaccinenameapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    RecyclerView recyclerView;
    Vaccine[] vaccines;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        vaccines = new Vaccine[]{
                new Vaccine("Hepatitis B Vaccine", R.drawable.vaccine1),
                new Vaccine("Tetanus Vaccine", R.drawable.vaccine4),
                new Vaccine("Pneumococcal Vaccine", R.drawable.vaccine5),
                new Vaccine("Rotavirus Vaccine", R.drawable.vaccine6),
                new Vaccine("Measles Virus", R.drawable.vaccine7),
                new Vaccine("Cholera  Virus", R.drawable.vaccine8),
                new Vaccine("Covid-19 Virus", R.drawable.vaccine9)

        };

        myAdapter=new MyAdapter(vaccines);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        myAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View View, int pos) {
        Toast.makeText(this,
                "Vaccine name: "+vaccines[pos].getName() , Toast.LENGTH_SHORT).show();
    }
}