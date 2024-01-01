public class LogLevels {

    public static String message(String logLine) {
        String message = logLine.split(":", 2)[1].trim();
        return message;
    }

    public static String logLevel(String logLine) {
        String logLevel = logLine.split(":", 2)[0];
        logLevel = logLevel.substring(1, logLevel.length() - 1).toLowerCase();
        return logLevel;
    }

    public static String reformat(String logLine) {
        String message = message(logLine);
        String logLevel = logLevel(logLine);
        return message + " (" + logLevel + ")";
    }
}
