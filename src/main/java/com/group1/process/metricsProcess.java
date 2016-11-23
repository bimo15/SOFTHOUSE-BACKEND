package com.group1.process;

import com.group1.database.metrics;

import javax.ws.rs.NotFoundException;
import java.util.List;


public interface metricsProcess {
    List<metrics> list();

    metrics create(metrics metric);

    List<metrics> find(String hostname, String type) throws NotFoundException;

    void delete(String hostname, String type);
}
