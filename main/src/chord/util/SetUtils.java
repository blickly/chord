/*
 * Copyright (c) 2006-07, The Trustees of Stanford University.  All
 * rights reserved.
 * Licensed under the terms of the GNU GPL; see COPYING for details.
 */
package chord.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Set related utilities.
 * 
 * @author Mayur Naik (mhn@cs.stanford.edu)
 */
public class SetUtils {
	public static final int DEFAULT_INIT_SIZE = 10;
	public static final int THRESHOLD = 10;
	public static <E> Set<E> newSet() {
		return newSet(DEFAULT_INIT_SIZE);
	}
	public static <E> Set<E> newSet(int initSize) {
		Set<E> set;
		if (initSize < THRESHOLD) {
			set = new ArraySet<E>(initSize);
		} else {
			set = new HashSet<E>(initSize);
		}
		return set;
	}
	public static <E> Set<E> newSet(Set<E> c) {
		Set<E> set = newSet(c.size());
		set.addAll(c);
		return set;
	}
    public static <E> Set<E> iterableToSet(Iterable<E> c, int size) {
		Set<E> set = newSet(size);
        for (E e : c)
            set.add(e);
        return set;
    }
}
