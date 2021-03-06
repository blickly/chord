/*
 * Copyright (c) 2006-07, The Trustees of Stanford University.  All
 * rights reserved.
 * Licensed under the terms of the GNU GPL; see COPYING for details.
 */
package chord.util.bddbddb;

import java.io.PrintStream;
import java.io.PrintWriter;

import chord.util.Assertions;
import chord.util.FileUtils;
import chord.util.IndexMap;

/**
 * Generic implementation of a BDD-based domain.
 * <p>
 * Typical usage is as follows:
 * <ul>
 * <li>The domain is initialized by calling {@link #setName(String)}
 * which sets the name of the domain.
 * <li>The domain is next built in memory by repeatedly calling
 * {@link #set(Object)} with the argument in each call being a value
 * to be added to the domain.  If the value already exists in the
 * domain then the call does not have any effect.  Otherwise, the
 * value is mapped to integer K in the domain where K is the number
 * of values already in the domain.</li>
 * <li>The domain built in memory is reflected onto disk by calling
 * {@link #save()}.</li>
 * <li>The domain on disk can be read by a Datalog program.</li>
 * <li>The domain in memory can be read by calling any of the
 * following:
 * <ul>
 * <li>{@link #iterator()}, which provides an iterator over the
 * values in the domain in memory in the order in which they were
 * added,</li>
 * <li>{@link #get(int)}, which provides the value mapped to the
 * specified integer in the domain in memory, and</li>
 * <li>{@link #get(Object)}, which provides the integer mapped to
 * the specified value in the domain in memory.</li>
 * </ul>
 * </li>
 * </ul>
 *
 * @param	<T>	The type of values in the domain.
 * 
 * @author Mayur Naik (mhn@cs.stanford.edu)
 */
public class Dom<T> extends IndexMap<T> {
	protected String name;
	public void setName(String name) {
		Assertions.Assert(name != null);
		Assertions.Assert(this.name == null);
		this.name = name;
	}
    public String getName() {
        return name;
    }
	/**
	 * Reflects the domain in memory onto disk.
	 */
	public void save() {
		PrintWriter out;
		String mapFileName = name + ".map";
		out = FileUtils.newPrintWriter(mapFileName);
		int size = size();
		for (int i = 0; i < size; i++)
			out.println(get(i));
		out.close();
		String domFileName = name + ".dom";
		out = FileUtils.newPrintWriter(domFileName);
		out.println(name + " " + size + " " + mapFileName);
		out.close();
	}
	/**
	 * Prints the values in the domain in memory to the standard
	 * output stream.
	 */
	public void print() {
		print(System.out);
	}
	/**
	 * Prints the values in the domain in memory to the specified
	 * output stream.
	 * 
	 * @param	out	The output stream to which the values in the
	 * 			domain in memory must be printed.
	 */
	public void print(PrintStream out) {
		for (int i = 0; i < size(); i++)
			out.println(get(i));
	}
}
