public class Artwork {
    private String title;
    private String author;
    private int yearOfCreation;
    private String category;
    private String placeOfCreation;
    private String imageUrl;

    public Artwork(String title, String author, int yearOfCreation, String category, String placeOfCreation, String imageUrl) {
        this.title = title;
        this.author = author;
        this.yearOfCreation = yearOfCreation;
        this.category = category;
        this.placeOfCreation = placeOfCreation;
        this.imageUrl = imageUrl;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYearOfCreation() { return yearOfCreation; }
    public void setYearOfCreation(int yearOfCreation) { this.yearOfCreation = yearOfCreation; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPlaceOfCreation() { return placeOfCreation; }
    public void setPlaceOfCreation(String placeOfCreation) { this.placeOfCreation = placeOfCreation; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
