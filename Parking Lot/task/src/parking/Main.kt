package parking

data class Car(val Registration: String, val Color: String)

fun status (parkingLot: Array<Car?>) {
    when {
        parkingLotSize == 0 -> println("Sorry, a parking lot has not been created.")
        carsInLot == 0 -> println("Parking lot is empty.")
        else -> {
            for (car in parkingLot) {
                if (car != null) println("${parkingLot.indexOf(car) + 1} ${car.Registration} ${car.Color}")
            }
        }
    }
}

var parkingLotSize = 0
var carsInLot = 0

fun main() {
    var parkingSpots = Array<Car?>(parkingLotSize) { null }

    while (true) {
        val input = readLine()!!.split(" ")
        when (input[0]) {
            "exit" -> break
            "create" -> {
                parkingLotSize = input[1].toInt()
                parkingSpots = Array(parkingLotSize) { null }
                carsInLot = 0
                println("Created a parking lot with ${input[1]} spots.")
            }
            "park" -> {
                if (parkingLotSize == 0) println("Sorry, a parking lot has not been created.") else {
                    val availableSpot = parkingSpots.indexOfFirst { car -> car == null }
                    when {
                        availableSpot < 0 -> {
                            println("Sorry, the parking lot is full.")
                        }
                        else -> {
                            parkingSpots[availableSpot] = Car(Registration = input[1], Color = input[2].toUpperCase())
                            carsInLot++
                            println("${input[2]} car parked in spot ${availableSpot + 1}.")
                        }
                    }
                }
            }
            "leave" -> {
                when {
                    parkingLotSize == 0 -> println("Sorry, a parking lot has not been created.")
                    parkingSpots[input[1].toInt() - 1] == null -> println("There is no car in spot ${input[1]}.")
                    else -> {
                        parkingSpots[input[1].toInt() - 1] = null
                        carsInLot --
                        println("Spot ${input[1]} is free.")
                    }
                }
            }
            "status" -> status(parkingSpots)
            "reg_by_color" -> {
                val regByColorList = mutableListOf<String>()
                if (parkingLotSize == 0) println("Sorry, a parking lot has not been created.") else {
                    for (car in parkingSpots) {
                        if (car != null && car.Color == input[1].toUpperCase()) {
                            regByColorList += car.Registration
                        }
                    }
                    if (regByColorList.isNotEmpty()) {
                        println(regByColorList.joinToString())
                    } else println("No cars with color ${input[1]} were found.")
                }
            }
            "spot_by_color" -> {
                val spotByColorList = mutableListOf<Int>()
                if (parkingLotSize == 0) println("Sorry, a parking lot has not been created.") else {
                    for (car in parkingSpots) {
                        if (car != null && car.Color == input[1].toUpperCase()) {
                            spotByColorList += parkingSpots.indexOf(car) + 1
                        }
                    }
                    if (spotByColorList.isNotEmpty()) {
                        println(spotByColorList.joinToString())
                    } else println("No cars with color ${input[1]} were found.")
                }

            }
            "spot_by_reg" -> {
                val spotByRegList = mutableListOf<Int>()
                if (parkingLotSize == 0) println("Sorry, a parking lot has not been created.") else {
                    for (car in parkingSpots) {
                        if (car != null && car.Registration == input[1]) spotByRegList += parkingSpots.indexOf(car) + 1
                    }
                    if (spotByRegList.isNotEmpty()) {
                        println(spotByRegList.joinToString())
                    } else println("No cars with registration number ${input[1]} were found.")
                }

            }
            else -> println("Sorry, a parking lot has not been created.")
        }
    }
}