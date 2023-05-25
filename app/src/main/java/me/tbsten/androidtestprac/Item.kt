package me.tbsten.androidtestprac

data class Item(
    val id: String,
    val name: String,
    val price: Int,
)

const val POSTAGE = 400
fun calcPriceWithPostage(item: Item, count: Int): Int {
    val basePrice = item.price * count
    if (basePrice >= 5000) return basePrice
    return basePrice + POSTAGE
}
