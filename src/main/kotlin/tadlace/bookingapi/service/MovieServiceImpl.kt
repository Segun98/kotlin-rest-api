package tadlace.bookingapi.service

import org.springframework.stereotype.Service
import tadlace.bookingapi.dto.MovieDTO
import tadlace.bookingapi.repository.MovieRepository
import tadlace.bookingapi.utils.exceptions.MovieException
import tadlace.bookingapi.utils.mapper.MovieMapper

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val MovieMapper: MovieMapper
) : MovieService {
    override fun createMovie(movieDTO: MovieDTO): MovieDTO {
        if (movieDTO.id != -1) throw IllegalArgumentException("Id must be null or -1")


        val movie = movieRepository.save(MovieMapper.toEntity(movieDTO))
        return MovieMapper.fromEntity(movie)

    }

    override fun getMovies(): List<MovieDTO> {
        val movies= movieRepository.findAll()
        val allMovies = mutableListOf<MovieDTO>()

        movies.forEach {
           allMovies.add(MovieMapper.fromEntity(it))
        }

        return allMovies
    }

    override fun getMovie(id: Int): MovieDTO {
         val optionalMovie = movieRepository.findById(id)

        val movie = optionalMovie.orElseThrow{ MovieException("MOVIE WITH ID $id does not exist") }

         return MovieMapper.fromEntity(movie)
    }

    override fun updateMovie(movieDTO: MovieDTO): MovieDTO {
        //check if movie exists
        val exists = movieRepository.existsById(movieDTO.id)
        if (!exists) throw MovieException("Movie does not exist")


        val movie = MovieMapper.toEntity(movieDTO)
        movieRepository.save(movie)
        return movieDTO
    }

    override fun deleteMovie(id: Int) {
        movieRepository.deleteById(id)
    }

}