package com.project.tan.common.enums;

public enum EndpointTypeEnum implements EnumBase {
    /**
     * android
     */
    ANDROID("ANDROID", "Android SDK"),
    /**
     * ios
     */
    IOS("IOS", "IOS SDK"),
    /**
     * h5
     */
    H5("H5", "H5 SDK"),
    /**
     * others
     */
    OTHERS("OTHERS", "其他");

    private String code;
    private String message;

    EndpointTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
