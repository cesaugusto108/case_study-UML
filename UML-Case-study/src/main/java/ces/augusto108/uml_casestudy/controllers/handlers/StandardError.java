package ces.augusto108.uml_casestudy.controllers.handlers;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 2299985509770887454L;

    private final Integer httpResponseStatus;
    private final String message;
    private final Long timeStamp;

    public StandardError(Integer httpResponseStatus, String message, Long timeStamp) {
        this.httpResponseStatus = httpResponseStatus;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Integer getHttpResponseStatus() {
        return httpResponseStatus;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
}
