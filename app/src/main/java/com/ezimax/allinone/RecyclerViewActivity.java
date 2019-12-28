package com.ezimax.allinone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    Integer[] image = {R.drawable.facebook,R.drawable.instagram,
            R.drawable.youtube,R.drawable.twitter,R.drawable.linkedin};
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        getSupportActionBar().hide();

        list.add("FaceBook");
        list.add("Instagram");
        list.add("YouTube");
        list.add("Twitter");
        list.add("Linkedin");
        /*list.add("Mp3Wale");
        list.add("PagalWorld");*/

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(image,this,list,RecyclerViewActivity.this);
        recyclerView.setAdapter(adapter);
    }

    public void changeActivity(int adapterPosition) {
        Intent i;
        switch (adapterPosition){
            case 0:
                i = new Intent(RecyclerViewActivity.this,MainActivity.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(RecyclerViewActivity.this,InstagramActivity.class);
                startActivity(i);
                break;
            case 2:
                 i = new Intent(RecyclerViewActivity.this,YouTubeActivity.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(RecyclerViewActivity.this,TwitterActivity.class);
                startActivity(i);
                break;
            case 4:
                i = new Intent(RecyclerViewActivity.this,LinkedinActivity.class);
                startActivity(i);
                break;
           /* case 5:
                i = new Intent(RecyclerViewActivity.this,Mp3WaleActivity.class);
                startActivity(i);
                break;
            case 6:
                i = new Intent(RecyclerViewActivity.this,PagalworldActivity.class);
                startActivity(i);
                break;*/
        }
    }
}
