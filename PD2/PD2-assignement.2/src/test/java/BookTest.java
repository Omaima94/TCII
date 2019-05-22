import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookTest {

    Book book = null;
    Chapter chapter;
    Chapter chapter2;
    Chapter chapter3;

    @Before
    public void setup() {
        book = new Book("Book 1", "Author 1");
        chapter = new Chapter("Chapter 1", "1.2");
        chapter2 = new Chapter("Chapter 2", "1.4");
        chapter3 = new Chapter("Chapter 3", "2.5");
        List<Chapter> chapters = new ArrayList<>();
        chapters.add(chapter);
        book.setChapters(chapters);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullName() {
        Book book = new Book(null, "Author 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullAuthor() {
        Book book = new Book("Book 1", null);
    }

    @Test
    public void addChapter() {
        book.addChapter(chapter.getName(), chapter.getNumber(), chapter2);
        Assert.assertEquals(book.getChapters().size(), 2);
        Assert.assertEquals(book.getChapters().get(0), chapter);
        Assert.assertEquals(book.getChapters().get(1), chapter2);
    }

    @Test
    public void tableOfContentItemsOrder() {
        book.addChapter(chapter.getName(), chapter.getNumber(), chapter2);
        book.addChapter(chapter2.getName(), chapter2.getNumber(), chapter3);
        Set<Chapter> tableOfContent = book.getTableOfContent();
        Assert.assertEquals(tableOfContent.toArray(new Chapter[tableOfContent.size()])[0], chapter);
        Assert.assertEquals(tableOfContent.toArray(new Chapter[tableOfContent.size()])[1], chapter2);
        Assert.assertEquals(tableOfContent.toArray(new Chapter[tableOfContent.size()])[2], chapter3);
    }

}