package github.com.daniloandrade

import github.com.daniloandrade.fixtures.ConfigurationFixture
import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

abstract class EmbeddedServerSpecification extends Specification implements ConfigurationFixture, LeakageDetector {



    @AutoCleanup
    @Shared
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer, getConfiguration())

    @AutoCleanup
    @Shared
    ApplicationContext applicationContext = embeddedServer.getApplicationContext()


    @AutoCleanup
    @Shared
    HttpClient httpClient = applicationContext.createBean(HttpClient, embeddedServer.URL)

    BlockingHttpClient getClient() {
        httpClient.toBlocking()
    }

    def cleanup() {
        assert !hasLeakage()
    }
}
