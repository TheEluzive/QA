package Automation_Best_Practices_and_Patterns;

import org.apache.log4j.LogManager;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import org.apache.log4j.Level;

/**
 * @author My.com
 *
 */

@SuppressWarnings("serial")
public class MyLog4jLevel extends Level {

    /**
     * Value of MyLog4jLevel level. This value is lesser than DEBUG_INT and higher
     * than TRACE_INT}
     */
    public static final int My_INT = DEBUG_INT - 10;

    /**
     * Level representing my log level
     */
    public static final Level My = new MyLog4jLevel(My_INT, "My", 10);

    /**
     * Constructor
     */
    protected MyLog4jLevel(int arg0, String arg1, int arg2) {
        super(arg0, arg1, arg2);

    }

    /**
     * Checks whether logArgument is "My" level. If yes then returns
     * My}, else calls MyLog4jLevel#toLevel(String, Level) passing
     * it Level#DEBUG as the defaultLevel.
     */
    public static Level toLevel(String logArgument) {
        if (logArgument != null && logArgument.toUpperCase().equals("My")) {
            return My;
        }
        return (Level) toLevel(logArgument, Level.DEBUG);
    }

    /**
     * Checks whether val is MyLog4jLevel#My_INT. If yes then
     * returns MyLog4jLevel#My, else calls
     * MyLog4jLevel#toLevel(int, Level) passing it Level#DEBUG as the
     * defaultLevel
     *
     */
    public static Level toLevel(int val) {
        if (val == My_INT) {
            return My;
        }
        return (Level) toLevel(val, Level.DEBUG);
    }

    /**
     * Checks whether val is MyLog4jLevel#My_INT. If yes
     * then returns MyLog4jLevel#My, else calls Level#toLevel(int, org.apache.log4j.Level)
     *
     */
    public static Level toLevel(int val, Level defaultLevel) {
        if (val == My_INT) {
            return My;
        }
        return Level.toLevel(val, defaultLevel);
    }

    /**
     * Checks whether logArgument is "My" level. If yes then returns
     * MyLog4jLevel#My, else calls
     * Level#toLevel(java.lang.String, org.apache.log4j.Level)
     *
     */
    public static Level toLevel(String logArgument, Level defaultLevel) {
        if (logArgument != null && logArgument.toUpperCase().equals("My")) {
            return My;
        }
        return Level.toLevel(logArgument, defaultLevel);
    }
}


