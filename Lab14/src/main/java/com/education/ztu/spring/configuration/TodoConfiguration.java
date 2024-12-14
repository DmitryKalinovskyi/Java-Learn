package com.education.ztu.spring.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class TodoConfiguration {

    private String title;
    private String updatePageTitle;

    public String getTitle() {
        return title;
    }

    public String getUpdatePageTitle() {return updatePageTitle; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUpdatePageTitle(String updatePageTitle) {this.updatePageTitle = updatePageTitle;}
}
