package org.example

class Producto {
    data class Producto(val id: Int, val nombre: String, val precio: Double)
}

package org.example

// Producto.kt
data class Producto(val id: Int, val nombre: String, val precio: Double, var cantidadDisponible: Int)
