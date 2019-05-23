package me.simple.multitype;

public class OneToMany<T> implements IType<T> {

    private Class<? extends T> mClazz;
    private ItemViewBinder<T>[] mBinders;
    private Linker<T> mLinker;

    public OneToMany(Class<? extends T> clazz) {
        this.mClazz = clazz;
    }

    @SafeVarargs
    @Override
    public final OneToMany<T> to(ItemViewBinder<T>... binders) {
        this.mBinders = binders;
        return this;
    }

    @Override
    public void withLinker(Linker<T> linker) {
        this.mLinker = linker;
    }


    @Override
    public int getType() {
        return IType.TYPE_ONE_TO_MANY;
    }

    @Override
    public ItemViewBinder<T> getItemViewBinder(int position, T item) {
        Class<? extends ItemViewBinder<T>> binderClazz = mLinker.index(position, item);
        for (ItemViewBinder<T> binder : mBinders) {
            if (binder.getClass().isAssignableFrom(binderClazz)) {
                return binder;
            }
        }
        return null;
    }

    @Override
    public void register(Class<? extends T> clazz, ItemViewBinder<T> binder) {

    }
}
