package com.group1.process;

import com.group1.database.metrics;
import com.group1.database.metricsDAO;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by biswajeetmohanty on 21/11/16.
 */
public class metricsProcessDBImpl implements metricsProcess {
    private metricsDAO metricDAO;

    public metricsProcessDBImpl(metricsDAO metricDAO) {
        this.metricDAO = metricDAO;
    }

    @Override
    public List<metrics> list() {
        return this.metricDAO.list();
    }

    @Override
    public metrics create(metrics metric) {
        return this.metricDAO.findBy(this.metricDAO.create(metric));
    }


    @Override
    public List<metrics> find(String hostname, String type) throws NotFoundException {
        return Optional
                .ofNullable(this.metricDAO.findByHostname(hostname,type))
                .orElseThrow(() -> new NotFoundException("data does not exist"));
    }

    @Override
    public void delete(String hostname, String type) {
        this.metricDAO.deleteBy(hostname, type);
    }
}
