package me.simple.multitype;

public interface Linker<T> {
    Class<? extends ItemViewBinder<T>> index(int position, T t);
}
