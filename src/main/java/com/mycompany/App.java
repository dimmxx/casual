package com.mycompany;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        String req = "https://fttx-client-dev.impltech.com/ogc/1?ACCEPTVERSIONS=2.0.0,1.1.0,1.0.0&SERVICE=WFS&REQUEST=GetFeature&VERSION=1.1.0&TYPENAME=cable&outputFormat=application/json&SRSNAME=EPSG:4326";


        //HttpClient client = HttpClient.newHttpClient();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(req))
                .build();

//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();

        CompletableFuture<String> completableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
        String response = completableFuture.get();
        System.out.println(response);


        JSONObject jsonObject = new JSONObject(response);

        JSONArray array = jsonObject.getJSONArray("features");
        jsonObject = array.getJSONObject(0);
        jsonObject = jsonObject.getJSONObject("geometry");
        array = jsonObject.getJSONArray("coordinates");


        for(int i = 0; i < array.length(); i++) {
            System.out.println(array.get(i));
        }

        System.out.println(array);



    }



}
