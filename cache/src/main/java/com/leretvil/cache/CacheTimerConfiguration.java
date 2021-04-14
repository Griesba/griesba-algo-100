package com.leretvil.cache;

public class CacheTimerConfiguration {
    private String xmlPropertyName;
    private Long defaultReloadTime;
    private boolean adminTimerClassInitsCheckParserWhenReload;

    public CacheTimerConfiguration(String xmlPropertyName, Long defaultReloadTime) {
        this.xmlPropertyName = xmlPropertyName;
        this.defaultReloadTime = defaultReloadTime;
        this.adminTimerClassInitsCheckParserWhenReload = false;
    }

    public CacheTimerConfiguration(String xmlPropertyName, Long defaultReloadTime, boolean adminTimerClassInitsCheckParserWhenReload) {
        this.xmlPropertyName = xmlPropertyName;
        this.defaultReloadTime = defaultReloadTime;
        this.adminTimerClassInitsCheckParserWhenReload = adminTimerClassInitsCheckParserWhenReload;
    }

    public String getXmlPropertyName() {
        return xmlPropertyName;
    }

    public void setXmlPropertyName(String xmlPropertyName) {
        this.xmlPropertyName = xmlPropertyName;
    }

    public Long getDefaultReloadTime() {
        return defaultReloadTime;
    }

    public void setDefaultReloadTime(Long defaultReloadTime) {
        this.defaultReloadTime = defaultReloadTime;
    }

    public boolean isAdminTimerClassInitsCheckParserWhenReload() {
        return adminTimerClassInitsCheckParserWhenReload;
    }

    public void setAdminTimerClassInitsCheckParserWhenReload(boolean adminTimerClassInitsCheckParserWhenReload) {
        this.adminTimerClassInitsCheckParserWhenReload = adminTimerClassInitsCheckParserWhenReload;
    }
}
