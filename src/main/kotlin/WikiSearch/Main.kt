package WikiSearch
import java.awt.Desktop
import java.net.URI

fun main() {
    println("Введите информацию, о которой хотите узнать")
    val userQuery = readLine().toString()
    if (userQuery.length == 0) throw Exception("Query is empty")
    val page = WikiPageStorage()
    val firstLink = Links()
    val link = firstLink.makeLinkForGetJson(userQuery)
    Desktop.getDesktop().browse(URI(firstLink.makeLinkForGetPage(page.makeJson(link))))
}