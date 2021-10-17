import java.io.File
import java.time.Year

fun main() {
    var crr = readFile("carr.txt")
    var oldestcar = getoldestcar(crr)
    println(oldestcar.name + "  " + oldestcar.modal + "   " + oldestcar.price + "  " + oldestcar.year)

}

fun readFile(fileName: String): Array<car?> {
    var f = File(fileName)
    var lines = f.readLines().size

    var a = arrayOfNulls<car>(lines)

    var index = 0
    f.forEachLine { line ->

        var tokens = line.split(",")
        var name = tokens[0]
        var model = tokens[1]
        var price = tokens[2].toInt()
        var year = tokens[3].toInt()

        var std = car(name, model, price, year)

        a[index] = std
        index++

    }

    return a
}

fun getoldestcar(arr: Array<car?>): car {
    var max = arr[0]

    for (std in arr) {
        if (std!!.price > max!!.price)
            max = std
    }

    return max!!
}
