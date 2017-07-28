package co.bagga.demo500px.Model;

public class User {
    private String fullname;
    private String country;
    private String userpic_url;
    private int followers_count;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserpic_url() {
        return userpic_url;
    }

    public void setUserpic_url(String userpic_url) {
        this.userpic_url = userpic_url;
    }

    public String getFollowers_count() {
        return String.valueOf(followers_count);
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }
}
