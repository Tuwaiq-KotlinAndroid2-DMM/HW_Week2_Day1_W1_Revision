import java.io.File
import java.nio.file.Files
import java.time.LocalDate

fun main() {
    var fileName = "carsList.txt"

    //call to function to generate file
    createFileAndPopulate(fileName)

    //cal to function to read through the generated file
    var carArray = readFile(fileName)

    //print the array of cars
    printArr(carArray)

    //print cars that are expensive (above a set limit)
    printExpensiveCars(carArray)

    //print cars that are the newest (current year or previous year)
    printNewestCars(carArray)
}

fun createFileAndPopulate(fileName: String){
    //create directory in project
    var folder = File("Cars_List")
    Files.createDirectories(folder.toPath())
    //create file in created directory
    var createFile = File(folder,fileName)
    //car information
    var text = "Toyota, Camry, 2016, 40000\nDodge, Charger, 2021, 70000\nFord, Expedition, 2018, 125000\nBMW, X6, 2020, 240000\nMercedes, GLE Coupe, 2020, 260000\n"
    var text2 = "Mazda, CX, 2019, 110000\nTesla, Model X, 2018, 175000\nTesla, Model S, 2020, 135000\nPurche, Carera, 2021, 450000\nMasarati, M1, 2021, 500000"
    //writing information inside text file
    createFile.writeText(text)
    createFile.appendText(text2)
}

fun readFile(fileName: String): Array<Cars?> {
    //create file link to read data in it
    var textFile = File("Cars_List/"+fileName)
    //get number of lines
    var lines = textFile.readLines().size
    //create array with size of lines from previous line
    var carsArray = arrayOfNulls<Cars>(lines)
    //index to increament in forEachLine
    var index = 0

    //loop through textFile
    textFile.forEachLine { line ->
        //split data by delimiter and assign to variables for the object of the Cars class
        var tokens = line.split(", ")
        var brand = tokens[0]
        var model =tokens[1]
        var year = tokens[2].toInt()
        var price = tokens[3].toDouble()
        var stu = Cars(brand, model, year, price)
        //Insert object into the array
        carsArray[index] = stu
        //Increment index for to access next row in array
        index++
    }
    return carsArray
}

fun printArr(cars: Array<Cars?>){
    //Loop through array of cars and call function toString()
    for (car in cars){println(car.toString()) }
}

fun printExpensiveCars(cars: Array<Cars?>){
    //Loop through array of cars and find expensive cars
    for (car in cars){if (car!!.isExpensive()) println(car!!.printIsExpensive()) }
}

fun printNewestCars(cars: Array<Cars?>){
    //Loop through array of cars and find expensive cars
    for (car in cars){if (car!!.isNew()) println(car!!.printIsNew()) }
}


