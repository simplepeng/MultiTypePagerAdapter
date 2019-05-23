package me.simple.multitype;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MultiTypePagerAdapter extends PagerAdapter {

    private Items items;
    private TypePool typePool = new TypePool();

    public MultiTypePagerAdapter(Items items) {
        this.items = items;
    }

    public MultiTypePagerAdapter() {
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @SuppressWarnings("all")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        Object item = items.get(position);
        ItemViewBinder binder = typePool.getItemViewBinder(position, item);
        if (binder == null) {
            throw new NullPointerException("binder is null");
        }

        View itemView = LayoutInflater.from(container.getContext())
                .inflate(binder.getLayoutId(), container, false);
        binder.convert(itemView, position, item);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    public <T> void register(Class<? extends T> clazz,
                             ItemViewBinder<T> binder) {
        typePool.register(clazz, binder);
    }

    @SuppressWarnings("unchecked")
    public <T> IType<T> register(Class<? extends T> clazz) {
        return typePool.register(clazz);
    }
}
