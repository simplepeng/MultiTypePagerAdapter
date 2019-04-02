package me.simple.multitype;

public interface ClassLinker<T> {
    Class<? extends ItemViewBinder<T>> index(int position, T t);
}
