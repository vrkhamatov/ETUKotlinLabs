package WikiSearch

import java.net.URLEncoder


class Links {
    private lateinit var linkForGetJson: String
    private lateinit var linkForGetPage: String

    private val linkForGetJsonWithoutQuery: String =
        "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="

    fun makeLinkForGetJson(userQuery: String): String {
        linkForGetJson = ""
        linkForGetJson = linkForGetJsonWithoutQuery + "\"" + URLEncoder.encode(userQuery, "UTF-8") + "\""

        return linkForGetJson
    }

    fun makeLinkForGetPage(listOfPages: MutableList<String>): String {
        val numberPage = readLine()?.toInt()
        val pageId = listOfPages[numberPage!!]
        val pageId1 = URLEncoder.encode(pageId, "UTF-8")
        linkForGetPage = "https://ru.wikipedia.org/w/index.php?curid=$pageId1"

        return linkForGetPage
    }


}


