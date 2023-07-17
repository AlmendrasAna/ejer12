package com.example.ejer12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    var user = mutableListOf<User>()
    var numNewUser: String
    do {
        println("Ingrese la cantidad de usuarios")
        numNewUser = readln()
    } while (!(numNewUser.matches(Regex("^[+]?[0-9]{1,3}$"))))


    for (i in 1..numNewUser.toInt()) {
        user.add(getUser())
    }

    for (users in user.sortedBy { it.age }) {
        println(users)
    }

}


data class User(
    var name: String, var lastname: String, var age: Int, var email: String,
    var sistemaSalud: String
)

fun getUser(): User {
    var name: String
    var lastname: String
    var age: String
    var email: String
    var sistemaSalud: String


    do {
        println("Ingrese nombre")
        name = readln()
    } while (!(name.length in 1..20 && name.matches(Regex("^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+$"))))

    do {
        println("Ingrese apellido")
        lastname = readln()
    } while (!(lastname.matches(Regex("^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+$"))))

    do {
        println("Ingrese edad")
        age = readln()

    } while (!(age.matches(Regex("^[+]?[0-9]{1,3}$"))))

    do {
        println("Ingrese email")
        email = readln()
    } while (!(email.length > 1 && email.contains(Regex("^\\S+@\\S+\\.\\S+$"))))

    do {
        println("Ingrese sistema de salud FONASA, ISAPRE,PARTICULAR")
        sistemaSalud = readln().uppercase()
    } while (sistemaSalud !in listOf("FONASA", "ISAPRE", "PARTICULAR"))

    var newUser = User(name, lastname, age.toInt(), email, sistemaSalud)
    return newUser
}