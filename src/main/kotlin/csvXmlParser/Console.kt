package csvXmlParser

fun startLab(){
    do
    {
        val path = pathRequest()
        try {
            val time : Long
            val parse = Parser()
            if (path != null) {
                if (path == "end"){
                    println("User write ending command")
                    throw Exception("User write ending command")
                }
                if (path.last() == 'l'){
                    time = System.currentTimeMillis()
                    parse.xmlParser(path)}
                else
                        if (path.last() == 'v') {
                            time = System.currentTimeMillis()
                            parse.csvParser(path)

                        }
                else
                    throw Exception("the path is not correct")
            }
            else
                throw Exception("the path is not correct")
            val workTime = System.currentTimeMillis() - time
            println("Time : " + workTime.div(1000) + " second " + workTime.mod(1000) + " millisecond")
        }
        catch (e : Exception)
        {
            throw Exception(e.message)
        }
    }
    while (true)
}

fun pathRequest(): String? {
        println("Enter a path of file or end for stop program")
        return readLine()
}