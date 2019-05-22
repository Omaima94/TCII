import org.junit.Assert;
import org.junit.Test;

public class BasicStatisticTest {

    BasicStatistic basicStatistic = new BasicStatistic();;

    @Test
    public void basicStatisticConstructor() {
        Assert.assertEquals(basicStatistic.getDataItems().size(), 0);
    }

    @Test
    public void addDoubleToData() {
        basicStatistic.addDoubleToData(new Double(2));
        Assert.assertNotEquals(basicStatistic.getDataItems().size(), 0);
    }

    @Test
    public void clearData() {
        basicStatistic.clearData();
        Assert.assertEquals(basicStatistic.getDataItems().size(), 0);
    }

    @Test
    public void clearThenAddDoubleToData() {
        basicStatistic.clearData();
        Assert.assertEquals(basicStatistic.getDataItems().size(), 0);
        basicStatistic.addDoubleToData(new Double(3));
        basicStatistic.addDoubleToData(new Double(5));
        Assert.assertEquals(basicStatistic.getDataItems().size(), 2);
    }

    @Test
    public void sum() {
        basicStatistic.clearData();
        basicStatistic.addDoubleToData(new Double(3));
        basicStatistic.addDoubleToData(new Double(5));
        basicStatistic.addDoubleToData(new Double(7));
        basicStatistic.addDoubleToData(new Double(10));
        Double sum = basicStatistic.sum();
        Assert.assertEquals((double)sum, 25, 0);
    }
}