package com.vinh.tokudastory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lvStory;
    public StoryModel storyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvStory = (ListView) findViewById(R.id.lv_story);
        final StoryAdapter storyAdapter = new StoryAdapter(MainActivity.this, R.layout.item_list_story, DatabaseHandle.getInstance(this).getListStory());

        lvStory.setAdapter(storyAdapter);

        lvStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public static final String TAG = "MainActivity";

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, StoryDescription.class);
                startActivity(intent);
            }
        });





    }
}
