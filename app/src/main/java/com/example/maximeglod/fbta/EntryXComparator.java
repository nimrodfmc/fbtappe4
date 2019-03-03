package com.example.maximeglod.fbta;

import com.github.mikephil.charting.data.Entry;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Comparator for comparing Entry-objects by their x-value.
 */
public class EntryXComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry entry1, Entry entry2) {
        float diff = entry1.getX() - entry2.getX();

        if (diff == 0f) return 0;
        else {
            if (diff > 0f) return 1;
            else return -1;
        }
    }

    @Override
    public Comparator<Entry> reversed() {
        return null;
    }

    @Override
    public Comparator<Entry> thenComparing(Comparator<? super Entry> other) {
        return null;
    }

    @Override
    public <U> Comparator<Entry> thenComparing(Function<? super Entry, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Entry> thenComparing(Function<? super Entry, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Entry> thenComparingInt(ToIntFunction<? super Entry> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Entry> thenComparingLong(ToLongFunction<? super Entry> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Entry> thenComparingDouble(ToDoubleFunction<? super Entry> keyExtractor) {
        return null;
    }
}