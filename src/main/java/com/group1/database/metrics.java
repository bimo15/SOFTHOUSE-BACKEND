package com.group1.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by biswajeetmohanty on 21/11/16.
 */
public class metrics {

    @JsonProperty
    private Integer id;

    @JsonProperty
    @NotEmpty
    private String hostname;

    @JsonProperty
    @NotNull
    private Date time;

    @JsonProperty
    @NotNull
    private Float free;

    @JsonProperty
    @NotNull
    private Float used;

    @JsonProperty
    @NotEmpty
    private String type;

    public metrics() {}

    public metrics(Integer id, String hostname, Date time, Float used, Float free, String type) {
        this.id = id;
        this.hostname = hostname;
        this.time = time;
        this.free = free;
        this.used = used;
        this.type = type;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getFree() {
        return free;
    }

    public void setFree(Float free) {
        this.free = free;
    }

    public Float getUsed() {
        return used;
    }

    public void setUsed(Float used) {
        this.used = used;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


