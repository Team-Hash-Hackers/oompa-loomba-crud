package com.napptilus.willywonka.config.flyway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfoService;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

import java.util.Arrays;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Data Migration Object
 */
public class DataMigration implements FlywayMigrationStrategy {

    /**
     * Poperty Logger
     */
    private final Logger LOG = LogManager.getLogger(this.getClass());

    /**
     * migration method
     * @param flyway flyway
     */
    @Override
    public void migrate(Flyway flyway) {
        flyway.repair();
        flyway.migrate();
        flyway.validate();
        this.prettyDisplay(flyway.info());
    }

    /**
     * pretty display method
     * @param migrationInfo migrationinfoservice
     */
    private void prettyDisplay(final MigrationInfoService migrationInfo) {
        LOG.info("DB Flyway - Pretty Display");
        Arrays.stream(migrationInfo.all())
                .forEach(info -> LOG.info("Version: {} Description: {} Type: {} Installed By: {} Script Name: {} Status: {}", info.getVersion(), info.getDescription(), info.getType(), info.getInstalledBy(), info.getScript(), info.getState()));
    }

}
