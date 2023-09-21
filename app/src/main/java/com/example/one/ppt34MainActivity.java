package com.example.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ppt34MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppt34_main);

        adapter = new CustomAdapter();
        listView = (ListView) findViewById(R.id.listView);

        setData();

        listView.setAdapter(adapter);

        //여기서부터스크롤압박주의 약 17개임 원룸정보관한것들

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int imgRes = ((CustomDTO) adapter.getItem(position)).getResId();
                String titleRes= ((CustomDTO) adapter.getItem(position)).getTitle();
                String contentRes= ((CustomDTO) adapter.getItem(position)).getContent();

                Intent intent = new Intent(ppt34MainActivity.this, House.class);

                intent.putExtra("imgRes", imgRes);
                intent.putExtra("titleRes", titleRes);
                intent.putExtra("contentRes", contentRes);



                startActivity(intent);

            }




        });


    }

    private void setData() {

        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
        String[] titles = getResources().getStringArray(R.array.title);
        String[] contents = getResources().getStringArray(R.array.content);

        for (int i = 0; i < arrResId.length(); i++) {
            CustomDTO dto = new CustomDTO();
            dto.setResId(arrResId.getResourceId(i, 0));
            dto.setTitle(titles[i]);
            dto.setContent(contents[i]);

            adapter.addItem(dto);
        }

    }
}
