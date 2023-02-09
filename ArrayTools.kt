// Foramben Jayeshkumar Patel
// Student ID:-  A00272251
/*  Program Description: This is a small kotlin command line application that has different function such as encryption (using Caesar Cipher), 
                         arrayAvg(average of elements), arrayContains(search value) and reverse(gives reversed array). Also, prints results of 
                         each function. */

fun main() {
    /* ---------------Perform Encryption--------------- */
    // Get String from user
    print("Enter any string that you want to encrypt: ")
    val plainText = readLine()
    // Get shift value from user
    print("Enter the shift value for encryption: ")
    val shiftValue = readLine()!!.toInt()
    // Get cipher text of given plain text and shift key using encrypt function.
    val encryptedString = encrypt(plainText, shiftValue)
    println("Encrypted string: $encryptedString")
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