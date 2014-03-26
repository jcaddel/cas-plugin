package org.jenkinsci.plugins.cas;

import static java.lang.String.format;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Logger {

	public static final void info(String method) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS zzz");
		String now = sdf.format(new Date());
		Throwable throwable = new Throwable();
		StackTraceElement[] elements = throwable.getStackTrace();
		StackTraceElement directCaller = elements[1];
		String className = directCaller.getClassName();
		System.out.println("[INFO] " + now + " " + className + "." + method);
	}

	public static final void info(String method, String msg, Object... args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS zzz");
		String now = sdf.format(new Date());
		Throwable throwable = new Throwable();
		StackTraceElement[] elements = throwable.getStackTrace();
		StackTraceElement directCaller = elements[1];
		String className = directCaller.getClassName();
		if (args == null || args.length == 0) {
			System.out.println("[INFO] " + now + " " + className + "." + method + " " + msg);
		} else {
			System.out.println("[INFO] " + now + " " + className + "." + method + " " + format(msg, args));
		}
	}

}
