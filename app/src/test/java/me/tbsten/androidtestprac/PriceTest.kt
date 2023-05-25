package me.tbsten.androidtestprac

import org.junit.Test

class PriceTest {
    @Test
    fun `¥1200の商品を3個買うと送料¥400込みで料金が¥4000になる`() {
        val item = Item(
            id = "A001",
            name = "うにぐり",
            price = 1200,
        )
        val count = 3
        val expectedPrice = 4000

        val resultPrice = calcPriceWithPostage(item, count)
        assert(resultPrice == expectedPrice)
    }

    @Test
    fun `¥1000の商品を6個買うと送料が¥0になり料金が¥6000になる`() {
        val item = Item(
            id = "A002",
            name = "にら",
            price = 1000,
        )
        val count = 6
        val expectedPrice = 6000

        val resultPrice = calcPriceWithPostage(item, count)
        assert(resultPrice == expectedPrice)
    }
}