package me.simple.multitype;

public class ClassLinkerWrapper<T> implements Linker<T> {

    public ClassLinkerWrapper(ClassLinker<T> linker) {

    }

    @Override
    public int index(int position, T t) {
        return 0;
    }
}
