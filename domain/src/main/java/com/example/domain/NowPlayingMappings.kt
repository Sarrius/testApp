import com.example.data.model.MovieDbModel
import com.example.domain.entity.NowPlayingMovieExtendedModel
import com.example.domain.entity.NowPlayingMovieModel

fun MovieDbModel.mapToEntity() =
    NowPlayingMovieModel(
        id = id,
        posterPath = posterPath,
        nextPage = nextPage
    )

fun MovieDbModel.mapToExtendedEntity() =
    NowPlayingMovieExtendedModel(
        id = id,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount
        )
