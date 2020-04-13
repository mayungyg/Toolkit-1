package com.xavier.toolkit.util;

import com.xavier.toolkit.entity.SysMenu;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class URLDetect {
    private List<SysMenu> menus = null;

    public URLDetect(List<SysMenu> menus) {
        this.menus = menus;
    }

    public void checkAvailable(SysMenu menu) {
        HttpClient httpClient = new DefaultHttpClient();
        if (menu.getUrl() == null) {
            System.out.println(menu.getMenucode() + "\t\t" + menu.getUrl());
            return;
        }
        HttpUriRequest request = new HttpGet(menu.getUrl());
        request.getRequestLine();
        try {
            HttpResponse response = httpClient.execute(request);
            response.getStatusLine();
        } catch (ClientProtocolException e) {
            System.out.println(menu.getMenucode() + "\t\t" + menu.getUrl());
        } catch (IOException e) {
            System.out.println(menu.getMenucode() + "\t\t" + menu.getUrl());
        }
    }
}
