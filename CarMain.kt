import java.io.File
fun main(){
    var arr = readFile("Car.txt")

    var oldestCarModel = getOldestCarModel(arr)
    println("Car name: ${oldestCarModel.Carname} \nCar model: ${oldestCarModel.CarModel} \nprice: ${oldestCarModel.price} \nYear: ${oldestCarModel.year}")

}

fun readFile(fileName:String): Array<CarClass?> {
    var f = File(fileName)
    var numOfLines = f.readLines().size

    var a = arrayOfNulls<CarClass>(numOfLines)
    var index = 0
    f.forEachLine { line ->

        var tokens = line.split(",")
        var Carname = tokens[0]
        var CarModel = tokens[1]
        var price = tokens[2].toDouble()
        var year = tokens[2].toInt()

        var std = CarClass(Carname, CarModel, price, year)
        a[index] = std
        index++

    }
    return a
}

fun getOldestCarModel(arr:Array<CarClass?>):CarClass{
    var max = arr[0]
    for(std in arr){
        if(std!!.year > max!!.year)
            max = std
    }
    return max!!
}

