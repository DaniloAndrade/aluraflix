package github.com.daniloandrade.fixtures

trait ConfigurationFixture implements MysqlFixture {

    Map<String, Object> getConfiguration() {
        Map<String, Object> m = [ :
        ] as HashMap

        if (getSpecName()) {
            m['spec.name'] = getSpecName()
        }



        Map<String, Object> datasource = getMysqlConfiguration()
        println("datasource config " + datasource)
        m += datasource

        m
    }

    String getSpecName() {
        null
    }

    boolean mockSecurityServiceEnabled() {
        true
    }

}