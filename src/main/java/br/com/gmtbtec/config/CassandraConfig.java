package br.com.gmtbtec.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    static final Logger LOGGER = LoggerFactory.getLogger(CassandraConfig.class);

    @Value("${cassandra.keyspace}")
    private String keySpace;

    @Value("${cassandra.dataCenter}")
    private String dataCenter;

    @Value("${cassandra.contactpoints}")
    private String contactPoints;

    @Value("${cassandra.port}")
    private int port;

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }


    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"br.com.gmtbtec.model"};
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        LOGGER.info("KeySpace: " + keySpace);
        LOGGER.info("DataCenter: " + dataCenter);
        LOGGER.info("Port: " + port);
        LOGGER.info("SchemaAction: " + getSchemaAction().toString());

        Arrays.stream(getEntityBasePackages())
                .forEach(entity -> LOGGER.info("EntityBasePackages: " + entity));

        DataCenterReplication dataCenterReplication = DataCenterReplication.of(dataCenter, 1);

        return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(keySpace)
                .ifNotExists()
                .with(KeyspaceOption.REPLICATION)
                .withNetworkReplication(dataCenterReplication)
                .withSimpleReplication());
    }
}
