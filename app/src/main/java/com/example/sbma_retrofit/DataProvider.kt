package com.example.sbma_retrofit

object DataProvider {
    val presidents: MutableList<President> = java.util.ArrayList()

    init {
        presidents.add(President(0, "Kaarlo Juho Ståhlberg"))
        presidents.add(President(1,"Lauri Kristian Relander"))
        presidents.add(President(2,"Pehr Evind Svinhufvud"))
        presidents.add(President(3,"Kyösti Kallio"))
        presidents.add(President(4,"Risto Ryti"))
        presidents.add(President(5,"Carl Gustaf Emil Mannerheim"))
        presidents.add(President(6,"Juho Kusti Paasikivi"))
        presidents.add(President(7,"Urho Kekkonen"))
        presidents.add(President(8,"Mauno Koivisto"))
        presidents.add(President(9,"Martti Ahtisaari"))
        presidents.add(President(10,"Tarja Halonen"))
        presidents.add(President(11,"Sauli Niinistö"))
    }
}