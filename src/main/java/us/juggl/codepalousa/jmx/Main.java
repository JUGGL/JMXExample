package us.juggl.codepalousa.jmx;

import net.gescobar.jmx.Management;
import org.apache.log4j.Logger;

public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class) ;
	private static int INTERVAL = 50 ;

	public static void main(String[] args) throws Exception {
		Management.register(new LoggingSubsystem(), "us.juggl.codepalousa:type=LoggingSubsystem") ;

		while (true) {
			LOG.fatal("Here is a log message at FATAL level.") ;
			for (int x=0;x<5;x++) {
				LOG.error("Here is a log message at ERROR level.") ;
				for (int y=0;y<5;y++) {
					LOG.warn("Here is a log message at WARN level.") ;
					for (int z=0;z<5;z++) {
						LOG.info("Here is a log message at INFO level.") ;
						for (int a=0;a<5;a++) {
							LOG.debug("Here is a log message at DEBUG level.") ;
							Thread.sleep(INTERVAL) ;
						}
						Thread.sleep(INTERVAL) ;
					}
					Thread.sleep(INTERVAL) ;
				}
				Thread.sleep(INTERVAL) ;
			}
			Thread.sleep(INTERVAL) ;
		}
	}
}
