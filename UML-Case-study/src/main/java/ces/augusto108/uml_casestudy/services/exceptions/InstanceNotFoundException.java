package ces.augusto108.uml_casestudy.services.exceptions;

public class InstanceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 7608983279988567567L;

    public InstanceNotFoundException(String message) {
        super(message);
    }

    public InstanceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
