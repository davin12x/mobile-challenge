package co.bagga.demo500px.Events;

/**
 * Created by bagga on 2017-07-27.
 *
 * To be called when PhotoSearch Http request response received
 */

public class PhotoSearchHttpResponseEvent {
    public Boolean responseStatus;

    public PhotoSearchHttpResponseEvent(Boolean responseStatus) {
        this.responseStatus = responseStatus;
    }
}
