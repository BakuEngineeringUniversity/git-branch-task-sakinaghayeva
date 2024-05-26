interface Drivable {
    fun drive(distance: Double)
}

abstract class Vehicle(val make: String, val model: String, val year: Int, var mileage: Double) : Drivable {
    abstract val type: String
    abstract fun displayInfo()
}

class Car(make: String, model: String, year: Int, mileage: Double, val fuelType: String) : Vehicle(make, model, year, mileage) {
    override val type = "Car"

    override fun drive(distance: Double) {
        println("Driving $distance miles with a $fuelType car...")
        mileage += distance
    }

    override fun displayInfo() {
        println("Car: $year $make $model")
        println("Fuel Type: $fuelType")
        println("Mileage: $mileage miles")
    }
}

class ElectricCar(make: String, model: String, year: Int, mileage: Double, val batteryCapacity: Double) : Vehicle(make, model, year, mileage) {
    override val type = "Electric Car"

    override fun drive(distance: Double) {
        println("Driving $distance miles with an electric car...")
        mileage += distance
    }

    override fun displayInfo() {
        println("Electric Car: $year $make $model")
        println("Battery Capacity: $batteryCapacity kWh")
        println("Mileage: $mileage miles")
    }
}

class Truck(make: String, model: String, year: Int, mileage: Double, val loadCapacity: Double) : Vehicle(make, model, year, mileage) {
    override val type = "Truck"

    override fun drive(distance: Double) {
        println("Driving $distance miles with a truck carrying $loadCapacity tons...")
        mileage += distance
    }

    override fun displayInfo() {
        println("Truck: $year $make $model")
        println("Load Capacity: $loadCapacity tons")
        println("Mileage: $mileage miles")
    }
}

class Fleet {
    private val vehicles: MutableList<Vehicle> = mutableListOf()

    fun addVehicle(vehicle: Vehicle) {
        vehicles.add(vehicle)
        println("${vehicle.make} ${vehicle.model} has been added to the fleet.")
    }

    fun displayFleetInfo() {
        println("Fleet Information:")
        for (vehicle in vehicles) {
            vehicle.displayInfo()
            println()
        }
    }

    fun driveAllVehicles(distance: Double) {
        for (vehicle in vehicles) {
            vehicle.drive(distance)
        }
    }
}

fun main() {
    val car1 = Car("Toyota", "Corolla", 2020, 15000.0, "Gasoline")
    val car2 = Car("Honda", "Civic", 2018, 20000.0, "Diesel")
    val electricCar = ElectricCar("Tesla", "Model S", 2022, 5000.0, 100.0)
    val truck = Truck("Ford", "F-150", 2019, 30000.0, 5.0)

    val fleet = Fleet()
    fleet.addVehicle(car1)
    fleet.addVehicle(car2)
    fleet.addVehicle(electricCar)
    fleet.addVehicle(truck)

    fleet.displayFleetInfo()

    fleet.driveAllVehicles(100.0)
    println("\nFleet Information after driving 100 miles:")
    fleet.displayFleetInfo()
}
