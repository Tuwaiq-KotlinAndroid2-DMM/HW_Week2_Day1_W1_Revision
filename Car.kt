import java.io.File


class Car (var name:String, var model:String, var price:Int, var year:Int){

}

fun main() {
    var arr= readFile("Car.txt")
    println(arr[0]?.name)

}


fun readFile(fileName:String): Array<Car?> {
    var f = File(fileName)
    var l = f.readLines().size
    var a = arrayOfNulls<Car?> (1)

    var index = 0
    f.forEachLine { line ->

        var token = line.split(',')
        var name = token[0]
        var model = token[1]
        var price = token[2].toInt()
        var year = token[3].toInt()
        var c = Car (name, model, price, year)

        a[index] = c
                index++
    }

    return a
}







