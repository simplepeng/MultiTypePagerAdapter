package me.simple.multitype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

@SuppressWarnings("unused")
public abstract class ItemViewBinder<T> {

    private Context context;
    private MultiTypePagerAdapter adapter;

    public ItemViewBinder() {
    }

    public ItemViewBinder(Context context) {
        this.context = context;
    }

    protected abstract int getLayoutId();

    protected abstract void convertItem(View view,
                                        int position,
                                        T item);

    protected void destroyItem(View itemView, int position, Object item) {

    }

    protected Context getContext() {
        if (context == null) {
            throw new NullPointerException("You must override the constructor with the Context");
        }
        return context;
    }

    public MultiTypePagerAdapter getAdapter() {
        return adapter;
    }

    void setAdapter(MultiTypePagerAdapter adapter) {
        this.adapter = adapter;
    }
}
