import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample {
    private static final Logger log = Logger.getLogger(LoggerExample.class.getName());
    public static void main(String[] args) {
        log.setLevel(Level.FINER);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINER);
        log.addHandler(handler);
        log.fine("This is a fine level log message.");
        log.finer("This is a finer level log message.");
        log.finest("This is a finest level log message.");
        /**
         * The last one won't print out because it is of finest and we have set our logger and our log level of our handlers at FINER. 
         * FINER and FINE are printed. We are building a chain inside of our handlers, and we can add multiple handlers down that chain of responsibility. 
         */
    }
}

/**
 * Output:
 * -------
 * Sept 22, 2025 3:55:07 AM LoggerExample main
 * FINE: This is a fine level log message.
 * Sept 22, 2025 3:55:07 AM LoggerExample main
 * FINER: This is a finer level log message.
 */