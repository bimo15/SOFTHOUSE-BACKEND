package com.group1;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.group1.database.metricsDAO;
import com.group1.process.metricsProcess;
import com.group1.process.metricsProcessDBImpl;
import com.group1.resource.metricsResource;
import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;

/**
 * Created by biswajeetmohanty on 21/11/16.
 */
public class metricsApplication extends Application<metricsConfiguration> {

    @Override
    public void run(metricsConfiguration configuration, Environment environment) throws Exception {
        final Server h2db = Server.createWebServer("-webDaemon");
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        // h2
        h2db.start();

        // data access objects
        final metricsDAO metricDAO = dbi.onDemand(metricsDAO.class);

        // tables
        metricDAO.createTable();

        // processes
        metricsProcess metricProcess = new metricsProcessDBImpl(metricDAO);

        // resources
        metricsResource metricResource = new metricsResource(metricProcess);

        // environment
        environment.jersey().register(metricResource);
    }

    @Override
    public void initialize(Bootstrap<metricsConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new metricsApplication().run(args);
    }

}
