package me.simple.multitype.sample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import me.simple.multitype.Items;
import me.simple.multitype.MultiTypePagerAdapter;

public class OneToOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);

        ViewPager viewPager = findViewById(R.id.viewPager);

        Items items = new Items();
        MultiTypePagerAdapter adapter = new MultiTypePagerAdapter(items);
        adapter.register(Integer.class, new ImageBinder());
        adapter.register(String.class, new TextBinder());

        items.add(1);
        items.add("Java");
        items.add(1);
        items.add("Python");
        items.add(1);
        items.add("C++");
        items.add(1);
        items.add("Go");
        items.add(1);
        items.add("Rust");

        viewPager.setAdapter(adapter);
    }

}
