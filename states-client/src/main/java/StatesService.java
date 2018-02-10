import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class StatesService {

    public static final String ADDRESS = "http://services.groupkt.com/state/get/USA/all";

    public List getAllStates() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS);
        Response response = target.request().get();

        //
        String result = response.readEntity(String.class);
        System.out.println(result);

        return new ArrayList();
    }
}
