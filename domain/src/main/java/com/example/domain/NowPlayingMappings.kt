import com.example.data.model.MovieDbModel
import com.example.domain.entity.NowPlayingPosterModel

fun MovieDbModel.mapToEntity() =
    NowPlayingPosterModel(
        id = id,
        posterPath = posterPath,
        nextPage = nextPage
    )
