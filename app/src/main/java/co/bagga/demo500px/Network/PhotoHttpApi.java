package co.bagga.demo500px.Network;

import android.content.Context;

import java.util.ArrayList;

import co.bagga.demo500px.Interfaces.HttpCallBack;
import co.bagga.demo500px.Model.Photo;

class PhotoHttpApi {

    private static ArrayList<Photo> photos;

    private static Context context;

    private static final PhotoHttpApi ourInstance = new PhotoHttpApi();

    static PhotoHttpApi getInstance(Context context) {
        if (photos == null) {
            photos = new ArrayList<>();
        }
        PhotoHttpApi.context = context;
        return ourInstance;
    }

    private PhotoHttpApi() {
    }

    public void buildSearchPhotoRequest(String searchName, int imageSize) {
        VolleyRequest.getInstance(context).addToVolleyRequestQueue(HttpRequestBuilder
                .buildPhotoSearchHttpRequest(searchName, imageSize, new HttpCallBack() {
                    @Override
                    public void onHttpRequestResponse(String response, Boolean isSuccess) {

                    }
                }));
    }
}
