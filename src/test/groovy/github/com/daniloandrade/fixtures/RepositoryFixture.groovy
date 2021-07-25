package github.com.daniloandrade.fixtures

import github.com.daniloandrade.repository.VideoRepository
import io.micronaut.context.ApplicationContext

trait RepositoryFixture {

    abstract ApplicationContext getApplicationContext()

    VideoRepository getVideoRepository() {
        applicationContext.getBean(VideoRepository)
    }

}