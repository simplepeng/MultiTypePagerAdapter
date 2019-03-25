package me.simple.multitype.sample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.simple.multitype.Items;
import me.simple.multitype.MultiTypePagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);

        Items items = new Items();
        MultiTypePagerAdapter adapter = new MultiTypePagerAdapter(items);
        adapter.register(Integer.class, new ImageBinder());
        adapter.register(String.class, new TextBinder());
        viewPager.setAdapter(adapter);


    }
}
