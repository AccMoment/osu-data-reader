package osu.model

data class OsuCollectionList(
    val version:Int,
    val collections:List<OsuCollection>
)

data class OsuCollection(
    val name:String?,
    val beatmaps:List<Beatmap>
)
