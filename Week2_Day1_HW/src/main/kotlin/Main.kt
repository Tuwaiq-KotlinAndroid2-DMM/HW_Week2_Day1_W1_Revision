import java.io.File

fun main() {

    var arrCar = readFile("Car.txt")
    println(arrCar[0]?.name)


}

fun readFile(fileName:String): Array<Car?> {

    var f =File(fileName)
     var l =  f.readLines().size
    
    var a = arrayOfNulls<Car>(l)

    var index=0
    f.forEachLine { line ->

        var splitArray =line.split(",")

        var name =splitArray[0]
        var model=splitArray[1]
        var year =splitArray[2].toInt()
        var price=splitArray[3].toInt()

        var c =Car(name,model,year,price)
        a[index] =c
        index++
    }
    
return a
}
