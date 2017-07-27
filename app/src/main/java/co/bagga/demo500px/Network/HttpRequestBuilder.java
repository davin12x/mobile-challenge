package co.bagga.demo500px.Network;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import co.bagga.demo500px.Interfaces.HttpCallBack;

/**
 * Builder to create JSON Object request
 */

public class HttpRequestBuilder {

    public static JsonObjectRequest buildPhotoSearchHttpRequest(String searchName, int imageSize, HttpCallBack httpCallBack) {
        final HttpRequest httpRequest = new HttpRequest();
        httpRequest.setRequestMethod(Request.Method.GET);
        httpRequest.setUrl(HttpUrlBuilder.buildPhotoSearchUrl(searchName, imageSize));
        return buildJsonRequest(httpRequest, httpCallBack);
    }

    /***
     * Generates a JSON request object
     *
     * @param httpRequest httpRequest Request containing all the http require parameters
     * @param httpCallBack Callback to be called after http request complete
     * @return JsonObjectRequest
     */
    private static JsonObjectRequest buildJsonRequest(final HttpRequest httpRequest, final HttpCallBack httpCallBack) {
        return new JsonObjectRequest(httpRequest.getRequestMethod(), httpRequest.getUrl()
                , new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                httpCallBack.onHttpRequestResponse(response.toString(), true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                httpCallBack.onHttpRequestResponse(error.toString(), false);
            }
        });
    }
}
