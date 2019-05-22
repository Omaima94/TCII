import java.util.*;

public class Book {

    private String name;
    private String author;
    private List<Chapter> chapters;

    public Book(String name, String author) {
        if (name == null || name.isEmpty() || author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.name = name;
        this.author = author;
        this.chapters = new ArrayList<>();
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
        if (this.getChapters() != null) {

            int index = this.chapters.indexOf(new Chapter(name, number));

            this.chapters.add(index + 1, chapter);

        }
    }

    public Set<Chapter> getTableOfContent() {
        return new LinkedHashSet<>(this.getChapters());
    }
}
