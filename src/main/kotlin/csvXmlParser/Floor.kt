package csvXmlParser

class Floor {
    var first = 0
    var second = 0
    var third = 0
    var fourth = 0
    var fifth = 0

    fun addFloor(number: Int) {
        if (number == 1)
            first += 1
        if (number == 2)
            second += 1
        if (number == 3)
            third += 1
        if (number == 4)
            fourth += 1
        if (number == 5)
            fifth += 1
    }

    override fun toString(): String {
        return "Floor(first=$first, second=$second, third=$third, fourth=$fourth, fifth=$fifth)"
    }


}