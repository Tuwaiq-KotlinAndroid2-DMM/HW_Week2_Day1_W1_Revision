import java.io.File
fun main()
{
    /*val fileName = "Cars.txt"
    val file = File(fileName)*/
    var arr=readFile("Cars.txt")
    var newcarmodel= newcarmodel(arr)

    println(newcarmodel.name +"  " +newcarmodel.price +"   "+newcarmodel. model)



}//end main

fun readFile(fileName:String): Array<Cars?>{
    var f=File(fileName)
    var lines=f.readLines().size

    var a= arrayOfNulls<Cars>(lines)// Cars

    var index=0
    f.forEachLine { line ->

        var tokens= line.split(",")
        var name= tokens[0]
        var model= tokens[1].toInt()
        var price= tokens[2].toFloat()

        var car= Cars(name,model,price)

        a[index]= car
        index++

    }

    return a
}

fun newcarmodel (arr:Array<Cars?>):Cars{

    var max=arr[0]

    for (car in arr){
        if(car!!.model > car!!.model)
            max= car
    }

    return max!!
}
