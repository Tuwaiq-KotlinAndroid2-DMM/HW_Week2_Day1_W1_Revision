import java.io.File
fun main(){
    var arr = readFile("car")

    var oldescar =  getOldestCar(arr)
    println("${oldescar.name} ${oldescar.model} ${oldescar.price} ${oldescar.year}")

}

fun readFile(fileName:String): Array<Car?> {
    var f = File(fileName)
    var numOfLines = f.readLines().size

    var a = arrayOfNulls<Car>(numOfLines)
    var index = 0
    f.forEachLine { line ->

        var tokens = line.split(",")
        var name = tokens[0]
        var model = tokens[1]
        var price = tokens[2].toDouble()
        var year = tokens[2].toInt()

        var std = Car(name, model, price,year)
        a[index] = std
        index++

    }
    return a
}

fun getOldestCar(arr:Array<Car?>):Car{
    var max = arr[0]
    for(std in arr){
        if(std!!.price > max!!.price)
            max = std
    }
    return max!!
}