import java.io.File

fun main() {
    var array = readfile("cars.txt")
    var i = isExpensive(array)
    println(i.brand +" "+ i.model)


}

fun readfile(fileName: String): Array<Cars?>{
    var f = File(fileName)
    var lines = f.readLines().size
    var a = arrayOfNulls<Cars>(lines)
    var i = 0
    f.forEachLine { line ->
        var token = line.split(',')
        var brand = token[0]
        var model = token[1]
        var year = token [2].trimStart().trimEnd().toInt()
        var price = token [3].trimStart().trimEnd().toInt()
        var car = Cars(brand, model, year, price)
        a[i] = car
        i++
    }
    return a
}

fun isExpensive(arr:Array<Cars?>): Cars {
    var b = arr[0]

    for (car in arr){
        if ( car!!.price>200000 ){
            b = car
        }
    }
    return b!!
}
