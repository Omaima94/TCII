import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    private RaceResultsService raceResults = new RaceResultsService();
    private List<Message> message = new ArrayList<>();
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");
    private Client clientC = mock(Client.class, "clientC");
    private Category horseRacesCategory = raceResults.getCategory(0);
    private Category f1RacesCategory = raceResults.getCategory(1);
    private Category boatRacesCategory = raceResults.getCategory(2);

    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message);
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        verify(clientA).receive(message);
    }

    @Test
    public void allSubscribedClientsShouldReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);
        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        verify(clientA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() throws Exception {
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);
        raceResults.send(message);
        verify(clientA, never()).receive(message);
    }

    @Test
    public void subscribedClientToSelectedCategoriesShouldReceiveMessageRelatedToTheseCategories() {
        raceResults.addSubscriber(clientA, horseRacesCategory, f1RacesCategory);
        raceResults.addSubscriber(clientB, f1RacesCategory);
        raceResults.addSubscriber(clientC, f1RacesCategory, boatRacesCategory);
        raceResults.send(message, horseRacesCategory, boatRacesCategory);
        verify(clientA).receive(message);
        verify(clientC).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test(expected = Exception.class)
    public void unsubscribedClientShouldNotBeAbleToUnsubscribe() throws Exception {
        raceResults.removeSubscriber(clientA);
    }
}