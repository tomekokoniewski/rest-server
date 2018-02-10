package model;

import org.codehaus.jackson.annotate.JsonProperty;

public class MultipleStatesResponse {

    @JsonProperty("RestResponse")
    private MultipleRestResponse restResponse;

    public MultipleStatesResponse() {
    }

    public MultipleRestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(MultipleRestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
