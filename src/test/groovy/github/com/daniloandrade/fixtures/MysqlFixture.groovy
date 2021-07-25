package github.com.daniloandrade.fixtures

import github.com.daniloandrade.MySQL

trait MysqlFixture {


    Map<String, Object> getMysqlConfiguration() {
        if (MySQL.getMySQLContainer() == null || !MySQL.getMySQLContainer().isRunning()) {
            MySQL.init()
        }
        Map<String, Object> datasource = [
                'datasources.default.url'     : MySQL.mySQLContainer.getJdbcUrl(),
                'datasources.default.password': MySQL.mySQLContainer.getPassword(),
                'datasources.default.username': MySQL.mySQLContainer.getUsername(),
                'datasources.default.driverClassName': MySQL.mySQLContainer.getDriverClassName(),
                'datasources.default.dialect': 'MYSQL',

                'jpa.default.properties.hibernate.show_sql': 'true',
                'jpa.default.properties.hibernate.format_sql': 'true'
        ] as HashMap

        datasource
    }

}