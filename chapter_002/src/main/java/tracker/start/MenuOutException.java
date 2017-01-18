package tracker.start;

/**
 * Class MenuOutException действие в случаи outofRange
 */
public class MenuOutException extends RuntimeException {
    public  MenuOutException(String msg) {
        super(msg);
    }
}
