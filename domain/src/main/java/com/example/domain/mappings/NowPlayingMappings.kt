import com.example.data.model.MovieDbModel

fun MovieDbModel.mapToUI() =
    NowPlayingPosterModel(
        id = id,
        posterPath = posterPath
    )
