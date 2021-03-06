package com.group1;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by biswajeetmohanty on 21/11/16.
 */
public class metricsConfiguration extends Configuration implements AssetsBundleConfiguration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    DataSourceFactory getDataSourceFactory() {
        return this.dataSourceFactory;
    }

    public AssetsConfiguration getAssetsConfiguration() {
        return this.assets;
    }
}
