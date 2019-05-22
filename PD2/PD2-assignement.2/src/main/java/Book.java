import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Book {

    private String name;
    private String author;
    private List<Chapter> chapters;

    public Book(String name, String author) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void addChapter(String name, String number, Chapter chapter) {
    }

    public Set<Chapter> getTableOfContent() {
        return new HashSet<>();
    }
}
