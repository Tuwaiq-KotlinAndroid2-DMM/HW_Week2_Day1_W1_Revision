import java.io.File

fun main() {
	val myFile = readFile("Car.txt")
	val oldestCar = getOldestCar(myFile)
	println(oldestCar.toString())
}

fun readFile(fileName: String): Array<Car?> {
	val file = File(fileName)
	val numberOfLines = file.readLines().size
	val array = arrayOfNulls<Car?>(numberOfLines)

	var index = 0
	file.forEachLine { line ->
		val data = line.split(", ")
		val brand = data[0]
		val model = data[1]
		val year = data[2].toInt()
		val price = data[3].toInt()

		array[index] = Car(brand, model, year, price)
		index ++
	}

	return array
}

fun getOldestCar(carsArray: Array<Car?>): Car {
	var oldestCar = carsArray[0]!!

	for (car in carsArray) {
		if (car!!.year < oldestCar.year)
			oldestCar = car
	}

	return oldestCar
}