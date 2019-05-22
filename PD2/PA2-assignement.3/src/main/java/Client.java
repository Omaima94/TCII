import java.util.List;

public interface Client {

    void receive(List<Message> message);
}
