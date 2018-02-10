package model;

import org.codehaus.jackson.annotate.JsonProperty;

public class StatesResponse {

    @JsonProperty("RestResponse")
    private RestResponse restResponse;

    public StatesResponse() {
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
