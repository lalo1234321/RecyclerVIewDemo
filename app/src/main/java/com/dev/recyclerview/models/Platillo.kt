package com.dev.recyclerview.models

class Platillo(nombre:String, precio:Double, rating:Float, foto:Int) {

    var nombre:String = ""
    var precio:Double = 0.0
    var rating:Float = 0.0F
    var foto:Int = 0
    init {
        this.nombre = nombre
        this.precio = precio
        this.rating = rating
        this.foto = foto
    }

}