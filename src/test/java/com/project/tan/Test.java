//package com.project.tan;
//
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorCompletionService;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * 下载图片和下载视频
// * https://cloud.tencent.com/developer/article/1332304
// */
//public class Test {
//
//    final ExecutorService pool = Executors.newFixedThreadPool(5);
//    final ExecutorCompletionService<Image> imageCompletionService = new ExecutorCompletionService<>(pool);
//    for(final String site :imageSites) {
//        completionService.submit(new Callable<Image>() {
//            @Override
//            public String call() throws Exception {
//                return IOUtils.toString(new URL("http://" + site), StandardCharsets.UTF_8);
//            }
//        });
//    }
//
//    final ExecutorCompletionService<Video> vidoeCompletionService = new ExecutorCompletionService<>(pool);
//    for(final String site :videoSites){
//        completionService.submit(new Callable<Video>() {
//            @Override
//            public String call() throws Exception {
//                return IOUtils.toString(new URL("http://" + site), StandardCharsets.UTF_8);
//            }
//        });
//    }
//
//    List<Image> images = new ArrayList<>();
//    for(int i = 0; i<topSites.size(); ++i) {
//        final Future<String> future = completionService.take();
//        try {
//            images.add(future.get());
//        } catch (ExecutionException e) {
//            log.warn("Error while downloading", e.getCause());
//        }
//    }
//
//    List<Video> videos = new ArrayList<>();
//    for( int i = 0; i<topSites.size(); ++i) {
//        final Future<String> future = completionService.take();
//        try {
//            videos.add(future.get());
//        } catch (ExecutionException e) {
//            log.warn("Error while downloading", e.getCause());
//        }
//    }// ... do process content
//}
