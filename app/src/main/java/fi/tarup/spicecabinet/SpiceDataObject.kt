package fi.tarup.spicecabinet

data class SpiceDataObject (
        val title: String,
        val color_code: String,
        val pages: DataPages
) {
    data class DataPages (
            val wiki: PageWiki,
            val recipe: PageRecipe
    )

    data class PageWiki (
        val description: String
    )

    data class PageRecipe (
        val title: String,
        val ingredients: String,
        val steps: String
    )
}
