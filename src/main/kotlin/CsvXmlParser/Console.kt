package CsvXmlParser

fun pathRequest(): String? {
    try {
        println("Введите путь до XML файла")
        val userPath = readLine()
        print(userPath)
        return userPath
    } catch (e: Exception){
        throw Exception("Hi There!")
        }
}