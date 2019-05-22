import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {

    private List<Double> dataItems;

    public BasicStatistic() {
        this.dataItems = new ArrayList<>();
    }

    @Override
    public void addDoubleToData(Double valueToAdd){
        this.dataItems.add(valueToAdd);
    }

    @Override
    public void clearData(){
        this.dataItems.clear();
    };

    @Override
    public int numberOfDataItems(){
        int rv = 0;
        return rv;
    }

    @Override
    public Double sum(){
        double rv = 0.0;
        rv = dataItems.stream().collect(Collectors.summingDouble(Double::doubleValue));
        return rv;
    }

    public List<Double> getDataItems() {
        return dataItems;
    }

    public void setDataItems(List<Double> dataItems) {
        this.dataItems = dataItems;
    }
}
