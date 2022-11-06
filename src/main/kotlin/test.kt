import java.util.*
import kotlin.collections.HashMap


class Address
    (
    val city : String = "",
    val street : String = "",
    val house : Int = 0,
    val floor : Int = 0
)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (city != other.city) return false
        if (street != other.street) return false
        if (house != other.house) return false
        if (floor != other.floor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + house
        result = 31 * result + floor
        return result
    }

    override fun toString(): String {
        return "Address(city='$city', street='$street', house=$house, floor=$floor)"
    }


}

fun main(){
    var map : HashMap<Address,Int>  = hashMapOf()
    var i : Int
    var add = Address()
    var k = 0
    for (i in 1..4) {
        k = k+1
        add = Address("Vadim", "Man", 11, 11)
        map.put(add, k)
        println(map.size)
    }
    println(map)
}