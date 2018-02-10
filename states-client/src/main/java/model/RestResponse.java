package model;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class RestResponse {

    private List<String> messages;

    @JsonProperty("result")
    private List<StateDetails> data;

    public RestResponse() {
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<StateDetails> getData() {
        return data;
    }

    public void setData(List<StateDetails> data) {
        this.data = data;
    }
}
