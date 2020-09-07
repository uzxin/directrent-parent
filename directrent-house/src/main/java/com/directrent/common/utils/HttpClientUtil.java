package com.directrent.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * HttpClient
 * <p>
 * http get、post
 *
 * @author quan
 */
public class HttpClientUtil {
    private static final CloseableHttpClient httpclient = HttpClients.createDefault();
    /**
     * 发送HttpGet请求
     *
     * @param url
     * @return
     */
    public static String sendGetAndHeader(String url, Map<String, String> header) {
        HttpGet httpget = new HttpGet(url);
        if (header != null) {
            Set<String> keys = header.keySet();
            for (Iterator<String> i = keys.iterator(); i.hasNext(); ) {
                String key = (String) i.next();
                httpget.addHeader(key, header.get(key));
            }
        }

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * 发送HttpGet请求
     *
     * @param url
     * @return
     */
    public static String sendGet(String url) {

        return sendGetAndHeader(url,null);
    }

    /**
     * 发送HttpGet请求，参数为param
     *
     * @param url
     * @return
     */
    public static String sendGet(String url, Map<String, String> param) {

        String params = "";
        for (Map.Entry<String, String> entry : param.entrySet()) {
            params += entry.getKey() + "=" + entry.getValue() + "&";
        }

        params = params.substring(0, params.length() - 1);
        url += "?" + params;

        return sendGetAndHeader(url,null);
    }

    /**
     * 发送HttpGet请求，参数为param
     *
     * @param url
     * @return
     */
    public static String sendGet(String url, Map<String, String> header, Map<String, String> param) {

        String params = "";
        for (Map.Entry<String, String> entry : param.entrySet()) {
            params += entry.getKey() + "=" + entry.getValue() + "&";
        }

        params = params.substring(0, params.length() - 1);
        url += "?" + params;

        return sendGetAndHeader(url, header);
    }

    /**
     * 发送HttpPost请求，参数为param
     *
     * @param url
     * @param
     * @return
     */
    public static String sendPost(String url, Map<String, String> param) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        String result = null;

        try {
            response = httpclient.execute(httppost);
            if (response != null) {
                HttpEntity entity1 = response.getEntity();
                result = EntityUtils.toString(entity1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return result;
    }

    /**
     * 发送HttpPost请求，参数转为json
     *
     * @param url
     * @param param
     * @return
     */
    public static String sendPostJson(String url, Map<String, String> header, JSONObject param) {
        String result = null;
        try {
            StringEntity s = new StringEntity(param.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");

            HttpPost httppost = new HttpPost(url);

            if (header != null) {
                Set<String> keys = header.keySet();
                for (Iterator<String> i = keys.iterator(); i.hasNext(); ) {
                    String key = (String) i.next();
                    httppost.addHeader(key, header.get(key));
                }
            }

            httppost.setEntity(s);
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity1 = response.getEntity();

            result = EntityUtils.toString(entity1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 发送HttpPost请求，参数转为json
     *
     * @param url
     * @param param
     * @return
     */
    public static String sendPostJson(String url, JSONObject param) {
        return sendPostJson(url, null, param);

    }

    /**
     * 发送不带参数的HttpPost请求
     *
     * @param url
     * @return
     */
    public static String sendPost(String url) {
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String sendDelete(String url, Map<String, String> headerMap) {

        String result = null;
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            if (headerMap != null) {
                Set<String> keys = headerMap.keySet();
                for (Iterator<String> i = keys.iterator(); i.hasNext(); ) {
                    String key = (String) i.next();
                    httpDelete.addHeader(key, headerMap.get(key));
                }
            }
            CloseableHttpResponse response = httpclient.execute(httpDelete);
            HttpEntity entity1 = response.getEntity();

            result = EntityUtils.toString(entity1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
