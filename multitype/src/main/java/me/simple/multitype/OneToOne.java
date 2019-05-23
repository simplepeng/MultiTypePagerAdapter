package me.simple.multitype;

import java.util.HashMap;

public class OneToOne<T> implements IType<T> {

    private HashMap<Class<? extends T>, ItemViewBinder<T>> map = new HashMap<>();

    @Override
    public int getType() {
        return IType.TYPE_ONE_TO_ONE;
    }

    @Override
    public IType<T> to(ItemViewBinder<T>... binders) {
        return null;
    }

    @Override
    public void withLinker(Linker<T> linker) {

    }

    @Override
    public ItemViewBinder<T> getItemViewBinder(int position, T item) {
        return map.get(item.getClass());
    }

    @Override
    public void register(Class<? extends T> clazz, ItemViewBinder<T> binder) {
        map.put(clazz, binder);
    }


}
