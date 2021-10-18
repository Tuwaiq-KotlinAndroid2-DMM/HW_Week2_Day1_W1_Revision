import java.io.File

class Student(var name:String, var age:Int, var gpa:Float) {

    fun readFile(fileName:String): Array<Student?> {
        var f = File(fileName)
        var lines = f.readLines().size

        var a = arrayOfNulls<Student>(lines)

        var index = 0
        f.forEachLine { line ->

            var tokens = line.split(",")
            var name = tokens[0]
            var age = tokens[1].trimStart().trimEnd().toInt()
            var gpa = tokens[2].trimStart().trimEnd().toFloat()

            var std = Student(name, age, gpa)

            a[index] = std
            index++

        }
        return a
    }

    fun getOldestStudet(arr:Array<Student?>):Student{

        var max=arr[0]

        for (std in arr){
            if(std!!.age > max!!.age)
                max= std
        }

        return max!!
    }

    }