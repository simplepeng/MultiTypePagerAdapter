package me.simple.multitype;

public class OneToMany<T> {

    private Class<? extends T> clazz;
    private ItemViewBinder<T>[] binders;

    public OneToMany(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    public void to(ItemViewBinder<T>... binders) {
        this.binders = binders;
    }


}
