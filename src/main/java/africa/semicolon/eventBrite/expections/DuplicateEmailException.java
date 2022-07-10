package africa.semicolon.eventBrite.expections;

public class DuplicateEmailException extends EventbriteException {
    public DuplicateEmailException(String message) {
        super(message);
    }
}
