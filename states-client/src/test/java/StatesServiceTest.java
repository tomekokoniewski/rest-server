import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;
import model.StateDetails;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StatesServiceTest {

    private StatesService service;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        service = new StatesService();
    }

    @Test
    public void shouldGetAllStates() {
        List<StateDetails> states = service.getAllStates();
        assertThat(states.size(), is(55));
    }

    @Test
    public void shouldGetSingleState() {
        StateDetails stateDetails = service.getState("CA");
        assertThat(stateDetails.getName(), is("California"));
        assertThat(stateDetails.getAbbr(), is("CA"));
    }

    @Test
    public void shouldNotReturnDetailsForUnknownCode() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unknown state - XX.");

        service.getState("XX");
    }
}