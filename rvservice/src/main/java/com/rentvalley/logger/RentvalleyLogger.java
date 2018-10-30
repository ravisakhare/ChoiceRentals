package com.rentvalley.logger;

import org.apache.log4j.Logger;

public class RentvalleyLogger
{
	private Logger logger;
	private RentvalleyLogger()
	{
		
	}
	private RentvalleyLogger(Class<?> classType) 
	{
		logger=Logger.getLogger(classType);
	}
	public static RentvalleyLogger getInstance(Class<?> classType)
	{
		return new RentvalleyLogger(classType);
	}
	public void trace(String msg) {
		logger.trace(msg);
	}
	public void debug(String msg,Exception e) {
		logger.debug(msg);
	}
	public void info(String msg) {
		logger.info(msg);
	}

	public void warn(String msg, Exception e) {
		logger.warn(msg);
	}

	public void error(String msg, Exception e) {
		logger.error(msg);
	}
	public void fatal(String msg, Exception e) {
		logger.fatal(msg);
	}


}
