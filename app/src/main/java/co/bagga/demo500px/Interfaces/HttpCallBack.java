package co.bagga.demo500px.Interfaces;

/***
 * Callback to be called after http call for an endpoint
 */
public interface HttpCallBack {
    /***
     * Method to be called after a successful HTTP request
     *
     * @param response response for the HTTP request issued
     * @param isSuccess is response success
     */
    void onHttpRequestResponse(String response, Boolean isSuccess);

}
