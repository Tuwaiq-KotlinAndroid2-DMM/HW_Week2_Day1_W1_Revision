import java.io.File

fun main() {

   var array = readFile("Car.txt")
   var oldestCar= getOldestCar(array)

   println("The oldest car is :\n" +oldestCar.brand +"  " +oldestCar.model +"   "+oldestCar. year + " " + oldestCar.price)

}

fun readFile(fileName:String) :Array<Car?>{
   var f = File(fileName)
   var numOfLines = f.readLines().size

   var myArray = arrayOfNulls<Car>(numOfLines)
   var index = 0
   f.forEachLine { line ->
      var tokens = line.split(",")

      var brand= tokens[0]
      var model= tokens[1]
      var year= tokens[2].toInt()
      var price = tokens[3].toInt()

      var myCar= Car(brand,model,year,price)

      myArray[index]= myCar
      index++
   }
   return myArray
}

fun getOldestCar(array:Array<Car?>):Car{

   var max=array[0]

   for (myCar in array){
      if(myCar!!.year > max!!.year)
         max= myCar
   }

   return max!!
}