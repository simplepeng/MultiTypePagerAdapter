package me.simple.multitype.sample;

import android.view.View;

import me.simple.multitype.ItemViewBinder;

public class ImageBinder extends ItemViewBinder<Integer> {

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void convert(View view, int position, Integer item) {

    }
}
