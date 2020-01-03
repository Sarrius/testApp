import com.example.data.model.MovieDbModel
import com.example.data.model.NowPlayingPosterModel

fun MovieDbModel.mapToEntity() =
    NowPlayingPosterModel(
        id = id,
        posterPath = posterPath,
        page = page
    )
