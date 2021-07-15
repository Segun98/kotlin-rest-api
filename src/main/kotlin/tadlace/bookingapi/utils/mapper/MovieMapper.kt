package tadlace.bookingapi.utils.mapper

import org.springframework.stereotype.Service
import tadlace.bookingapi.dto.MovieDTO
import tadlace.bookingapi.entity.Movie

@Service
 class MovieMapper:Mapper<MovieDTO, Movie> {
    override fun fromEntity(entity: Movie): MovieDTO= MovieDTO(
            entity.id,
            entity.name,
            entity.rating
        )

    override fun toEntity(domain: MovieDTO): Movie = Movie(
        domain.id,
        domain.name,
        domain.rating
    )
}