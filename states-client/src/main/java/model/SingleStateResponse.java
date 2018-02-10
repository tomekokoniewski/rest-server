package model;

import org.codehaus.jackson.annotate.JsonProperty;

public class SingleStateResponse {

    @JsonProperty("RestResponse")
    private SingleRestResponse restResponse;

    public SingleStateResponse() {
    }

    public SingleRestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(SingleRestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
