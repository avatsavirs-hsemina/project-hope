package pmorph;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.jsoup.select.Elements;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Set;

@Entity
public class NewsItem {
    @Id
    private ObjectId id;
    private String title;
    private String pubDate;
    private String description;
    private String link;
    private String authorName;
    private Set<String> categories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }


}
