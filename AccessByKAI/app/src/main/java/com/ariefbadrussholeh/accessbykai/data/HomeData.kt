package com.ariefbadrussholeh.accessbykai.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.ariefbadrussholeh.accessbykai.R

data class HomeData (
    val title: String,
    val image: Painter,
    val link: String = ""
)

val promoData: List<HomeData>
    @Composable
    get() = listOf(
        HomeData(
            title = "The Westin Surabaya",
            image = painterResource(id = R.drawable.img_promo_1)
        ),
        HomeData(
            title = "Four Points by Sheraton Surabaya",
            image = painterResource(id = R.drawable.img_promo_2)
        ),
        HomeData(
            title = "DoubleTree by Hilton Surabaya",
            image = painterResource(id = R.drawable.img_promo_3)
        ),
        HomeData(
            title = "Grand Swiss-Belhotel Darmo",
            image = painterResource(id = R.drawable.img_promo_4)
        ),
        HomeData(
            title = "Oakwood Hotel & Residence Surabaya",
            image = painterResource(id = R.drawable.img_promo_5)
        ),
    )

val articleData: List<HomeData>
    @Composable
    get() = listOf(
        HomeData(
            title = "Pengguna Jasa KA di Palembang Naik 17 Persen Selama Long Weekend",
            image = painterResource(id = R.drawable.img_article_1),
            link = "https://www.detik.com/sumbagsel/bisnis/d-7340755/pengguna-jasa-ka-di-palembang-naik-17-persen-selama-long-weekend"
        ),
        HomeData(
            title = "Pengumuman Perjalanan KA Solo-Wonogiri Dipangkas Selama 2 Hari",
            image = painterResource(id = R.drawable.img_article_2),
            link = "https://travel.detik.com/travel-news/d-7339402/pengumuman-perjalanan-ka-solo-wonogiri-dipangkas-selama-2-hari"
        ),
        HomeData(
            title = "Ragam Tanggapan Penumpang soal Pengalihan Rute KA dari Senen ke Jatinegara",
            image = painterResource(id = R.drawable.img_article_3),
            link = "https://news.detik.com/berita/d-7337203/ragam-tanggapan-penumpang-soal-pengalihan-rute-ka-dari-senen-ke-jatinegara"
        ),
        HomeData(
            title = "KAI Catat Penumpang dari Jakarta Naik 2 Kali Lipat pada Masa Long Weekend",
            image = painterResource(id = R.drawable.img_article_4),
            link = "https://news.detik.com/berita/d-7333748/kai-catat-penumpang-dari-jakarta-naik-2-kali-lipat-pada-masa-long-weekend"
        ),
        HomeData(
            title = "Sambut Long Weekend Kenaikan Yesus Kristus, KAI Sediakan 739 Ribu Tempat Duduk",
            image = painterResource(id = R.drawable.img_article_5),
            link = "https://travel.detik.com/travel-news/d-7328861/sambut-long-weekend-kenaikan-yesus-kristus-kai-sediakan-739-ribu-tempat-duduk"
        ),
    )