import java.io.File

class Car(var company: String, var year: Int, var price: Int) {}

fun main() {
    var arr = readFile("Cars.txt")
    var exCar = getMostEXCar(arr)
    println("company:" + exCar.company)
    println("year:" + exCar.year)
    println("price:" + exCar.price)
}

fun readFile(fileName: String): Array<Car?> {
    var f = File(fileName)
    var lines=f.readLines().size
    var a = arrayOfNulls<Car>(lines)
    var index = 0
    f.forEachLine { line ->
        var tokens = line.split(",")
        var company = tokens[0]
        var year = tokens[1]
        var price = tokens[2]
        var car = Car(company, year.toInt(), price.toInt())
        a[index] = car
        index++
    }
    return a
}

fun getMostEXCar(arr: Array<Car?>): Car {

    var max = arr[0]

    for (c in arr) {
        if (c!!.price > max!!.price)
            max = c
    }

    return max!!
}
