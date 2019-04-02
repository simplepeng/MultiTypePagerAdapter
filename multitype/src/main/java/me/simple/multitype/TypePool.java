package me.simple.multitype;

import java.util.HashMap;

public class TypePool {

    private HashMap<Class<?>, ItemViewBinder<?>> typeMap;

    public TypePool() {
        typeMap = new HashMap<>();
    }

    public <T> void register(Class<? extends T> clazz,
                             ItemViewBinder<T> binder) {
        typeMap.put(clazz, binder);
    }

    public <T> OneToMany register(MultiTypePagerAdapter adapter, Class<? extends T> clazz) {
        return new OneToMany<>(adapter, clazz);
    }

    public ItemViewBinder<?> getItemViewBinder(Class<?> clazz) {
        return typeMap.get(clazz);
    }
}
