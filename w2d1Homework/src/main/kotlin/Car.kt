import java.io.File

class Car(var brand:String,var model:String,var year:Int,var price:Double){

}


fun main(arr: Array<String>) {

    var arr= readFile("cars.txt")
    var mostExCar=getMosExp(arr)
    println("The Most Expensive car: ${mostExCar.brand} | its cost: ${mostExCar.price} SR")
}

fun readFile(fileName:String): Array<Car?>{
    var f= File(fileName)
    var lines=f.readLines().size
    var a = arrayOfNulls<Car>(lines)
    var index=0
    f.forEachLine { lines ->
            var tokens = lines.split(",")
            var brand = tokens[0]
            var model = tokens[1]
            var year = tokens[2].toInt()
            var price = tokens[3].toDouble()
            var car= Car(brand, model, year,price)
            a[index] = car
            index++
    }
    return a
}

fun getMosExp(arr: Array<Car?>):Car{
    var max=arr[0]
    for(car in arr){
        if(car!!.price>max!!.price)
            max=car
    }
    return max!!
}





