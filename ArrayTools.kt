// Foramben Jayeshkumar Patel
// Student ID:-  A00272251
/*  Program Description: This is a small kotlin command line application that has different function such as encryption (using Caesar Cipher), 
                         arrayAvg(average of elements), arrayContains(search value) and reverse(gives reversed array). Also, prints results of 
                         each function. */

import kotlin.random.Random
fun main() {
    /* ---------------Perform Encryption--------------- */
    // Get String from user
    val plainText = checkUserInput("Enter any string that you want to encrypt: ")
    // Get shift value from user
    val shiftValue = checkUserInput("Enter the shift value for encryption: ")
    // Get cipher text of given plain text and shift key using encrypt function.
    val encryptedString = encrypt(plainText, shiftValue.toInt())
    println("Encrypted string: $encryptedString")


    /* ---------------Perform Average--------------- */
    // Create array of 10 elements with random integers.
    val randomArray = IntArray(10) { Random.nextInt(0,100) }
    // Get the average of elements in the given array using arrayAvg function.
    val average = arrayAvg(randomArray)
    println("\nAverage of elements in array: $average")


    /* ---------------Perform Search--------------- */
    // Search array created from which value can be check if it exists or not in it.
    val searchArray = arrayOf<String> ("Sunday", "Monday", "Tuesday","Wednesday", "Thurday", "Friday", "Saturday")
    // Get search value from user
    print("\nPlease enter any value that you want to search from the given array: ")
    val searchValue = readLine()!!
    // arrayContains function that will return boolean value depending on whether search value is in the searchArray or not.
    val isContains = arrayContains(searchArray, searchValue)
    // Prints result
    if(isContains) {
        println("$searchValue is exist in the given array.")
    }else{
        println("$searchValue is not exist in the given array.")
    }
}

// This function takes value from user
fun checkUserInput(isInt: Boolean, message: String): String {
    var userInput = ""
    var isValid = false
    while(!isValid){
        print(message)
        val stringInput = readLine()
        if(isInt){
            try {
                val inputValue = stringInput!!.toInt()
                userInput = inputValue.toString()
                isValid = true
            }
            catch(e: Exception) {
                println("Please enter valid shift value.")
            }
        }else{
            userInput = stringInput!!
            if(!stringInput.matches("^[0-9]*$".toRegex())){
                isValid = true
            }else{
                println("Please enter valid string value.")
            }
        }
    }

    return userInput
}

// This function takes plain text and shift key and return cipher text by performing caesar cipher
fun encrypt(plainText: String, shiftValue: Int): String {
    var cipherText = ""
    for (i in 0 until plainText.length) {
        if(plainText[i].isUpperCase()){
            val character = (plainText[i].code + shiftValue - 65) % 26 + 65
            cipherText += character.toChar()
        }else{
            val character = (plainText[i].code + shiftValue - 97) % 97 + 97
            cipherText += character.toChar()
        }
    }
    return cipherText
}

// This function takes integer array as a parameter and return average of elements
fun arrayAvg(randomArray: IntArray): Double {
    var average = 0.0
    var printArray = ""
    print("\nOriginal array: [")
    for (i in randomArray){
        printArray += "$i, "
        average += i
    }
    printArray = printArray.dropLast(2)
    print("$printArray]")
    return average / randomArray.size
}

// This function checks whether string value is exists in the given array or not
fun arrayContains(searchArray: Array<String>, searchValue: String): Boolean {
    var result = false
    for (i in searchArray){
        if(searchValue.lowercase() == i.lowercase()){
            result = true
            return result
        }
    }
    return result
}