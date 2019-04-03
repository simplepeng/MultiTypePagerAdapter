package me.simple.multitype;

public class OneToMany<T> {

    private MultiTypePagerAdapter adapter;

    private Class<? extends T> clazz;
    private ItemViewBinder<T>[] binders;

    public OneToMany(MultiTypePagerAdapter adapter, Class<? extends T> clazz) {
        this.adapter = adapter;
        this.clazz = clazz;
    }

    @SafeVarargs
    public final OneToMany<T> to(ItemViewBinder<T>... binders) {
        this.binders = binders;
        return this;
    }

    public void withClassLinker(ClassLinker<T> linker) {
        for (ItemViewBinder<T> binder : binders) {
            adapter.register(clazz, binder, new ClassLinkerWrapper<T>(linker));
        }
    }


}
