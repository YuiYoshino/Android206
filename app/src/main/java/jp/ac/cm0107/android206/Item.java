package jp.ac.cm0107.android206;

public class Item {
    private String id;
    private String title;
    private String description;
    private String thumbnail_url;

    public String getId() {
        return id;
    }
        public void setId(String id){
            this.id = id;
        }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }
}

