package fi.tarup.spicecabinet

data class SpiceDataObject (
        val title: String,
        val color: String,
        val url: String,
        val pages: DataPages
) {
    data class DataPages (
            val first: PageFirst,
            val wiki: PageWiki,
            val images: PageImages,
            val recipe: PageRecipe
    )

    data class PageFirst (
            val first_image: String
    )

    data class PageWiki (
        val description: String,
        val link_url: String
    )

    data class PageImages (
        val large: String,
        val small: String,
        val link: String
    )

    data class PageRecipe (
        val ingredients: String,
        val image: String,
        val steps: String,
        val link_url: String
    )
}
