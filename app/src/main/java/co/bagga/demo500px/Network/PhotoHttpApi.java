package co.bagga.demo500px.Network;

import android.content.Context;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;

import co.bagga.demo500px.Events.PhotoSearchHttpResponseEvent;
import co.bagga.demo500px.Interfaces.HttpCallBack;
import co.bagga.demo500px.Model.MainPhoto;
import co.bagga.demo500px.Model.Photo;

public class PhotoHttpApi {

    public static ArrayList<Photo> photos;

    private static Context context;

    private static final PhotoHttpApi ourInstance = new PhotoHttpApi();

    public static PhotoHttpApi getInstance(Context context) {
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
                        MainPhoto mainPhoto = new Gson().fromJson(response, MainPhoto.class);
                        if (mainPhoto.getPhotos() != null) {
                            Collections.addAll(photos, mainPhoto.getPhotos());
                        }
                        EventBus.getDefault().post(new PhotoSearchHttpResponseEvent());
                    }
                }));
    }
}
