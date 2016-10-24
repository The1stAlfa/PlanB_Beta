/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.database.google.spreadsheets;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author AI-Saac
 */
public class DBRequest {
    private String userAgent;
    private int responseCode;
    private InputStream dbResponse;
    
    public DBRequest(String userAgent){
        this.responseCode = -1;
        this.userAgent = userAgent;
        this.dbResponse = null;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public InputStream getDbResponse() {
        return dbResponse;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    
    private void sendGet(String url) throws IOException{
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", userAgent);

        HttpResponse response = client.execute(request);
        responseCode = response.getStatusLine().getStatusCode();
        dbResponse = response.getEntity().getContent();
    }
}
