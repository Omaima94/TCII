import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class RaceResultsService {

    private Collection<Subscription> subscriptions = new HashSet<>();
    private List<Category> categories = new ArrayList<>();

    public RaceResultsService() {
        this.categories.add(new Category("horse races"));
        this.categories.add(new Category("f1 races"));
        this.categories.add(new Category("boat races"));
    }

    public void addSubscriber(Client client, Category... categories) {
        if (categories.length > 0) {
            for (Category category : categories) {
                subscriptions.add(new Subscription(client, category));
            }
        } else {
            long count = subscriptions.stream().filter(s -> s.getClient().equals(client)).count();
            if (count == 0) subscriptions.add(new Subscription(client));
        }
    }

    public void send(List<Message> messages, Category... categories) {
        if (categories.length > 0) {
            for (Category category : categories) {
                for (Subscription subscription : subscriptions) {
                    if (subscription.getCategory().equals(category))
                        subscription.getClient().receive(messages);
                }
            }
        } else {
            for (Subscription subscription : subscriptions) {
                subscription.getClient().receive(messages);
            }
        }
    }

    public void removeSubscriber(Client client) throws Exception {
        boolean removed = subscriptions.removeIf(s -> s.getClient().equals(client));
        if (!removed) {
            throw new Exception("Not subscribed !");
        }
    }

    public Category getCategory(int i) {
        return categories.get(i);
    }

}
