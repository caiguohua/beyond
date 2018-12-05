package java8;

import java.util.Iterator;

@FunctionalInterface
public interface BasicFunctional<T> {

    @Override
    boolean equals(Object obj);
    int compare(T obj1,T obj2);

}

interface X{
    int m(Iterator<String> arg);
}

interface Y{
    int m(Iterator<String> arg);
}

@FunctionalInterface
interface Z1 extends X,Y{}