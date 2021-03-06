/*
 * Copyright (c) 2006-07, The Trustees of Stanford University.  All
 * rights reserved.
 * Licensed under the terms of the GNU GPL; see COPYING for details.
 */
package chord.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utility to execute a system command specified as a string in a
 * separate process.
 * 
 * @author Mayur Naik (mhn@cs.stanford.edu)
 */
public final class ProcessExecutor {
	/**
	 * Executes a given system command specified as a string in a
	 * separate process.
	 * <p>
	 * The invoking process waits till the invoked process finishes.
	 * 
	 * @param	A system command to be executed.
	 * 
	 * @return	The exit value of the invoked process.
	 * 			By convention, 0 indicates normal termination.
	 */
    public static final int execute(String cmd) {
        try {
	    	Process proc = Runtime.getRuntime().exec(cmd);
	    	StreamGobbler err =
	    		new StreamGobbler(proc.getErrorStream(), "ERR");
	        StreamGobbler out = 
	        	new StreamGobbler(proc.getInputStream(), "OUT");
	        err.start();
	        out.start();
	        return proc.waitFor();
        } catch (Exception e) {
        	throw new RuntimeException(e.getMessage());
        }
        
    }
    private static class StreamGobbler extends Thread {
        private final InputStream s;
        private final String n;
        private StreamGobbler(InputStream s, String n) {
            this.s = s;
            this.n = n;
        }
        public void run() {
            try {
                BufferedReader r =
                	new BufferedReader(new InputStreamReader(s));
                String l;
                while ((l = r.readLine()) != null)
                    System.out.println(n + "> " + l);
            } catch (IOException e) {
            	throw new RuntimeException(e.getMessage());
            }
        }
    }
}

