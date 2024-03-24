package com.martin.calcite.sql.parser.expression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nonnull;

/**
 * ExpressionList <br>
 *
 * @author Martin
 * @date 2024/3/17
 * @since 1.8
 */
public class ExpressionList implements List<Expression<?>>, Expression<Void> {

    private final List<Expression<?>> list;

    public ExpressionList() {
        this.list = new ArrayList<>();
    }

    public ExpressionList(int initialCapacity) {
        this.list = new ArrayList<>(initialCapacity);
    }

    public ExpressionList(List<Expression<?>> list) {
        this.list = list;
    }

    public ExpressionList(Collection<Expression<?>> collection) {
        this(new ArrayList<>(collection));
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<Expression<?>> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @SuppressWarnings("SuspiciousToArrayCall")
    @Override
    public <T> T[] toArray(@Nonnull T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(Expression<?> expression) {
        return list.add(expression);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(@Nonnull Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(@Nonnull Collection<? extends Expression<?>> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, @Nonnull Collection<? extends Expression<?>> c) {
        return list.addAll(index, c);
    }

    @Override
    public boolean removeAll(@Nonnull Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(@Nonnull Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Expression<?> get(int index) {
        return list.get(index);
    }

    @Override
    public Expression<?> set(int index, Expression<?> element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, Expression<?> element) {
        list.add(index, element);
    }

    @Override
    public Expression<?> remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<Expression<?>> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<Expression<?>> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<Expression<?>> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
}
