package co.bagga.demo500px.Model;

public class MainPhoto {

    private int current_page;
    private Photo[] photos;

    public int getCurrent_page() {
        return current_page;
    }


    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public Photo[] getPhotos() {
        return photos;
    }

    public void setPhotos(Photo[] photos) {
        this.photos = photos;
    }
}
