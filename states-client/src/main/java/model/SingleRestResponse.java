package model;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class SingleRestResponse {

    private List<String> messages;

    @JsonProperty("result")
    private StateDetails data;

    public SingleRestResponse() {
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public StateDetails getData() {
        return data;
    }

    public void setData(StateDetails data) {
        this.data = data;
    }
}
