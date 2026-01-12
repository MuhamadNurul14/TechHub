package com.techhub.app.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Smartphone(
    val id: Int,
    val name: String,
    val brand: String,
    val imageUrl: String,
    val price: String,
    val ram: String,
    val storage: String,
    val processor: String,
    val display: String,
    val camera: String,
    val battery: String,
    val os: String,
    val releaseYear: Int,
    val colors: List<String>,
    val description: String
) : Parcelable

object SmartphoneData {
    fun getAllSmartphones(): ArrayList<Smartphone> {
        return arrayListOf(
            Smartphone(
                id = 1,
                name = "Galaxy S24 Ultra",
                brand = "Samsung",
                imageUrl = "https://images.unsplash.com/photo-1610945415295-d9bbf067e59c?w=500&h=500&fit=crop",
                price = "Rp 21.999.000",
                ram = "12GB",
                storage = "256GB / 512GB / 1TB",
                processor = "Snapdragon 8 Gen 3",
                display = "6.8\" Dynamic AMOLED 2X, 120Hz",
                camera = "200MP + 50MP + 12MP + 10MP",
                battery = "5000mAh, Fast Charging 45W",
                os = "Android 14, One UI 6.1",
                releaseYear = 2024,
                colors = listOf("Titanium Black", "Titanium Gray", "Titanium Violet"),
                description = "Flagship Samsung dengan S Pen terintegrasi, kamera 200MP, dan performa maksimal untuk produktivitas dan gaming."
            ),
            Smartphone(
                id = 2,
                name = "iPhone 15 Pro Max",
                brand = "Apple",
                imageUrl = "https://images.unsplash.com/photo-1678652197831-2d180705cd2c?w=500&h=500&fit=crop",
                price = "Rp 23.999.000",
                ram = "8GB",
                storage = "256GB / 512GB / 1TB",
                processor = "A17 Pro Bionic",
                display = "6.7\" Super Retina XDR OLED, 120Hz ProMotion",
                camera = "48MP + 12MP + 12MP (Telephoto 5x)",
                battery = "4422mAh, MagSafe Charging",
                os = "iOS 17",
                releaseYear = 2023,
                colors = listOf("Natural Titanium", "Blue Titanium", "White Titanium", "Black Titanium"),
                description = "iPhone premium dengan chip A17 Pro, body titanium, dan kamera telephoto 5x optical zoom untuk fotografi profesional."
            ),
            Smartphone(
                id = 3,
                name = "Xiaomi 14 Pro",
                brand = "Xiaomi",
                imageUrl = "https://images.unsplash.com/photo-1598327105666-5b89351aff97?w=500&h=500&fit=crop",
                price = "Rp 14.999.000",
                ram = "12GB / 16GB",
                storage = "256GB / 512GB",
                processor = "Snapdragon 8 Gen 3",
                display = "6.73\" AMOLED, 120Hz, 3000 nits",
                camera = "50MP Leica (Wide) + 50MP (Telephoto) + 50MP (Ultra-wide)",
                battery = "4880mAh, 120W HyperCharge",
                os = "Android 14, HyperOS",
                releaseYear = 2024,
                colors = listOf("Black", "White", "Titanium"),
                description = "Smartphone flagship dengan kolaborasi kamera Leica, charging super cepat 120W, dan layar AMOLED brightness tinggi."
            ),
            Smartphone(
                id = 4,
                name = "Galaxy A54 5G",
                brand = "Samsung",
                imageUrl = "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=500&h=500&fit=crop",
                price = "Rp 5.999.000",
                ram = "8GB",
                storage = "128GB / 256GB",
                processor = "Exynos 1380",
                display = "6.4\" Super AMOLED, 120Hz",
                camera = "50MP + 12MP + 5MP",
                battery = "5000mAh, 25W Fast Charging",
                os = "Android 13, One UI 5.1",
                releaseYear = 2023,
                colors = listOf("Awesome Violet", "Awesome Graphite", "Awesome Lime"),
                description = "Smartphone mid-range terbaik Samsung dengan layar Super AMOLED, kamera 50MP, dan dukungan 5G dengan harga terjangkau."
            ),
            Smartphone(
                id = 5,
                name = "OPPO Find X6 Pro",
                brand = "OPPO",
                imageUrl = "https://static.tek.id/2023/12/05/64056/penerus-oppo-find-x6-pro-dikabarkan-akan-rilis-dengan-kamera-memukau-SOxJLDzlGf.jpeg",
                price = "Rp 16.999.000",
                ram = "12GB / 16GB",
                storage = "256GB / 512GB",
                processor = "Snapdragon 8 Gen 2",
                display = "6.82\" AMOLED LTPO, 120Hz",
                camera = "50MP (Wide) + 50MP (Ultra-wide) + 50MP (Periscope)",
                battery = "5000mAh, 100W SuperVOOC",
                os = "Android 13, ColorOS 13.1",
                releaseYear = 2023,
                colors = listOf("Black", "Brown Leather"),
                description = "Flagship OPPO dengan triple 50MP Hasselblad camera, charging 100W, dan layar LTPO untuk efisiensi baterai maksimal."
            ),
            Smartphone(
                id = 6,
                name = "Vivo X100 Pro",
                brand = "Vivo",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4zHcN97tGByz4Q9Fuf2PSdUZkf3UyhfbY6g&s",
                price = "Rp 13.999.000",
                ram = "12GB / 16GB",
                storage = "256GB / 512GB / 1TB",
                processor = "MediaTek Dimensity 9300",
                display = "6.78\" AMOLED LTPO, 120Hz",
                camera = "50MP ZEISS (Wide) + 50MP (Ultra-wide) + 50MP (Telephoto)",
                battery = "5400mAh, 100W FlashCharge",
                os = "Android 14, Funtouch OS 14",
                releaseYear = 2024,
                colors = listOf("Asteroid Black", "Sunset Orange"),
                description = "Smartphone fotografi dengan kamera ZEISS, chip Dimensity 9300 powerful, dan baterai jumbo 5400mAh dengan fast charging."
            ),
            Smartphone(
                id = 7,
                name = "iPhone 14",
                brand = "Apple",
                imageUrl = "https://t-mobile.scene7.com/is/image/Tmusprod/Apple-iPhone-14-Pro-Max-Space-Black-frontimage",
                price = "Rp 13.999.000",
                ram = "6GB",
                storage = "128GB / 256GB / 512GB",
                processor = "A15 Bionic",
                display = "6.1\" Super Retina XDR OLED",
                camera = "12MP Dual Camera (Wide + Ultra-wide)",
                battery = "3279mAh, MagSafe & Wireless Charging",
                os = "iOS 16 (upgradable to iOS 17)",
                releaseYear = 2022,
                colors = listOf("Midnight", "Purple", "Starlight", "Blue", "Red"),
                description = "iPhone standar dengan chip A15 Bionic, kamera ganda berkualitas, dan ekosistem iOS yang seamless untuk pengguna Apple."
            ),
            Smartphone(
                id = 8,
                name = "Redmi Note 13 Pro+",
                brand = "Xiaomi",
                imageUrl = "https://images.unsplash.com/photo-1580910051074-3eb694886505?w=500&h=500&fit=crop",
                price = "Rp 4.999.000",
                ram = "8GB / 12GB",
                storage = "256GB / 512GB",
                processor = "MediaTek Dimensity 7200-Ultra",
                display = "6.67\" AMOLED, 120Hz, 1800 nits",
                camera = "200MP (Wide) + 8MP (Ultra-wide) + 2MP (Macro)",
                battery = "5000mAh, 120W HyperCharge",
                os = "Android 13, MIUI 14",
                releaseYear = 2024,
                colors = listOf("Midnight Black", "Fusion Purple", "Moonlight White"),
                description = "Best value smartphone dengan kamera 200MP, charging super cepat 120W, dan layar AMOLED cerah di segmen menengah."
            ),
            Smartphone(
                id = 9,
                name = "Realme GT 5 Pro",
                brand = "Realme",
                imageUrl = "https://images.unsplash.com/photo-1574944985070-8f3ebc6b79d2?w=500&h=500&fit=crop",
                price = "Rp 8.999.000",
                ram = "12GB / 16GB",
                storage = "256GB / 512GB / 1TB",
                processor = "Snapdragon 8 Gen 3",
                display = "6.78\" AMOLED LTPO, 144Hz",
                camera = "50MP Sony IMX890 + 50MP Telephoto + 8MP Ultra-wide",
                battery = "5400mAh, 100W SuperVOOC",
                os = "Android 14, Realme UI 5.0",
                releaseYear = 2024,
                colors = listOf("Mars Orange", "Moon White"),
                description = "Flagship killer dengan Snapdragon 8 Gen 3, layar 144Hz untuk gaming, dan sistem kamera Sony IMX890 berkualitas tinggi."
            ),
            Smartphone(
                id = 10,
                name = "OnePlus 12",
                brand = "OnePlus",
                imageUrl = "https://images.unsplash.com/photo-1598327105666-5b89351aff97?w=500&h=500&fit=crop",
                price = "Rp 12.999.000",
                ram = "12GB / 16GB",
                storage = "256GB / 512GB",
                processor = "Snapdragon 8 Gen 3",
                display = "6.82\" AMOLED LTPO, 120Hz, 4500 nits peak",
                camera = "50MP Hasselblad (Wide) + 64MP (Telephoto 3x) + 48MP (Ultra-wide)",
                battery = "5400mAh, 100W SUPERVOOC",
                os = "Android 14, OxygenOS 14",
                releaseYear = 2024,
                colors = listOf("Flowy Emerald", "Silky Black"),
                description = "OnePlus flagship dengan Hasselblad camera, layar super bright 4500 nits, dan fast charging 100W untuk performa maksimal."
            ),
            Smartphone(
                id = 11,
                name = "Galaxy Z Flip 5",
                brand = "Samsung",
                imageUrl = "https://images.unsplash.com/photo-1610945415295-d9bbf067e59c?w=500&h=500&fit=crop",
                price = "Rp 15.999.000",
                ram = "8GB",
                storage = "256GB / 512GB",
                processor = "Snapdragon 8 Gen 2",
                display = "6.7\" Foldable Dynamic AMOLED 2X, 120Hz + 3.4\" Cover Screen",
                camera = "12MP Dual Camera (Wide + Ultra-wide)",
                battery = "3700mAh, 25W Fast Charging",
                os = "Android 13, One UI 5.1.1",
                releaseYear = 2023,
                colors = listOf("Mint", "Graphite", "Cream", "Lavender"),
                description = "Smartphone lipat dengan desain compact, cover screen besar 3.4 inci, dan FlexCam untuk foto kreatif berbeda sudut."
            ),
            Smartphone(
                id = 12,
                name = "POCO F5 Pro",
                brand = "Xiaomi",
                imageUrl = "https://images.unsplash.com/photo-1585060544812-6b45742d762f?w=500&h=500&fit=crop",
                price = "Rp 6.499.000",
                ram = "8GB / 12GB",
                storage = "256GB / 512GB",
                processor = "Snapdragon 8+ Gen 1",
                display = "6.67\" AMOLED, 120Hz, 1400 nits",
                camera = "64MP (Wide) + 8MP (Ultra-wide) + 2MP (Macro)",
                battery = "5160mAh, 67W Turbo Charging",
                os = "Android 13, MIUI 14 for POCO",
                releaseYear = 2023,
                colors = listOf("Black", "White"),
                description = "Smartphone value terbaik dengan Snapdragon 8+ Gen 1 flagship chipset, baterai besar, dan charging cepat di harga terjangkau."
            )
        )
    }

    fun getSmartphoneById(id: Int): Smartphone? {
        return getAllSmartphones().find { it.id == id }
    }

    fun searchSmartphones(query: String): ArrayList<Smartphone> {
        val lowerQuery = query.lowercase()
        return ArrayList(getAllSmartphones().filter {
            it.name.lowercase().contains(lowerQuery) ||
                    it.brand.lowercase().contains(lowerQuery) ||
                    it.processor.lowercase().contains(lowerQuery) ||
                    it.description.lowercase().contains(lowerQuery)
        })
    }

    fun getSmartphonesByBrand(brand: String): ArrayList<Smartphone> {
        return ArrayList(getAllSmartphones().filter { it.brand == brand })
    }

    fun getAllBrands(): List<String> {
        return getAllSmartphones().map { it.brand }.distinct().sorted()
    }
}
