package CsvXmlParser

import org.xml.sax.Attributes
import org.xml.sax.SAXException
import org.xml.sax.helpers.DefaultHandler
import java.io.File
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory


class defaultHandler : DefaultHandler() {

    var empList = ArrayList<HashMap<String, String>>()
    var empData = HashMap<String, String>()
    var currentValue = ""
    var currentElement = false
    //overriding the startElement() method of DefaultHandler

    override fun startDocument() {
        super.startDocument()
        println("Start Document")
    }

    override fun endDocument() {
        endDocument()
        println("End Doc")
    }

    override fun startElement(uri: String, localName: String, qName: String, attributes: Attributes) {
       // System.out.println("Root" + qName)
//        currentElement = true
//        currentValue = ""
//        if (localName == "root") {
//            println("Start")
//            empData = HashMap()
//        }
        currentValue = qName
    }
    //overriding the endElement() method of DefaultHandler
    override fun endElement(uri: String, localName: String, qName: String) {
//        currentElement = false
//        if (localName.equals("item city", ignoreCase = true)) {
//            empData["item city"] = currentValue
//            println(currentValue)
//        }
//        else if (localName.equals("street", ignoreCase = true))
//            empData["street"] = currentValue
//        else if (localName.equals("house", ignoreCase = true))
//            empData["house"] = currentValue
//        else if (localName.equals("root", ignoreCase = true))
//            empList.add(empData)
        currentValue = ""
    }
    //overriding the characters() method of DefaultHandler

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        println(String(ch.toString()))
    }
//    override fun characters(ch: CharArray, start: Int, length: Int) {
//        println("characters" + String(ch, start, length))
//        if (currentElement) {
//           currentValue = currentValue + String(ch, start, length)
//        }
//    }
}

fun main() {
    val fileName = "C:\\Users\\khama\\Desktop\\Учеба\\5 семестр\\kotlin\\Лаб 2\\Files\\address.xml"
    val factory = SAXParserFactory.newInstance();
    val saxParser:SAXParser = factory.newSAXParser()

    val a = defaultHandler()

    val istream = File(fileName)
    saxParser.parse(istream, a)
}

