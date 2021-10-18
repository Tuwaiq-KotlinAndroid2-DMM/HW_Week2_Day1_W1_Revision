package Car

import java.io.File


class Car(var brand: String, var model: String, var year: Int, var price: Int) {
//    constructor() : this("", "", 0, 0)
var i =0
    fun readFile(fname: String): Array<Car?> {
        var f = File(fname)
        var lines = f.readLines().size
        var a = arrayOfNulls<Car>(lines)
        f.forEachLine { line ->
            var tokens = line.split(",")
            var brand = tokens[0]
            var model = tokens[1]
            var year = tokens[2].trimStart().trimEnd().toInt()
            var price = tokens[3].trimStart().trimEnd().toInt()
            var cars = Car(brand, model, year, price)
            a[i] = cars
            i++
        }
        return a

    }

    fun carqw(arr: Array<Car?>): Car {
        var max = arr[0]
        for (car in arr) {
            if (car!!.model > max!!.model)
                max = car


        }
        return max!!
    }


}










