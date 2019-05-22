import org.junit.Test;

public class ChapterTest {

    @Test(expected = IllegalArgumentException.class)
    public void chapterWithNullName() {
        Chapter chapter = new Chapter(null, "3.8");
    }

    @Test(expected = IllegalArgumentException.class)
    public void chapterWithWrongNumberFormat() {
        Chapter chapter = new Chapter("Chapter 1", "99.2");
    }

    @Test
    public void chapterCreationSuccess() {
        Chapter chapter = new Chapter("Chapter 1", "9.9");
    }


}