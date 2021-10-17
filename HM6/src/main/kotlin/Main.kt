import java.io.File

// task to have a file of lines of cars.

//1) create a fun to get each line and then make it to string then split to array
// then  make it returns an array of type Car

fun main() {
    var arrCars = getLinesFromFile("File Of Cars.txt")
  //  println(arrCars[0]?.model)
    var pricyCar = mostExpCar(arrCars)

    println("${pricyCar.make} of kind ${pricyCar.model} is the most expensive car $${pricyCar.price}")

}

fun getLinesFromFile (fileName: String): Array<Car?> {

    var f = File(fileName)
    var lines = f.readLines().size
    var arrOfCars = arrayOfNulls<Car>(lines)
    var index = 0
    f.forEachLine { line ->
        var lineOfCar = line.split(",")
        var make = lineOfCar[0]
        var model = lineOfCar[1]
        var year = lineOfCar[2].trim().toInt()
        var price = lineOfCar[3].trim().toDouble()

        var car = Car(make,model,year,price)

         arrOfCars[index] = car
        index ++

    }


    return arrOfCars
}

fun mostExpCar (arr: Array<Car?>): Car {
   var max = arr[0]
    for (car in arr){
        if (max!!.price < car!!.price) max = car
    }
    return max!!
}