package com.group1.database;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)

public interface metricsDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS metric(id int auto_increment primary key, hostname varchar(255), time timestamp, free float, used float, type varchar(12))")
    void createTable();

    @SqlUpdate("INSERT INTO `metric`(hostname,time,free,used,type) VALUES(:hostname, :time, :free, :used, :type)")
    @GetGeneratedKeys
    Integer create(@BindBean metrics metric);

    @SqlQuery("SELECT * FROM `metric`")
    List<metrics> list();

    @SqlQuery("SELECT * FROM `metric` WHERE hostname = :hostname AND type = :type")
    List<metrics> findByHostname(@Bind("hostname") String hostname, @Bind("type") String type);


    @SqlQuery("SELECT * FROM `metric` WHERE id = :id")
    metrics findBy(@Bind("id") Integer id);


    @SqlUpdate("DELETE FROM `metric` WHERE hostname = :hostname AND type = :type")
    void deleteBy(@Bind("hostname") String hostname, @Bind("type") String type);

    @SqlUpdate("DELETE FROM `metric` WHERE hostname = :hostname")
    void deleteByHostname(@Bind("hostname") String hostname);

    @SqlUpdate("UPDATE `metric` SET hostname = :hostname, time = :time, free = :free, used = :used, type = :type WHERE id = :id")
    void update(@BindBean metrics metric);

}
