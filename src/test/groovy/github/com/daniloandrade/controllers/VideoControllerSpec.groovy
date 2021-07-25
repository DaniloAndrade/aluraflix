package github.com.daniloandrade.controllers

import github.com.daniloandrade.EmbeddedServerSpecification
import github.com.daniloandrade.fixtures.VideoFixture
import github.com.daniloandrade.models.Video
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus

class VideoControllerSpec extends EmbeddedServerSpecification implements VideoFixture {



    void "videos deve retorna todos os videos" () {

        given: 'videos existente'
        saveVideo(titulo)

        and: 'requisitando todos os livros'
        HttpRequest request = HttpRequest.GET("/videos")

        when:
        HttpResponse response = client.exchange(request, Argument.listOf(Video))

        then:
        response.status() == HttpStatus.OK

        when:
        List<Video> videos = response.body()

        then:
        videos.size() == 1
        videos.get(0).titulo == titulo


        cleanup:
        videoRepository.deleteAll()


        where:
        titulo = 'Lord of the Rings'
    }
}
