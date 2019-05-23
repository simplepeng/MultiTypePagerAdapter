package me.simple.multitype;


public class TypePool {

    private IType mType;

    public <T> void register(Class<? extends T> clazz, ItemViewBinder<T> binder) {
        mType = new OneToOne();
    }

    @SuppressWarnings("unchecked")
    public <T> IType<T> register(Class<? extends T> clazz) {
        mType = new OneToMany<>(clazz);
        return mType;
    }

    @SuppressWarnings("unchecked")
    public ItemViewBinder<?> getItemViewBinder(int position, Object item) {
        if (mType == null) {
            throw new NullPointerException("You have call register method");
        }
        return mType.getItemViewBinder(position, item);
    }
}
