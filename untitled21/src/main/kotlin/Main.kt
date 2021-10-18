import java.io.File

fun main() {
    //var f = File("student.txt")
    var arr=readFile("student.txt")
    var oldeststudent=getoldeststudent(arr)
    println(oldeststudent.name+""+oldeststudent.gpa+""+oldeststudent.age)

}
//returns Array of students based on the inputfile
fun readFile(fileName:String):Array<student?>{
    var f=File(fileName)
    var lines=f.readLines().size
    var a= arrayOfNulls<student>(lines)
    var index=0
    f.forEachLine{line->
        var token=line.split(",")
        var name=token[0]
        var age=token[1].toInt()
        var gpa=token[2].toFloat()
        var std=student(name,age,gpa)
        a[index]=std
        index++
}
    return a
}
fun getoldeststudent(arr:Array<student?>):student{
    var max=arr[0]
    for(std in arr){
        if(std!!.age>max!!.age)
            max=std

    }
    return max!!
}


