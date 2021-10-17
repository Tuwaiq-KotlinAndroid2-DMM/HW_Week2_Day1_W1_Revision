import java.io.File

fun main() {

    var arr = readFile("Cars.txt")
    var MostExpensive = getMostEx(arr)
    println("The Most Expensive Car Is: "+MostExpensive.brand+" "+MostExpensive.model+" "+MostExpensive.year+" "+MostExpensive.price)



}

fun readFile(filename:String):Array<Cars?>{

    var F = File(filename)
    var lines = F.readLines().size
    var a = arrayOfNulls<Cars>(lines)

    var index=0
    F.forEachLine { line ->

        var tokens = line.split(",")
        var brand = tokens[0]
        var model = tokens[1]
        var year =  tokens[2].toInt()
        var price = tokens[3].toInt()


        var car = Cars(brand,model,year,price)

        a[index]=car
        index++

    }
    return a
}

fun getMostEx(arr:Array<Cars?>):Cars{

    var Exp = arr[0]

    for(car in arr){
        if(car!!.price > Exp!!.price)
            Exp=car

    }
    return  Exp!!
}