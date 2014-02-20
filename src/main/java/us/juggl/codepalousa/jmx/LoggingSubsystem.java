/**
 * 
 */
package us.juggl.codepalousa.jmx;

import net.gescobar.jmx.annotation.Description;
import net.gescobar.jmx.annotation.ManagedAttribute;
import net.gescobar.jmx.annotation.ManagedOperation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * A MXBean which allows for the modification and inspection of Log4J settings
 * @author <a href="https://github.com/InfoSec812">Deven Phillips</a>
 *
 */
@Description(value="A management bean which can be used to control and view logging configuration at runtime.")
public class LoggingSubsystem {

	@ManagedAttribute(description="The currently set log level (as a string) for the Log4J RootLogger", readable=true, writable=true)
	public String getRootLogLevel() {
		return Logger.getRootLogger().getLevel().toString() ;
	}

	public void setRootLogLevel(String level) {
		Logger.getRootLogger().setLevel(Level.toLevel(level)) ;
		Logger.getRootLogger().log(Level.FATAL, "*********** Log level set to: "+Logger.getRootLogger().getLevel().toString()) ;
	}

	@ManagedOperation(description="Get the currently set log level for members of the specified name (class or package).")
	public String getLogLevelForName(String name) {
		Level target = Logger.getLogger(name).getLevel() ;
		if (target==null) {
			return "NONE" ;
		} else {
			return target.toString() ;
		}
	}

	@ManagedOperation(description="Set the log level for the given item name (class or package name) and it's children")
	public void setLogLevelForName(String name, String level) {
		Logger.getLogger(name).setLevel(Level.toLevel(level)) ;
		Logger.getLogger(LoggingSubsystem.class).log(Level.FATAL, "*********** Log level for '"+name+"' set to: "+Logger.getLogger(name).getLevel().toString()) ;
	}
}
