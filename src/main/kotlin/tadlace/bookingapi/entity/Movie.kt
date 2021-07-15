package tadlace.bookingapi.entity

import javax.persistence.*


@Entity
@Table(name = "movie")
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val rating: String
)
