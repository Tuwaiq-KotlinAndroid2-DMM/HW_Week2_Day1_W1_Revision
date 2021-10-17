import java.io.File

fun main() {

    var arr=readFile("Car.txt")
    var getOldestCar= getOldest(arr)

    println(getOldestCar.name +"  " +getOldestCar.enginesize +"   "+getOldestCar. year)


}

fun readFile(fileName:String): Array<Car?>{
    var f=File(fileName)
    var lines=f.readLines().size

    var x= arrayOfNulls<Car>(lines)

    var index=0
    f.forEachLine { line ->

        var tokens= line.split(",")
        var name= tokens[0]
        var year= tokens[1].toInt()
        var enginesize= tokens[2].toFloat()

        var std= Car(name,year,enginesize)

        x[index]= std
        index++

    }

    return x
}

fun getOldestCar(arr:Array<Car?>):Car{

    var max=arr[0]

    for (std in arr){
        if(std!!.year > max!!.year)
            max= std
    }

    return max!!
}