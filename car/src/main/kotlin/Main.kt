import java.io.File

fun readFile(fileName:String): Array<Car?>{
    var f= File(fileName)
    var lines=f.readLines().size
    var a = arrayOfNulls<Car>(lines)
    var index=0
    f.forEachLine { lines ->
        run{
            var tokens = lines.split(",")
            var brand = tokens[0]
            var model = tokens[1]
            var year = tokens[2].toInt()
            var price = tokens[3].toFloat()
            var c= Car(brand, model, year,price)
            a[index] = c
            index++
        }
    }
    return a
}

fun getMosExp(arr: Array<Car?>):Car{
    var max=arr[0]
    for(ca in arr){
        if(ca!!.price>max!!.price)
            max=ca
    }
    return max!!
}




fun main(arr: Array<String>) {
//    var fa=File("st.txt")
//    fa.writeText("fatima hussain,23,4")
    var arr= readFile("car.txt")
    println("The First car:"+ arr[0]?.brand)
    var ar=getMosExp(arr)
    println("The Most Expensive car:"+ar.brand)
}