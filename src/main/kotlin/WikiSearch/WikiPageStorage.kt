package WikiSearch

import com.google.gson.Gson
import com.google.gson.JsonObject
import java.net.URL

class WikiPageStorage {
    private lateinit var title: String
    private lateinit var pageid: String

    fun add(title: String, pageid: String) {
        this.title = title
        this.pageid = pageid
    }

    fun makeJson(link: String): MutableList<String> {
        val listOfPages: MutableList<String> = mutableListOf()
        val listOfPagesNum: MutableList<String> = mutableListOf()
        val titleFromQuery = URL(link).readText()


        val title = Gson().fromJson(titleFromQuery, JsonObject::class.java).getAsJsonObject("query")
            .getAsJsonArray("search")

        var title1: String
        var pageid: String

        title.forEach {
            title1 = it.asJsonObject.getAsJsonPrimitive("title").toString()
            pageid = it.asJsonObject.getAsJsonPrimitive("pageid").toString()
            listOfPages.add(title1)
            listOfPagesNum.add(pageid)
        }

        var i = 0
        for (listOfPage in listOfPages) {
            print(i++)
            print(". ")
            println(listOfPage)
        }
        println("Введите порядкой номер желаемой статьи")

        return listOfPagesNum


    }

}