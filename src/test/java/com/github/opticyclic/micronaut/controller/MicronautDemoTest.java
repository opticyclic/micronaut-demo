package com.github.opticyclic.micronaut.controller;

import com.github.opticyclic.micronaut.demo.model.Account;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MicronautDemoTest {
    private EmbeddedServer embeddedServer;
    private HttpClient client;

    @BeforeClass
    public void init() {
        embeddedServer = ApplicationContext.run(EmbeddedServer.class);
        client = HttpClient.create(embeddedServer.getURL());
    }

    @AfterClass
    public void cleanup() {
        client.close();
        embeddedServer.close();
    }

    @Test
    public void testHelloWorldResponse() {
        Account currentAccount = new Account(Account.AccountType.CURRENT, "John Doe", 25);
        client.toBlocking().retrieve(HttpRequest.POST("/accounts", currentAccount));

        HttpResponse response = client.toBlocking().exchange("/accounts", Account.class);
        assertEquals(HttpStatus.OK, response.getStatus());

        String body = (String) response.getBody(String.class).get();
        assertTrue(body.contains("John Doe"));
    }

}
