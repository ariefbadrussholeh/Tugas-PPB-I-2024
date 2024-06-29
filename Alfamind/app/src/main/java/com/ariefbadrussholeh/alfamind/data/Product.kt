package com.ariefbadrussholeh.alfamind.data

import androidx.compose.ui.res.painterResource
import com.ariefbadrussholeh.alfamind.R

data class Product(
    val image: Int,
    val name: String,
    val stock: Int,
    val price: Double,
    val discountedPrice: Double,
    val brand: String,
    val category: String,
    val code: String,
    val dimension: String,
    val weight: String,
    val description: String
)

val discountedProducts = listOf<Product>(
    Product(
        image = R.drawable.dp_1,
        name = "Lemari Pakaian Sliding LSD Marino",
        stock = 10,
        price = 2500000.0,
        discountedPrice = 2000000.0,
        brand = "Marino",
        category = "Furniture",
        code = "LSDM123",
        dimension = "200x180x60 cm",
        weight = "50 kg",
        description = "Lemari pakaian sliding dengan desain modern dan elegan, cocok untuk berbagai jenis ruangan. Terbuat dari bahan berkualitas tinggi, tahan lama, dan mudah dibersihkan. Lemari ini dilengkapi dengan beberapa rak yang luas dan gantungan baju untuk menyimpan pakaian dengan rapi dan terorganisir."
    ),
    Product(
        image = R.drawable.dp_2,
        name = "EXPEDITION EXF6818MCBIPBA Jam Tangan Pria Black",
        stock = 20,
        price = 1500000.0,
        discountedPrice = 1200000.0,
        brand = "EXPEDITION",
        category = "Aksesoris",
        code = "EXF6818MCBIPBA",
        dimension = "Diameter 4.5 cm",
        weight = "150 g",
        description = "Jam tangan pria dari EXPEDITION dengan desain yang kokoh dan maskulin. Dilengkapi dengan fitur water resistant, chronograph, dan kalender. Strap terbuat dari bahan kulit asli yang nyaman di pergelangan tangan. Cocok untuk aktivitas sehari-hari maupun olahraga."
    ),
    Product(
        image = R.drawable.dp_3,
        name = "Yukata Custom YKT010 200 x 180 x 20",
        stock = 15,
        price = 3500000.0,
        discountedPrice = 3000000.0,
        brand = "Yukata",
        category = "Furniture",
        code = "YKT010",
        dimension = "200x180x20 cm",
        weight = "45 kg",
        description = "Yukata Custom YKT010 adalah kasur dengan kualitas premium yang menawarkan kenyamanan dan dukungan optimal untuk tidur nyenyak. Dengan desain custom yang dapat disesuaikan dengan kebutuhan, kasur ini dilengkapi dengan teknologi terbaru untuk meningkatkan kualitas tidur Anda."
    ),
    Product(
        image = R.drawable.dp_4,
        name = "Lemari Pakaian Sliding Minimalis Putih WSD Polo",
        stock = 8,
        price = 2750000.0,
        discountedPrice = 2250000.0,
        brand = "Polo",
        category = "Furniture",
        code = "WSDP123",
        dimension = "190x170x60 cm",
        weight = "48 kg",
        description = "Lemari pakaian sliding minimalis dengan warna putih elegan dari WSD Polo. Lemari ini memiliki desain yang sederhana namun modern, sangat cocok untuk melengkapi interior rumah Anda. Dilengkapi dengan ruang penyimpanan yang luas untuk pakaian dan aksesoris."
    ),
    Product(
        image = R.drawable.dp_5,
        name = "ALGA 3 Fold Bed Jacquard 100x200",
        stock = 12,
        price = 1200000.0,
        discountedPrice = 1000000.0,
        brand = "ALGA",
        category = "Furniture",
        code = "ALGABED100200",
        dimension = "100x200 cm",
        weight = "20 kg",
        description = "Kasur lipat tiga dari ALGA dengan bahan Jacquard yang lembut dan nyaman. Ideal untuk penggunaan di rumah maupun saat bepergian. Mudah dilipat dan disimpan, menjadikannya solusi praktis untuk ruang yang terbatas. Menyediakan kenyamanan tidur yang maksimal dengan dukungan yang baik."
    )
)

