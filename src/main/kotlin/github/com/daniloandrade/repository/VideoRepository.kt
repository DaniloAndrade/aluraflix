package github.com.daniloandrade.repository

import github.com.daniloandrade.models.Video
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface VideoRepository : CrudRepository<Video, Long> {
}