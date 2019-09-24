package me.simple.multitype.sample;

import android.view.View;

import me.simple.multitype.ItemViewBinder;

public class ImageBinder extends ItemViewBinder<Integer> {

    @Override
    protected int getLayoutId() {
        return R.layout.item_image;
    }

    @Override
    protected void convertItem(View view, int position, Integer item) {

    }

}
