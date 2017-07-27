package co.bagga.demo500px.Network;

/**
 *
 * Represents HttpRequest Layer
 */

public class HttpRequest {
    private String url;
    private int requestMethod;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public int getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(int requestMethod) {
        this.requestMethod = requestMethod;
    }
}