val mostSelled = listOf<Product>(
    Product(
        image = R.drawable.ms_1,
        name = "Ecentio Insulated Lunch Bag ILBE-0605 Purplish blue ET0206A00208 (CKK)",
        stock = 150,
        price = 120000.0,
        discountedPrice = 95000.0,
        brand = "Ecentio",
        category = "Lunch Bags",
        code = "ILBE-0605",
        dimension = "30x20x15 cm",
        weight = "500g",
        description = "Ecentio Insulated Lunch Bag ILBE-0605 adalah tas makan siang berkualitas tinggi dengan warna biru keunguan yang elegan. Didesain untuk menjaga makanan Anda tetap segar dan hangat. Cocok untuk dibawa ke kantor atau sekolah."
    ),
    Product(
        image = R.drawable.ms_2,
        name = "ECENTIO Lunch Box 4-compartment 4LBE-7301 Green ET0201A07302 (YGY)",
        stock = 200,
        price = 75000.0,
        discountedPrice = 60000.0,
        brand = "Ecentio",
        category = "Lunch Boxes",
        code = "4LBE-7301",
        dimension = "25x15x10 cm",
        weight = "400g",
        description = "ECENTIO Lunch Box 4-compartment adalah kotak makan siang dengan 4 kompartemen yang memungkinkan Anda memisahkan makanan. Berwarna hijau dan dibuat dari bahan berkualitas tinggi yang aman untuk makanan."
    ),
    Product(
        image = R.drawable.ms_3,
        name = "TARTARUGA MINI SHEET CRISPY SEAWEED HOT & SPICY FLAVOUR 3,2 gr x 12 pcs",
        stock = 300,
        price = 30000.0,
        discountedPrice = 25000.0,
        brand = "Tartaruga",
        category = "Snacks",
        code = "MINI-SHEET-12",
        dimension = "15x10x5 cm",
        weight = "40g",
        description = "TARTARUGA MINI SHEET CRISPY SEAWEED HOT & SPICY adalah camilan rumput laut renyah dengan rasa pedas yang menggugah selera. Dikemas dalam 12 pcs dengan berat total 3,2 gr per kemasan. Cocok untuk camilan sehat."
    ),
    Product(
        image = R.drawable.ms_4,
        name = "ARABACA-LINTONG",
        stock = 50,
        price = 150000.0,
        discountedPrice = 130000.0,
        brand = "Arabaca",
        category = "Coffee",
        code = "ARABACA-LINTONG",
        dimension = "20x10x5 cm",
        weight = "250g",
        description = "ARABACA-LINTONG adalah kopi berkualitas tinggi dari biji kopi pilihan. Dengan rasa yang kaya dan aroma yang menggoda, kopi ini akan menjadi favorit pecinta kopi sejati. Dikemas dengan baik untuk menjaga kesegaran."
    ),
    Product(
        image = R.drawable.ms_5,
        name = "Winn W900M - Regulator Pengunci Ganda Meter",
        stock = 100,
        price = 85000.0,
        discountedPrice = 75000.0,
        brand = "Winn",
        category = "Home Appliances",
        code = "W900M",
        dimension = "10x10x10 cm",
        weight = "300g",
        description = "Winn W900M adalah regulator gas dengan pengunci ganda dan meteran untuk keamanan ekstra. Didesain untuk memberikan kontrol yang tepat pada aliran gas. Ideal untuk digunakan di rumah tangga."
    )
)

val newProducts = listOf<Product>(
    Product(
        image = R.drawable.np_1,
        name = "OXONE PISAU DAPUR OX961",
        stock = 100,
        price = 75000.0,
        discountedPrice = 65000.0,
        brand = "Oxone",
        category = "Kitchenware",
        code = "OX961",
        dimension = "30x5x2 cm",
        weight = "200g",
        description = "OXONE PISAU DAPUR OX961 adalah pisau dapur berkualitas tinggi yang dirancang untuk memberikan potongan yang presisi. Pisau ini sangat cocok untuk segala jenis bahan makanan, dengan pegangan ergonomis yang nyaman digunakan."
    ),
    Product(
        image = R.drawable.np_2,
        name = "Suggo Wokpan 32 cm",
        stock = 50,
        price = 180000.0,
        discountedPrice = 160000.0,
        brand = "Suggo",
        category = "Cookware",
        code = "SWP32",
        dimension = "32x32x10 cm",
        weight = "1200g",
        description = "Suggo Wokpan 32 cm adalah wajan berkualitas premium dengan diameter 32 cm, cocok untuk memasak berbagai jenis masakan. Wajan ini terbuat dari bahan anti lengket yang memudahkan proses memasak dan pembersihan."
    ),
    Product(
        image = R.drawable.np_3,
        name = "MUKENA KHADIJAH",
        stock = 75,
        price = 250000.0,
        discountedPrice = 220000.0,
        brand = "Khadijah",
        category = "Religious Wear",
        code = "MKD123",
        dimension = "Free Size",
        weight = "500g",
        description = "MUKENA KHADIJAH adalah mukena berkualitas tinggi yang terbuat dari bahan lembut dan nyaman. Desainnya elegan dan sederhana, cocok untuk digunakan sehari-hari maupun untuk ibadah khusus. Tersedia dalam berbagai pilihan warna."
    ),
    Product(
        image = R.drawable.np_4,
        name = "ECENTIO Tumbler Sports 1000ml aluminum black ET0201A15801 (YGY)",
        stock = 200,
        price = 90000.0,
        discountedPrice = 80000.0,
        brand = "Ecentio",
        category = "Drinkware",
        code = "ET0201A15801",
        dimension = "10x10x30 cm",
        weight = "400g",
        description = "ECENTIO Tumbler Sports 1000ml adalah tumbler olahraga yang terbuat dari aluminium berkualitas tinggi. Kapasitas 1000ml membuatnya cocok untuk berbagai aktivitas olahraga. Desain warna hitam yang elegan dan modern."
    ),
    Product(
        image = R.drawable.np_5,
        name = "Tramontina - 2Pcs Table Spoons Set Ipanema Orange (CKK)",
        stock = 150,
        price = 50000.0,
        discountedPrice = 45000.0,
        brand = "Tramontina",
        category = "Cutlery",
        code = "TIS2O",
        dimension = "20x5x2 cm",
        weight = "150g",
        description = "Tramontina - 2Pcs Table Spoons Set Ipanema Orange adalah set sendok makan berkualitas dengan warna oranye yang cerah. Terbuat dari bahan stainless steel yang tahan lama dan mudah dibersihkan. Ideal untuk digunakan sehari-hari."
    )
)

