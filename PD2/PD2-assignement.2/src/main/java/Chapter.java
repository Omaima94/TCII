import java.util.regex.Pattern;

public class Chapter implements Comparable<Chapter> {

    private String name;
    private String number;

    public Chapter(String name, String number) {
        if(name == null || number == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        } else {
                Pattern pattern = Pattern.compile("^\\d.\\d$");
            if(pattern.matcher(number).find()) {
                this.name = name;
                this.number = number;
            } else {
                throw new IllegalArgumentException("Number should be 'x.x' where x is a digit");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int compareTo(Chapter o) {
         if (this.name.compareTo(o.getName()) == 1 && this.number.compareTo(o.getNumber()) == 1) {
             return 1;
        }
         return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().equals(((Chapter) obj).getName()) && this.getNumber().equals(((Chapter) obj).getNumber());
    }
}
