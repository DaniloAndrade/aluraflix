package github.com.daniloandrade.fixtures

import github.com.daniloandrade.models.Video
import github.com.daniloandrade.repository.VideoRepository

trait VideoFixture {

    abstract VideoRepository getVideoRepository()

    Video saveVideo(String titulo = 'video 1', String descricao = "descricao", String url = "www.test.video") {
        Video author = new Video(0, titulo, descricao, url)
        videoRepository.save(author)

        author
    }

//    CreateAuthorRequest createAuthorRequest(String name = 'Stephen King') {
//        new CreateAuthorRequest(name)
//    }

}