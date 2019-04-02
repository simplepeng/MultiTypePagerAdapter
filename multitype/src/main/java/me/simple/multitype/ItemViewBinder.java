package me.simple.multitype;

import android.content.Context;
import android.view.View;

public abstract class ItemViewBinder<T> {

    private Context context;
    MultiTypePagerAdapter adapter;

    public ItemViewBinder() {
    }

    public ItemViewBinder(Context context) {
        this.context = context;
    }

    protected abstract int getLayoutId();

    protected abstract void convert(View view, int position, T item);

    protected Context getContext() {
        if (context == null){
            throw new NullPointerException("You must override the constructor with the Context");
        }
        return context;
    }

    public MultiTypePagerAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(MultiTypePagerAdapter adapter) {
        this.adapter = adapter;
    }
}
