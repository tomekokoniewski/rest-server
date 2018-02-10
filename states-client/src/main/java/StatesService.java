import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import model.StateDetails;
import model.StatesResponse;

public class StatesService {

    public static final String ADDRESS = "http://services.groupkt.com/state/get/USA/all";

    public StateDetails getState(String code) {
        return null;
    }

    public List<StateDetails> getAllStates() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS);
        Response response = target.request().get();

        StatesResponse statesResponse = response.readEntity(StatesResponse.class);
        return statesResponse.getRestResponse().getData();
    }
}
