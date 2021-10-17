import java.io.File

fun main() {

    var arr = readFile("Car")
    var NewCar=getNewCar(arr)
    println("Car Brand: ${NewCar.Brand}\n  model: ${NewCar.model} \n Price: ${NewCar.price} \n Year: ${NewCar.year} ")
}
fun readFile(fileName : String):Array<Car?> {
    var f = File(fileName)
    var NumberOfLines = f.readLines().size
    var a = arrayOfNulls<Car>(NumberOfLines)
    var index = 0

    f.forEachLine { line ->
        var tokens = line.split(",")
        var Brand = tokens[0]
        var model = tokens[1]
        var price = tokens[2].toInt()
        var year = tokens[3].toInt()
        var car = Car(Brand, model, price, year)
        a[index] = car
        index++
    }
    return a


}
fun getNewCar(arr:Array<Car?>):Car{

    var max=arr[0]
    for (car in arr){
        if (car!!.year>max!!.year)
            max=car
    }
    return max!!
}