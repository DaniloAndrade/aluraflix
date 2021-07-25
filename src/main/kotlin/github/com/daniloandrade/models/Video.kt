package github.com.daniloandrade.models

import javax.persistence.*

@Entity
@Table(name ="videos")
data class Video(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var titulo: String,
    var descricao: String,
    var url: String
)
