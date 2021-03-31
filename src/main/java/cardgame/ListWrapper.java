package cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class ListWrapper<Type> implements List<Type> {
    private ArrayList<Type> internalList;

    public ListWrapper() {
        internalList = new ArrayList<Type>();
    }

    public Type get(int i) {
        return internalList.get(i);
    }

    @Override
    public Iterator<Type> iterator() {
        return internalList.iterator();
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return internalList.contains(o);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return internalList.toArray(a);
    }

    @Override
    public boolean add(Type e) {
        return internalList.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return internalList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return internalList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Type> c) {
        return internalList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return internalList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return internalList.retainAll(c);
    }

    @Override
    public void clear() {
        internalList.clear();
    }

    @Override
    public Object[] toArray() {
        return internalList.toArray();
    }

    @Override
    public boolean addAll(int index, Collection<? extends Type> c) {
        return internalList.addAll(index, c);
    }

    @Override
    public Type set(int index, Type element) {
        return internalList.set(index, element);
    }

    @Override
    public void add(int index, Type element) {
        internalList.add(index, element);
    }

    @Override
    public Type remove(int index) {
        return internalList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return internalList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return internalList.lastIndexOf(o);
    }

    @Override
    public ListIterator<Type> listIterator() {
        return internalList.listIterator();
    }

    @Override
    public ListIterator<Type> listIterator(int index) {
        return internalList.listIterator(index);
    }

    @Override
    public List<Type> subList(int fromIndex, int toIndex) {
        return internalList.subList(fromIndex, toIndex);
    }

    @Override
    public String toString(){
        return internalList.toString();
    }

}
