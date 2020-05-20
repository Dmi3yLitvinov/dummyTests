package dummy.psql;

import org.testcontainers.containers.PostgreSQLContainer;

public class DummyPostgreSQLContainer extends PostgreSQLContainer<DummyPostgreSQLContainer> {

    private static final String IMAGE = "postgres:9.6-alpine";

    private static DummyPostgreSQLContainer container;

    private DummyPostgreSQLContainer() {
        super(IMAGE);
    }

    public static DummyPostgreSQLContainer getInstance(){
        if (container == null) {
            container = new DummyPostgreSQLContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }
}
