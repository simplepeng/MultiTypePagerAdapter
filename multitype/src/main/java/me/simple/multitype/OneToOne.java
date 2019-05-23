package me.simple.multitype;

public class OneToOne<T> implements IType<T> {

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
        return null;
    }
}
