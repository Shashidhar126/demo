package com.example.demo.repository;


import com.example.demo.entity.ConfigurationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConfigurationDataRepository extends JpaRepository<ConfigurationData, Long> {
    @Query("SELECT cd FROM ConfigurationData cd " +
            "JOIN FETCH cd.vehicleNotification vn " +
            "JOIN FETCH vn.speedLimitAlert sla " +
            "JOIN FETCH vn.geoFenceAlert gfa " +
            "JOIN FETCH cd.generalNotification gn " +
            "JOIN FETCH cd.communityNotification cn " +
            "WHERE cd.id = :id")
    ConfigurationData findConfigurationDataWithDetails(@Param("id") Long id);
    @Query("SELECT cd FROM ConfigurationData cd " +
            "JOIN FETCH cd.vehicleNotification vn " +
            "JOIN FETCH vn.speedLimitAlert sla " +
            "JOIN FETCH vn.geoFenceAlert gfa " +
            "JOIN FETCH cd.generalNotification gn " +
            "JOIN FETCH cd.communityNotification cn")
    List<ConfigurationData> findAllConfigurationData();
}

