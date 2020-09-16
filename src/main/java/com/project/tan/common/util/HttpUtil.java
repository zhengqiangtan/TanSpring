//package com.project.tan.common.util;
//
//import lombok.extern.slf4j.Slf4j;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * http 请求工具类
// */
//@Slf4j
//public class HttpUtil {
//
//    /**
//     * @param url
//     * @return
//     */
//    public static String get(String url) {
//        try {
//            Connection.Response response = Jsoup.connect(url).followRedirects(true).ignoreHttpErrors(true)
//                    .ignoreContentType(true).timeout(30000).maxBodySize(0).method(Connection.Method.GET).execute();
//            return response.body();
//        } catch (IOException e) {
//            log.error("请求{}异常：", url, e);
//        }
//        return null;
//    }
//
//    /**
//     * @param url
//     * @param url
//     * @return
//     */
//    public static String postData(String url, Map<String, String> data) {
//        try {
//            Connection.Response response = Jsoup.connect(url).followRedirects(true).ignoreHttpErrors(true).data(data)
//                    .validateTLSCertificates(false).header("Content-Type", "application/x-www-form-urlencoded")
//                    .maxBodySize(0).ignoreContentType(true).timeout(30000).method(Connection.Method.POST).execute();
//            return response.body();
//        } catch (IOException e) {
//            log.error("请求{}异常：", url, e);
//        }
//        return null;
//    }
//
//    /**
//     * @param url
//     * @param body
//     * @return
//     */
//    public static String postBody(String url, String body) {
//        try {
//            Connection.Response response = Jsoup.connect(url).followRedirects(true).ignoreHttpErrors(true)
//                    .requestBody(body).header("Content-Type", "application/json").ignoreContentType(true)
//                    .validateTLSCertificates(false).timeout(30000).maxBodySize(0).method(Connection.Method.POST).execute();
//            return response.body();
//        } catch (Exception e) {
//            log.error("请求{}异常：", url, e);
//        }
//        return null;
//    }
//}
