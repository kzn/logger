package ru.iitp.cl.logger;

import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggerFactory;

/**
 * Thin wrapper on log4j Logger class
 * @author Anton Kazennikov
 *
 */
public class Logger {
	org.apache.log4j.Logger logger;
	
	private Logger() {
		logger = org.apache.log4j.Logger.getLogger(getCallerClassName());
	}
	
	private Logger(Class<?> clazz) {
		logger = org.apache.log4j.Logger.getLogger(clazz);
	}
	
	private Logger(String name) {
		logger = org.apache.log4j.Logger.getLogger(name);
	}
	
	private Logger(String name, LoggerFactory factory) {
		logger = org.apache.log4j.Logger.getLogger(name, factory);
	}

	
    private static String getCallerClassName() {
    	StackTraceElement[] st = new Exception().getStackTrace();
    
        return st.length > 3? st[3].getClassName() : "logger";
    }
    
    public static Logger getLogger() {
    	return new Logger();
    }
    
    public static Logger getLogger(Class<?> clazz) {
    	return new Logger(clazz);
    }
    
    public static Logger getLogger(String name) {
    	return new Logger(name);
    }
    
    public static Logger getLogger(String name, LoggerFactory factory) {
    	return new Logger(name, factory);
    }


    
    public boolean isTraceEnabled() {
    	return logger.isTraceEnabled();
    }
    
    public boolean isDebugEnabled() {
    	return logger.isDebugEnabled();
    }
    
    public boolean isInfoEnabled() {
    	return logger.isInfoEnabled();
    }
    
    public void trace(String format, Object...objects) {
    	if(logger.isTraceEnabled()) {
    		logger.trace(String.format(format, objects));
    	}
    }
    
    public void trace(String format, Throwable e, Object...objects) {
    	if(logger.isTraceEnabled()) {
    		logger.trace(String.format(format, objects), e);
    	}
    }
    
    public void debug(String format, Object...objects) {
    	if(logger.isDebugEnabled()) {
    		logger.debug(String.format(format, objects));
    	}
    }
    
    public void debug (String format, Throwable e, Object...objects) {
    	if(logger.isDebugEnabled()) {
    		logger.debug(String.format(format, objects), e);
    	}
    }
    
    public void info(String format, Object...objects) {
    	if(logger.isInfoEnabled()) {
    		logger.info(String.format(format, objects));
    	}
    }
    
    public void info(String format, Throwable e, Object...objects) {
    	if(logger.isInfoEnabled()) {
    		logger.info(String.format(format, objects), e);
    	}
    }
    
    public void warn(String format, Object...objects) {
    	if(logger.isEnabledFor(Priority.WARN))
    		logger.warn(String.format(format, objects));
    }
    
    public void warn(String format, Throwable e, Object...objects) {
    	if(logger.isEnabledFor(Priority.WARN)) {
    		logger.warn(String.format(format, objects), e);
    	}
    }
    
    public void error(String format, Object...objects) {
    	if(logger.isEnabledFor(Priority.ERROR))
    		logger.error(String.format(format, objects));
    }
    
    public void error(String format, Throwable e, Object...objects) {
    	if(logger.isEnabledFor(Priority.ERROR)) {
    		logger.error(String.format(format, objects), e);
    	}
    }
    
        public void fatal(String format, Object...objects) {
    	if(logger.isEnabledFor(Priority.FATAL))
    		logger.fatal(String.format(format, objects));
    }
    
    public void fatal(String format, Throwable e, Object...objects) {
    	if(logger.isEnabledFor(Priority.FATAL)) {
    		logger.fatal(String.format(format, objects), e);
    	}
    }



    
    
    

}
