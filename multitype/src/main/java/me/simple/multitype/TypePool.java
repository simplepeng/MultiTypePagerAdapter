package me.simple.multitype;


class TypePool {

    private IType mType;

    @SuppressWarnings("unchecked")
    <T> void register(Class<? extends T> clazz, ItemViewBinder<T> binder) {
        if (mType == null) {
            mType = new OneToOne<T>();
        }
        mType.register(clazz, binder);
    }

    @SuppressWarnings("unchecked")
    <T> IType<T> register(Class<? extends T> clazz) {
        if (mType == null) {
            mType = new OneToMany<T>(clazz);
        }
        return mType;
    }

    @SuppressWarnings("unchecked")
    ItemViewBinder<?> getItemViewBinder(int position, Object item) {
        if (mType == null) {
            throw new NullPointerException("You have call register method?");
        }
        return mType.getItemViewBinder(position, item);
    }
}
