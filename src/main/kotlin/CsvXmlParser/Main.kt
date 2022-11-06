package CsvXmlParser


import org.w3c.dom.*
import java.io.File
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.NamedNodeMap

fun main() {

    var mapOfAddresses: HashMap<Address, Int> = hashMapOf()
    var value = 0
    val fileName = "C:\\Users\\khama\\Desktop\\Учеба\\5 семестр\\kotlin\\Лаб 2\\Files\\address.xml"
    val factory = DocumentBuilderFactory.newInstance()
    val builder: DocumentBuilder = factory.newDocumentBuilder()
    val document: Document = builder.parse(File(fileName))
    val elements = document.getElementsByTagName("item")
    for (i in 0 until elements.length) {
        val attributes: NamedNodeMap = elements.item(i).attributes
        val city: String = attributes.getNamedItem("city").nodeValue
        val street: String = attributes.getNamedItem("street").nodeValue
        val house: Int = attributes.getNamedItem("house").nodeValue.toInt()
        val floor: Int = attributes.getNamedItem("floor").nodeValue.toInt()
        val ad = Address(city, street, house, floor)
        if (mapOfAddresses.containsKey(ad)) {
            value = mapOfAddresses.get(ad)!! + 1
            mapOfAddresses[ad] = value
        } else
            mapOfAddresses.put(ad, 1)
    }
    println(mapOfAddresses)
}
