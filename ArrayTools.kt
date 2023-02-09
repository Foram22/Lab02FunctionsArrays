// Foramben Jayeshkumar Patel
// Student ID:-  A00272251
/*  Program Description: This is a small kotlin command line application that has different function such as encryption (using Caesar Cipher), 
                         arrayAvg(average of elements), arrayContains(search value) and reverse(gives reversed array). Also, prints results of 
                         each function. */

fun main() {
    /* ---------------Perform Encryption--------------- */
    // Get String from user
    val plainText = checkStringUserInput("Enter any string that you want to encrypt: ")
    // Get shift value from user
    val shiftValue = checkIntUserInput("Enter the shift value for encryption: ")
    // Get cipher text of given plain text and shift key using encrypt function.
    val encryptedString = encrypt(plainText, shiftValue)
    println("Encrypted string: $encryptedString")
}

// Check entered value is integer or not
fun checkIntUserInput(message: String): Int {
    var userInput = 0
    var isValid = false
    while(!isValid){
        print(message)
        val stringInput = readLine()
        try {
            userInput = stringInput!!.toInt()
            isValid = true
        }
        catch(e: Exception) {
            println("Please enter valid shift value.\n")
        }
    }

    return userInput
}

// Check entered value contains only alphabets or not
fun checkStringUserInput(message: String): String {
    var stringInput = ""
    var isValid = false
    while(!isValid){
        print(message)
        stringInput = readLine()!!
        if(!stringInput.matches("^[0-9]*$".toRegex())){
            isValid = true
        }else{
            println("Please enter valid string value.\n")
        }
    }

    return stringInput
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