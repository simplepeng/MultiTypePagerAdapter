package me.simple.multitype.sample;

import android.view.View;

import me.simple.multitype.ItemViewBinder;

public class TextBinder extends ItemViewBinder<String> {

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void convert(View view, int position, String item) {

    }
}
