package me.simple.multitype;

import java.util.ArrayList;
import java.util.List;

public class TypePool {

    //    private HashMap<Class<?>, ItemViewBinder<?>> typeMap;
    private List<Class<?>> classList;
    private List<ItemViewBinder<?>> binderList;
    private List<Linker<?>> linkerList;

    public TypePool() {
//        typeMap = new HashMap<>();
        classList = new ArrayList<>();
        binderList = new ArrayList<>();
        linkerList = new ArrayList<>();
    }

//    public <T> void register(Class<? extends T> clazz,
//                             ItemViewBinder<T> binder) {
////        typeMap.put(clazz, binder);
//        classList.add(clazz);
//        binderList.add(binder);
//    }

    public <T> OneToMany register(MultiTypePagerAdapter adapter, Class<? extends T> clazz) {
        return new OneToMany<>(adapter, clazz);
    }

    public ItemViewBinder<?> getItemViewBinder(int position, Class<?> clazz) {
//        return typeMap.get(clazz);
        ItemViewBinder<?> binder = binderList.get(position);
        return binder;
    }

    public <T> void register(Class<? extends T> clazz, ItemViewBinder<T> binder, Linker<T> linker) {
        classList.add(clazz);
        binderList.add(binder);
        linkerList.add(linker);
    }
}
