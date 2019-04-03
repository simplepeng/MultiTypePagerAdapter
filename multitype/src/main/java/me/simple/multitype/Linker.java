package me.simple.multitype;

import android.support.annotation.IntRange;

public interface Linker<T> {

    @IntRange(from = 0)
    int index(int position, T t);
}
