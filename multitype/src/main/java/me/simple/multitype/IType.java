package me.simple.multitype;

public interface IType<T> {

    int TYPE_ONE_TO_ONE = 1;
    int TYPE_ONE_TO_MANY = 2;

    int getType();

    IType<T> to(ItemViewBinder<T>... binders);

    void withLinker(Linker<T> linker);

    ItemViewBinder<T> getItemViewBinder(int position, T item);

    void register(Class<? extends T> clazz, ItemViewBinder<T> binder);
}
