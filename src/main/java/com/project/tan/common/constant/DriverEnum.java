package com.project.tan.common.constant;

/**
 * @Author zhengqiang.tan
 * @Date 2020/9/16 3:56 PM
 * @Version 1.0
 */
public enum DriverEnum {
    MYSQL("mysql", "com.mysql.cj.jdbc.Driver"),
    POSTGRESQL("postgresql", "org.postgresql.Driver"),
    ORACLE("oracle", "oracle.jdbc.driver.OracleDriver"),
    MONGO("mongo", "org.mongodb:mongo-java-driver"),
    ELASTICSEARCH("elasticsearch", ""),
    CLICKHOUSE("clickhouse", "ru.yandex.clickhouse.ClickHouseDriver"),
    DEFAULT("default", "");

    private String name;
    private String driver;

    DriverEnum(String name, String driver) {
        this.name = name;
        this.driver = driver;
    }

    public String getName() {
        return this.name;
    }

    public String getDriver() {
        return this.driver;
    }

    public static DriverEnum getDriver(String name) {
        for (DriverEnum driverEnum : DriverEnum.values()) {
            if (driverEnum.getName().equals(name)) {
                return driverEnum;
            }
        }
        return DriverEnum.DEFAULT;
    }
}