import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import model.SingleRestResponse;
import model.SingleStateResponse;
import model.StateDetails;
import model.MultipleStatesResponse;

public class StatesService {

    public static final String ADDRESS = "http://services.groupkt.com/state/get/USA/";

    public StateDetails getState(String code) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + code.toUpperCase());
        Response response = target.request().get();

        SingleStateResponse statesResponse = response.readEntity(SingleStateResponse.class);
        StateDetails stateDetails = statesResponse.getRestResponse().getData();
        if (stateDetails != null) {
            return stateDetails;
        }

        throw new IllegalArgumentException("Unknown state - " + code + ".");
        
//        return getAllStates().stream()
//            .filter(s -> s.getAbbr().equalsIgnoreCase(code))
//            .findAny()
//            .orElseThrow(
//                () -> new IllegalArgumentException("Unknown state - " + code + "."));
    }

    public List<StateDetails> getAllStates() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "all");
        Response response = target.request().get();

        MultipleStatesResponse statesResponse = response.readEntity(MultipleStatesResponse.class);
        return statesResponse.getRestResponse().getData();
    }
}
