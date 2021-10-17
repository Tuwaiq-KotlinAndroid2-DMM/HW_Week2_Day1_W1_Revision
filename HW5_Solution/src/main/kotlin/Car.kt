import java.io.File
class Car(var brand: String, var model: String, var price: Double, var year: Int) {


}
fun main() {

    var arr=readFile("Cars.txt")
    var mostExpensive= getMostExpensive(arr)

    println(mostExpensive.brand +"  " +mostExpensive.model +"   "+mostExpensive.price+"   "+mostExpensive.year)


}

// returns Array Of Students based on the input file
fun readFile(fileName:String): Array<Car?>{
    var f=File(fileName)
    var lines=f.readLines().size

    var a= arrayOfNulls<Car>(lines)

    var index=0
    f.forEachLine { line ->

        var tokens= line.split(",")
        var brand= tokens[0]
        var model= tokens[1]
        var price= tokens[2].toDouble()
        var year= tokens[3].toInt()
        var std= Car(brand,model,price,year)

        a[index]= std
        index++

    }

    return a
}

fun getMostExpensive(arr:Array<Car?>):Car{

    var max=arr[0]

    for (std in arr){
        if(std!!.price > max!!.price)
            max= std
    }

    return max!!
}
