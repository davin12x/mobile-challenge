package co.bagga.demo500px.Model;

/**
 * Created by bagga on 2017-07-26.
 *
 * Represent information of photo
 */

public class Photo {

    private String name;
    private int followers_count;
    private String[] images;

    public String getFollowers_count() {
        return String.valueOf(followers_count);
    }

    public String getName() {
        return name;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
