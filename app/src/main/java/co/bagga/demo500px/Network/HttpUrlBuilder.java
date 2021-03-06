package co.bagga.demo500px.Network;

import co.bagga.demo500px.Utils.Constants;

public class HttpUrlBuilder {

    public static String buildPhotoSearchUrl(String searchName, int imageSize, int pageNumber ) {
        return Constants.BASE_URL + "photos/search?term=" + searchName + "&image_size=" + imageSize +
                "&page=" + pageNumber +"&consumer_key=" + Constants.CONSUMER_KEY_URL;
    }
}
