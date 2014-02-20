/**
 * 
 */
package us.juggl.codepalousa.jmx;

import javax.management.Description;
import javax.management.MXBean;
import javax.management.ManagedAttribute;
import javax.management.ManagedOperation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * A MXBean which allows for the modification and inspection of Log4J settings
 * @author <a href="https://github.com/InfoSec812">Deven Phillips</a>
 *
 */
@MXBean
@Description("A management bean which allows for the runtime reconfiguration of the log4j logging subsystem.")
public class LoggingSubsystem {

	@ManagedAttribute
	@Description("The currently set log level (as a string) for the Log4J RootLogger")
	public String getLogLevel() {
		return Logger.getRootLogger().getLevel().toString() ;
	}

	@ManagedOperation
	@Description("Change the current log level to the value specified as a string.")
	public void setLogLeve(String level) {
		Logger.getRootLogger().setLevel(Level.toLevel(level)) ;
		Logger.getRootLogger().log(Level.INFO, "Log level set to: "+Logger.getRootLogger().getLevel().toString()) ;
	}

	public void addPackageLogLevel(String packageName, String level) {
		
	}
}
