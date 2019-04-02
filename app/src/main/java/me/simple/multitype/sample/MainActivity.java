package me.simple.multitype.sample;

import android.content.Intent;
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


    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_oneToOne:
                intent.setClass(MainActivity.this, OneToOneActivity.class);
                break;
            case R.id.btn_oneToMany:
                intent.setClass(MainActivity.this, OneToManyActivity.class);
                break;
        }
        startActivity(intent);
    }
}
