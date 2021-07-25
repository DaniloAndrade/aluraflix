package github.com.daniloandrade

import github.com.daniloandrade.fixtures.RepositoryFixture

trait LeakageDetector extends RepositoryFixture {

    boolean hasLeakage() {
        (
            videoRepository.count() > 0
        )
    }

}