package com.infoshareacademy.api;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GoogleTranslateTest {

    public static final String API_KEY = "AIzaSyBFhP9kVN4d_hYuD2tz6yzri6cHYH6tAe0";

    private GoogleTranslate googleTranslate;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        googleTranslate = new GoogleTranslate(API_KEY);
    }

    @Test
    public void shouldTranslate() {
        final String input = "Hi, how are you?";
        final String source = "en";
        final String target = "pl";

        final String result = googleTranslate.translate(input, source, target);
        assertThat(result, is("Cześć jak się masz?"));
    }

    @Test
    public void shouldHandleFailure() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("The request is missing a valid API key.");

        googleTranslate = new GoogleTranslate("123123123");

        final String input = "Hi, how are you?";
        final String source = "en";
        final String target = "pl";
        googleTranslate.translate(input, source, target);
    }

    @Test
    public void shouldGenerateUrl() {
        String address = "http://localhost/";
        Map<String, String> params = new HashMap<>();
        params.put("param1", "1");
        params.put("param2", "abc");

        String expectedUrl = "http://localhost/?param1=1&param2=abc&";

        String url = googleTranslate.generateUrl(address, params);
        assertThat(url, is(expectedUrl));
    }
}