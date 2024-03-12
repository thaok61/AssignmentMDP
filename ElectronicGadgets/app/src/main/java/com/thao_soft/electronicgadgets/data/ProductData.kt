package com.thao_soft.electronicgadgets.data

import com.thao_soft.electronicgadgets.model.Product

object ProductData {
    val list = mutableListOf<Product>()
    val cart = mutableListOf<Product>()

    init {
        populateData()
    }
    private fun populateData() {
        list.add(
            Product(
                "Iphone 11",
                "64GB",
                500.0,
                "https://cdn.alloallo.media/catalog/product/apple/iphone/iphone-11/iphone-11-black-front.jpg",
                "https://cdn2.vectorstock.com/i/1000x1000/43/41/apple-logo-computer-ipad-iphone-software-vector-19944341.jpg"
            )
        )

        list.add(
            Product(
                "Iphone 12",
                "128GB",
                700.0,
                "https://m.media-amazon.com/images/I/61kYyYE90qL.jpg",
                "https://cdn2.vectorstock.com/i/1000x1000/43/41/apple-logo-computer-ipad-iphone-software-vector-19944341.jpg"
            )
        )


        list.add(
            Product(
                "Iphone 13",
                "256GB",
                800.0,
                "https://www.apple.com/newsroom/images/product/iphone/standard/Apple_iphone13_hero_09142021_inline.jpg.large.jpg",
                "https://cdn2.vectorstock.com/i/1000x1000/43/41/apple-logo-computer-ipad-iphone-software-vector-19944341.jpg"
            )
        )


        list.add(
            Product(
                "Iphone 14",
                "256GB",
                900.0,
                "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-14-3.jpg",
                "https://cdn2.vectorstock.com/i/1000x1000/43/41/apple-logo-computer-ipad-iphone-software-vector-19944341.jpg"
            )
        )


        list.add(
            Product(
                "Iphone 15",
                "64GB",
                1000.0,
                "https://media.cnn.com/api/v1/images/stellar/prod/i-phone-15-horiz.jpg",
                "https://cdn2.vectorstock.com/i/1000x1000/43/41/apple-logo-computer-ipad-iphone-software-vector-19944341.jpg"
            )
        )


        list.add(
            Product(
                "Macbook 2020",
                "13 Inch\n256GB",
                1500.0,
                "https://www.apple.com/newsroom/images/product/mac/standard/Apple_new-macbook-air-wallpaper-screen_03182020_big.jpg.large.jpg",
                "https://cdn2.vectorstock.com/i/1000x1000/43/41/apple-logo-computer-ipad-iphone-software-vector-19944341.jpg"
            )
        )


        list.add(
            Product(
                "Macbook 2021",
                "13 Inch\n256GB",
                1500.0,
                "https://www.apple.com/newsroom/images/product/mac/standard/Apple_new-macbook-air-wallpaper-screen_03182020_big.jpg.large.jpg",
                "https://cdn2.vectorstock.com/i/1000x1000/43/41/apple-logo-computer-ipad-iphone-software-vector-19944341.jpg"
            )
        )


        list.add(
            Product(
                "Macbook Air 2022",
                "14 Inch\n256GB",
                1000.0,
                "https://www.apple.com/newsroom/images/product/mac/standard/Apple_new-macbook-air-wallpaper-screen_03182020_big.jpg.large.jpg",
                "https://cdn2.vectorstock.com/i/1000x1000/43/41/apple-logo-computer-ipad-iphone-software-vector-19944341.jpg"
            )
        )
    }
}