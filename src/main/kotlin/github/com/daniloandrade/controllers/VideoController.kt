package github.com.daniloandrade.controllers

import github.com.daniloandrade.models.Video
import github.com.daniloandrade.repository.VideoRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/videos")
class VideoController (val videoRepository: VideoRepository) {

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun list() : List<Video> {
        return videoRepository.findAll()
            .toList()
    }
}