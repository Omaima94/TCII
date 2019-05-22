public class Subscription {
    private Client client;
    private Category category;

    public Subscription(Client client, Category category) {
        this.client = client;
        this.category = category;
    }

    public Subscription(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}