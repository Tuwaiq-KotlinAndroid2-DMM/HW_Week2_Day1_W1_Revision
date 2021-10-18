import constructor.Car
import java.io.File

fun main() {


     var arr=readFile("Car")
     var oldestCar=getOldestCar(arr)
   println(oldestCar.Name+""+oldestCar.model+""+oldestCar.price+""+oldestCar.year)

    }
fun readFile(FileName:String): Array<Car?> {
    var f = File(FileName)
    var lines = f.readLines().size
    var a = arrayOfNulls<Car>(lines)
    var index = 0
    f.forEachLine { line ->

        var tokens = line.split(",")
        var Name = tokens[0]
        var model = tokens[1].trimStart().trimStart()
        var price = tokens[2].trimStart().trimStart().toInt()
        var year = tokens[2].trimStart().trimStart().toInt()
        var C = Car(Name, model, price, year)

        a[index] = C
        index++

    }
    return a
}

fun getOldestCar(arr: Array<Car?>): Car {

    var max = arr[0]


    for (C in arr) {
        if (C!!.model > max!!.model)
            max = C
    }

    return max!!
}
