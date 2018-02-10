package com.infoshareacademy.api;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class GoogleTranslate {

    private final String API_KEY;

    public GoogleTranslate(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String generateUrl(String address, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(address).append("?");

        params.forEach((key, value) -> {
                sb.append(key).append("=").append(value);
                sb.append("&");
        });

        return sb.toString();
    }

    public String translate(String input, String source, String target) {

        String address = "https://translation.googleapis.com/language/translate/v2";

        Form form = new Form();
        form.param("source", source);
        form.param("target", target);
        form.param("q", input);
        form.param("key", API_KEY);

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(address);
        Response response = webTarget.request().post(Entity.form(form));

        TranslateResponse result = response.readEntity(TranslateResponse.class);
        response.close();

        return result.getData().getTranslations().get(0).getTranslatedText();
    }
}