val mostProfitable = listOf<Product>(
    Product(
        image = R.drawable.mp_1,
        name = "Yukata Sofabed Sumire",
        stock = 30,
        price = 2500000.0,
        discountedPrice = 2250000.0,
        brand = "Yukata",
        category = "Furniture",
        code = "YSF001",
        dimension = "200x150x20 cm",
        weight = "30000g",
        description = "Yukata Sofabed Sumire adalah sofabed multifungsi yang bisa digunakan sebagai sofa maupun tempat tidur. Terbuat dari bahan berkualitas tinggi dengan desain yang elegan dan modern. Cocok untuk melengkapi ruang tamu atau kamar tidur Anda."
    ),
    Product(
        image = R.drawable.mp_2,
        name = "POLISHER (LOW SPEED PL 17-154 HT)",
        stock = 20,
        price = 3500000.0,
        discountedPrice = 3150000.0,
        brand = "HT",
        category = "Cleaning Equipment",
        code = "PL17-154",
        dimension = "50x50x120 cm",
        weight = "20000g",
        description = "POLISHER (LOW SPEED PL 17-154 HT) adalah alat pemoles lantai berkecepatan rendah yang efisien untuk membersihkan dan memoles berbagai jenis lantai. Dilengkapi dengan pegangan ergonomis dan mudah dioperasikan."
    ),
    Product(
        image = R.drawable.mp_3,
        name = "BONE SAW BSW-2020",
        stock = 10,
        price = 5000000.0,
        discountedPrice = 4500000.0,
        brand = "BSW",
        category = "Butchery Equipment",
        code = "BSW2020",
        dimension = "70x40x150 cm",
        weight = "45000g",
        description = "BONE SAW BSW-2020 adalah mesin gergaji tulang yang kuat dan tahan lama. Ideal untuk digunakan di industri pengolahan daging atau rumah potong hewan. Dilengkapi dengan fitur keamanan yang canggih."
    ),
    Product(
        image = R.drawable.mp_4,
        name = "Mesin Es Krim (WIR818F-3 Valve 25L/h Floor Type)",
        stock = 5,
        price = 8000000.0,
        discountedPrice = 7200000.0,
        brand = "WIR",
        category = "Food Processing Equipment",
        code = "WIR818F-3",
        dimension = "60x60x150 cm",
        weight = "60000g",
        description = "Mesin Es Krim (WIR818F-3 Valve 25L/h Floor Type) adalah mesin pembuat es krim berkualitas tinggi dengan kapasitas 25L per jam. Cocok untuk bisnis es krim skala besar. Mudah dioperasikan dan dibersihkan."
    ),
    Product(
        image = R.drawable.mp_5,
        name = "Oven Roti 3 Deck 6 Trays OVN-60",
        stock = 8,
        price = 15000000.0,
        discountedPrice = 13500000.0,
        brand = "OVN",
        category = "Bakery Equipment",
        code = "OVN60",
        dimension = "90x70x160 cm",
        weight = "80000g",
        description = "Oven Roti 3 Deck 6 Trays OVN-60 adalah oven profesional dengan 3 deck dan 6 tray yang ideal untuk usaha roti dan kue. Memiliki kontrol suhu yang akurat dan distribusi panas yang merata untuk hasil panggangan sempurna."
    )
)



