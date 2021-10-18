package Car

import java.io.File


fun main() {


    var c =Car("", "", 0, 0)
    var arr = c.readFile("Car.text")
    var o = c.carqw(arr)
    println(o.brand + o.model + o.year + o.price)
}

