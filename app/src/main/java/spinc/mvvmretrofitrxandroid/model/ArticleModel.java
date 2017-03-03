package spinc.mvvmretrofitrxandroid.model;

public class ArticleModel {

    private String title;
    private String body;
    private String image;
    private boolean highlight;
    private boolean read;
    private int commentsNumber;


    public ArticleModel(String title, String excerpt, boolean highlight, String imageUrl, int commentsNumber, boolean read) {
        this.title = title;
        this.body = excerpt;
        this.image = imageUrl;
        this.highlight = highlight;
        this.commentsNumber = commentsNumber;
        this.read = read;
    }
/* constructor */
    /* getters and setters */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return body;
    }

    public void setExcerpt(String excerpt) {
        this.body = excerpt;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public String getImageUrl() {
        return image;
    }

    public void setImageUrl(String imageUrl) {
        this.image = imageUrl;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public void setCommentsNumber(int commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}