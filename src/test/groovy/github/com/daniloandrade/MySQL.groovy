package github.com.daniloandrade

import org.testcontainers.containers.MySQLContainer

class MySQL {

    static MySQLContainer mySQLContainer

    static init() {
        if (mySQLContainer == null) {
            mySQLContainer = new MySQLContainer('mysql:latest')
            mySQLContainer.addEnv("testcontainers.reuse.enable", "true")
            // Reuse container between tests instead of starting a new one per execution
            mySQLContainer
                .withDatabaseName("aluraflixtest")

                    .withReuse(true)
                    .withNetwork(null)
                    .withLabel("github.com.daniloandrade", "mySqlTescontainersReuse")
               .start()
        }
    }
}
