package fr.eni.bookhubback.dto;

public class BookCardResponse {
    private Long id;
    private String title;
    private String author;
    private String category;
    private boolean available;
    private String shortDesc;
    private String coverUrl;

    public BookCardResponse(Long id, String title, String author, String category, boolean available, String shortDesc, String coverUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = available;
        this.shortDesc = shortDesc;
        this.coverUrl = coverUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getCoverUrl() {
        return coverUrl;
    }
}
