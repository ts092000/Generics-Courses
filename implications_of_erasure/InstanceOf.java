package com.bkitsolution.implications_of_erasure;

public class InstanceOf<T> {
    public boolean equals(Object o) {
        if (o instanceof InstanceOf/*<T>*/) {
            return true;
        }
        return false;
    }
}
