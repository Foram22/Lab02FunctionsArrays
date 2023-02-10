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