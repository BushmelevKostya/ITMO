package Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
	
	static final Logger rootLogger = LogManager.getRootLogger();
	static final Logger userLogger = LogManager.getLogger(User.class);
	
	public static void main(String[] args) {
		User user = new User();
		user.setName("Anakin");
		user.setLastName("Skywalker");
		
		userLogger.info(user.showMeMessage());
		userLogger.info(user.giveMeASign());
		
		rootLogger.info("Root Logger: "  + user.showMeMessage());
		
		//debug
		if (rootLogger.isDebugEnabled()) {
			rootLogger.debug("RootLogger: In debug message");
			userLogger.debug("UserLogger in debug");
		}
		
		try {
			User userNull = new User();
		} catch (NullPointerException ex) {
			userLogger.error("error message: " + ex.getMessage());
			userLogger.fatal("fatal error message: " + ex.getMessage());
		}
		
		
	}
}