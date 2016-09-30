public class Logger {
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<String, Integer>(); 
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message) && map.get(message) + 10 > timestamp) {
            return false;
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}
