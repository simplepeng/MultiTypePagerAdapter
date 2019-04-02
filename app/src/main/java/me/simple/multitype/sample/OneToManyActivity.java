package me.simple.multitype.sample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import me.simple.multitype.ClassLinker;
import me.simple.multitype.ItemViewBinder;
import me.simple.multitype.Items;
import me.simple.multitype.MultiTypePagerAdapter;

public class OneToManyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);

        ViewPager viewPager = findViewById(R.id.viewPager);

        Items items = new Items();
        MultiTypePagerAdapter adapter = new MultiTypePagerAdapter(items);
        adapter.register(String.class)
                .to(
                        new TextBinder(),
                        new Text2Binder()
                )
                .withClassLinker(new ClassLinker<String>() {
                    @Override
                    public Class<? extends ItemViewBinder<String>> index(int position, String s) {
                        return TextUtils.equals(s, "Text2Binder")
                                ? Text2Binder.class
                                : TextBinder.class;
                    }
                });

        items.add("TextBinder");
        items.add("Text2Binder");
        items.add("TextBinder");
        items.add("Text2Binder");
        items.add("TextBinder");

        viewPager.setAdapter(adapter);
    }
}
