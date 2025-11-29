package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class WorkintechList<T extends Comparable<T>> extends ArrayList<T> {

    @Override
    public boolean add(T element) {
        if (this.contains(element)) {
            return false;
        }
        return super.add(element);
    }

    public void sort() {
        Collections.sort(this);
    }


    @Override
    public boolean remove(Object o) {

        boolean isRemoved = super.remove(o);


        if (isRemoved) {
            this.sort();
        }

        return isRemoved;
    }
}