import java.time.LocalDate

class Cars (var brand: String, var model: String, var year: Int, var price: Double) {
    fun isExpensive(): Boolean = (price>150000)

    fun printIsExpensive(): String = "The $model by $brand is an expensive model."

    fun isNew(): Boolean{
        var currentYear = LocalDate.now().year
        return (year == currentYear || year == (currentYear-1))
    }

    fun printIsNew(): String = "The $model by $brand is one of the newest cars"

    override fun toString(): String = "The $model is produced by $brand in $year and the starting price is $price"
}