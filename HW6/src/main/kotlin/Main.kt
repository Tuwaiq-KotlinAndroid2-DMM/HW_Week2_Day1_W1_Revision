

import java.io.File

fun main() {
    var arr =readFile("Car.txt")
    var expensiveCar =isExpensive(arr)
    println(expensiveCar.name+" "+expensiveCar.model+" "+expensiveCar.price+" "+expensiveCar.year)

}
fun readFile (filename:String):Array<Car?>{

    var f=File(filename)
    var lines=f.readLines().size
    var a= arrayOfNulls<Car>(lines)
    var index=0
    f.forEachLine { line ->
        var token =line.split(",")
        var name=token[0]
        var model=token[1]
        var price=token[2].toLong()
        var year=token[3].toInt()
        var C=Car(name,model,price ,year)
        a[index]=C
        index++
    }
    return a
}
fun isExpensive(arr:Array<Car?>): Car {
    var max=arr[0]
    for (C in arr){
        if (C!!.price > max!!.price)
            max=C
    }
    return max!!

}
