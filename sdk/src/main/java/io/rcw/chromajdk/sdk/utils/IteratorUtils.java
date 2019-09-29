package io.rcw.chromajdk.sdk.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class IteratorUtils {
    public static class CyclingIterator<E> implements Iterator<E> {
        private List<E> parent;
        private int index = 0;

        public CyclingIterator(Collection<E> collection) {
            this.parent = new ArrayList<E>(collection);
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public E next() {
            if (index > parent.size() - 1) {
                index = 0;
            }
            return parent.get(index++);
        }
    }


    public static <E> Iterator<E> cycle(Collection<E> collection) {
        return new CyclingIterator<>(collection);
    }

}
