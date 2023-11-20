package com.dicoding.newsmovieapp.data.fake

import androidx.room.*

@Entity
data class Movie(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "runtime")
    var runtime: String,

    @ColumnInfo(name = "posterUrl")
    var posterUrl: String,

    @ColumnInfo(name = "sinopsis")
    var sinopsis: String
)

object MovieData {
    val dummyMovie = listOf(
        Movie(
            1,
            "Matrix",
            "2011",
            "125 min",
            "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg",
            "The Matrix adalah sebuah film fiksi ilmiah yang pertama kali dirilis di Amerika Serikat pada tanggal 31 Maret 1999. Film ini ditulis dan disutradarai oleh Wachowski bersaudara (Andy dan Larry). Dengan Pemeran utamanya adalah Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, dan Hugo Weaving.\n" +
                    "The Matrix menghasilkan pendapatan sebesar US $171 juta di Amerika Serikat dan US456 juta di seluruh dunia. Film ini sebelumnya tidak diperkirakan akan menjadi sangat sukses dan populer sampai mencapai status cult sehingga diproduksikan kedua film lanjutannya:The Matrix Reloaded, The Matrix Revolutions dan The Matrix Resurrections. Wachowski bersaudara memang sudah ingin membuat sebuah trilogi, tetapi baru diperbolehkan setelah film pertama terbukti sukses."
        ),

        Movie(
            2,
            "Mowgli: Legend of the Jungle",
            "2018",
            "104 min",
            "https://m.media-amazon.com/images/M/MV5BMjMzODc2NzU5MV5BMl5BanBnXkFtZTgwNTMwMTE3NjM@._V1_SX300.jpg",
            "Mowgli: Legend of the Jungle, dikenal sebagai Mowgli, adalah sebuah film petualangan peran hidup yang disutradarai oleh Andy Serkis dan ditulis oleh Callie Kloves, berdasarkan pada The Jungle Book karya Rudyard Kipling. Film tersebut dibintangi oleh Rohan Chand, Matthew Rhys, dan Freida Pinto, dengan penampilan-penampilan pendukung dari Serkis, Christian Bale, Benedict Cumberbatch, Tom Hollander, dan Cate Blanchett."
        ),

        Movie(
            3,
            "Doctor Strange",
            "2016",
            "115 min",
            "https://m.media-amazon.com/images/M/MV5BNjgwNzAzNjk1Nl5BMl5BanBnXkFtZTgwMzQ2NjI1OTE@._V1_SX300.jpg",
            "Doctor Strange adalah sebuah film pahlawan super Amerika yang menampilkan karakter Marvel Comics dengan nama yang sama, diproduksi oleh Marvel Studios dan didistribusikan oleh Walt Disney Motion Pictures. Film ini merupakan film keempat belas dari Marvel Cinematic Universe (MCU). Film ini disutradarai oleh Scott Derickson, yang menulis skenario adalah C. Robert Cargill dari sebuah cerita oleh duo dan Jon Spahits, dan dibintangi oleh Benedict Cumberbatch, Chiwetel Ejiofor, Rachel McAdams, Benedict Wong, Michael Stuhlbarg, Benjamin Bratt, Scott Adkins, Mads Mikkelsen, dan Tilda Swinton. Dalam Doctor Strange, ahli bedah Stephen Strange belajar seni mistik dari Ancient One setelah kecelakaan mobil mengakhiri kariernya."
        ),

        Movie(
            4,
            "John Wick",
            "2014",
            "101 min",
            "https://m.media-amazon.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_SX300.jpg",
            "John Wick adalah judul film Amerika Serikat produksi tahun 2014 bergenre thriller aksi yang disutradarai oleh[3] Chad Stahelski dan David Leitch dan beberapa bintang yang bermain dalam film ini antara lain Keanu Reeves, Michael Nyqvist, Alfie Allen, Adrianne Palicki, Bridget Moynahan, Dean Winters, Ian McShane, John Leguizamo, dan Willem Dafoe. Film ini menceritakan tentang seorang mantan pembunuh bayaran yang kembali beraksi setelah anjingnya dibunuh dan mobilnya dicuri oleh anak dari bos mafia."
        ),

        Movie(
            5,
            "Schindelers List",
            "2004",
            "123 min",
            "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg",
            "Schindler's List adalah film 1993 berdasarkan novel Schindler's Ark karya Thomas Keneally, yang diterbitkan di Amerika Serikat dengan judul Schindler's List dan kemudian diedarkan kembali di negara-negara Persemakmuran dengan judul itu pula. Filmnya, yang diadaptasi oleh Steven Zaillian dan disutradarai oleh Steven Spielberg, mengisahkan riwayat Oskar Schindler, seorang pengusaha Katolik Jerman yang berperan dalam menyelamatkan nyawa lebih dari seribu orang Yahudi-Polandia pada masa Holocaust. Judulnya merujuk kepada daftar nama dari 1.100 orang Yahudi yang dipekerjakan Schindler di pabriknya dan karenanya tidak dikirim ke kamp-kamp konsentrasi."
        ),

        Movie(
            6,
            "Lord Of The Rings",
            "2011",
            "145 min",
            "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR0,0,182,268_AL_.jpg",
            "The Lord of the Rings: The Return of the King adalah sebuah film epik fantasi yang disutradarai oleh Peter Jackson novel dari J.R.R. Tolkien dan naskahnya ditulis oleh Fran Walsh, Philippa Boyens dan Jackson sendiri. Melanjutkan kisah dari The Lord of The Rings: The Two Towers, Frodo, Sam, dan Gollum memasuki ujung perjalanan mereka ke Gunung Doom di Mordor untuk menghancurkan Cincin Utama tanpa menyadari niat terselubung Gollum. Disisi Dunia Tengah yang lain, Merry, Pippin, Gandalf, Aragorn, Legolas, dan Gimli kembali bertemu untuk memperkuat serangan mereka kepada Sauron dan pasukannya di Minas Tirith.",
        ),

        Movie(
            7,
            "Pulp Fiction",
            "2008",
            "120 min",
            "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR0,0,182,268_AL_.jpg%22",
            "Pulp Fiction adalah sebuah film kriminal tahun 1994 karya sutradara Quentin Tarantino, yang menulis naskah cerita film tersebut bersama Roger Avary. Dibintangi oleh John Travolta, Samuel L. Jackson, Uma Thurman, Bruce Willis, Tim Roth, dan Ving Rhames. Sebagai sebuah film drama kriminal dengan alur cerita yang non-linear, film tersebut terkenal karena dialog-dialognya yang kaya dan menggunakan kosakata yang unik, campuran humor dan kekerasan yang ironis, dan masuknya berbagai referensi film dan kebudayaan pop. "
        ),

        Movie(
            8,
            "Clint East Wood",
            "2005",
            "140 min",
            "https://m.media-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1_UX182_CR0,0,182,268_AL_.jpg",
            "Clinton Eastwood, Jr. (lahir 31 Mei 1930) adalah aktor, produser, komposer, dan sutradara film pemenang Academy Award asal Amerika Serikat. Eastwood terkenal dalam perannya sebagai jagoan dan bukan pahlawan, dikenal sebagai Inspektur 'Dirty' Harry Callahan dalam serial Dirty Harry dan Man with No Name dalam film-film Spaghetti Western karya Sergio Leone."
        ),

        Movie(
            9,
            "Joker",
            "2004",
            "201 min",
            "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UY268_CR0,0,182,268_AL_.jpg",
            "Joker ditayangkan secara perdana di Festival Film Venesia pada tanggal 31 Agustus 2019[4] serta ditayangkan di Amerika Serikat pada 4 Oktober 2019 dan Indonesia dua hari sebelumnya.[5][6] Joker adalah film laga hidup pertama Batman yang mendapatkan klasifikasi R dari Motion Picture Association of America karena kekerasan berdarah yang kuat, perilaku mengganggu, bahasa dan gambar seksual singkat.[a]"
        ),

        Movie(
            10,
            "Fight Club",
            "2011",
            "120 min",
            "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX182_CR0,0,182,268_AL_.jpg",
            "Fight Club adalah film Amerika Serikat yang dirilis pada tahun 1999 yang diadaptasi dari novel yang juga berjudul Fight Club karya Chuck Palahniuk. Film ini disutradarai oleh David Fincher dan diperankan oleh Edward Norton (tokoh protagonis dalam film ini yang tanpa nama dan selaku narator). Film yang mengisahkan seorang pria yang terjebak dalam kehidupan sebagai masyarakat pekerja \"kerah putih\" yang terlibat klub pertarungan ilegal yang dirintis oleh penjual sabun yang bernama Tyler Durden (Brad Pitt). Mereka terjerumus dalam kisah segitiga dengan seorang wanita bernama Marla Singer (Helena Bonham Carter)."
        )
    )
}
