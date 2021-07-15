package tadlace.bookingapi.service

import tadlace.bookingapi.dto.MovieDTO

interface MovieService {

    fun createMovie(movieDTO:MovieDTO):MovieDTO

    fun getMovies():List<MovieDTO>

    fun getMovie(id: Int): MovieDTO

    fun updateMovie(movieDTO:MovieDTO): MovieDTO

    fun deleteMovie(id:Int)

    }