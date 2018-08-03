package com.developer.dinhduy.swipelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QAadapter aadapter;
    private List<QA> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.id_rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list.add(new QA("The SELECT statement is used to select data from a database"));
        list.add(new QA("The data returned is stored in a result table"));
        list.add(new QA("Below is a selection from the \"Customers\" table"));
        list.add(new QA("The following SQL statement selects the \"CustomerName\" and \"City\""));
        list.add(new QA("The following SQL statement selects all the columns"));
        aadapter=new QAadapter(list,this);
        recyclerView.setAdapter(aadapter);


    }
}
