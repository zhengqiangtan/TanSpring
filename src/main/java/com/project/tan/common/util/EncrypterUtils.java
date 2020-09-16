package com.project.tan.common.util;

/**
 * 加解密工具类
 */
public class EncrypterUtils {

    private static final int SEED = 20140728;
    private static SecureEncrypter instance = new SecureEncrypter(SEED);

    public static SecureEncrypter getEncryperInstance() {
        return instance;
    }

    public static class SecureEncrypter {
        private int seed = 0;

        SecureEncrypter(int seed) {
            this.seed = seed;
        }

        public String encode(String input) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                int k = (int) input.charAt(i);
                //int code = new Integer(k^flag);
                builder.append("u").append(k ^ seed);
            }
            return builder.substring(1);
        }

        public String decode(String input) {
            String[] arr = input.split("u");
            StringBuilder builder = new StringBuilder();
            for (String str : arr) {
                int t = Integer.valueOf(str);
                t = t ^ seed;
                builder.append((char) t);
            }
            return builder.toString();
        }
    }
}
