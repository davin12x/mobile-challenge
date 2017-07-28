package co.bagga.demo500px.Model;

/**
 * Created by bagga on 2017-07-26.
 *
 * Represent information of photo
 */

public class Photo {

    private String name;
    private int votes_count;
    private Image[] images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public String getVotes_count() {

        return String.valueOf(votes_count);
    }

    public void setVotes_count(int votes_count) {
        this.votes_count = votes_count;
    }
}
