package csvXmlParser

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.w3c.dom.Document
import org.w3c.dom.NamedNodeMap
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory


class Parser {


    private val mapOfAddresses: HashMap<Address, Int> = hashMapOf()
    private var mapOfNotUnique: HashMap<Address, Int> = hashMapOf()

    private var mapForCities: HashMap<String, Floor> = hashMapOf()
    private var value = 0

    private fun printFloorInfo(map: HashMap<String, Floor> = hashMapOf()) {
        for (data in map) {
            println(data.key)
            println("1: " + data.value.first.toString())
            println("2: " + data.value.second.toString())
            println("3: " + data.value.third.toString())
            println("4: " + data.value.fourth.toString())
            println("5: " + data.value.fifth.toString())
        }
    }

    private fun printUniqueLines(map: HashMap<Address, Int> = hashMapOf()){
        for (data in map) {
            println("This line duplicate " + data.value.toString() + " times")
            println(data.key.city + " " + data.key.street + " "  + data.key.house + " "  + data.key.floor)
        }
    }

    fun xmlParser(fileName : String) {
        val pars = Parser()
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

            mapOfNotUnique = checkUniqueLines(ad)

            mapForCities = checkFloors(ad)

        }
        pars.printUniqueLines(mapOfNotUnique)
        pars.printFloorInfo(mapForCities)
    }

    fun csvParser(fileName : String) {
        val pars = Parser()
        val reader = Files.newBufferedReader(Paths.get(fileName))
        val csvParser = CSVParser(reader, CSVFormat.newFormat(';'))
        var newKey: Address
        csvParser.records.drop(1)
            .forEach {
                newKey = Address(it[0], it[1], it[2].toInt(), it[3].toInt())

                mapOfNotUnique = checkUniqueLines(newKey)

                mapForCities = checkFloors(newKey)

            }
        pars.printUniqueLines(mapOfNotUnique)
        pars.printFloorInfo(mapForCities)

    }

    private fun checkUniqueLines(ad: Address): HashMap<Address, Int> {
        if (mapOfAddresses.containsKey(ad)) {

            if (mapOfNotUnique.containsKey(ad)) {
                value = mapOfNotUnique[ad]!! + 1
                mapOfNotUnique[ad] = value

            } else
                mapOfNotUnique[ad] = 1
        } else
            mapOfAddresses[ad] = 1
        return mapOfNotUnique
    }

    private fun checkFloors(ad: Address): HashMap<String, Floor> {
        if (!(mapForCities.containsKey(ad.city))) {
            val floorObject = Floor()
            floorObject.addFloor(ad.floor)
            mapForCities[ad.city] = floorObject
        } else {
            val ob = mapForCities[ad.city]
            if (ob != null) {
                ob.addFloor(ad.floor)
                mapForCities[ad.city] = ob
            }

        }
        return mapForCities
    }
}