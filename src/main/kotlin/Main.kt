package org.example

fun main() {










    val carrito = CarritoDeCompras()
    var opcion: Int

    do {
        println("\n--- UDB TECHNOLOGY S.A de C.V ---")
        println("1. Ver productos")
        println("2. Agregar producto al carrito")
        println("3. Ver carrito")
        println("4. Eliminar producto del carrito")
        println("5. Finalizar compra")
        println("0. Salir")
        print("Elija una opción: ")
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                println("\nProductos disponibles:")
                productosDisponibles.forEach { producto ->
                    println("${producto.id}. ${producto.nombre} - $${producto.precio} (Cantidad disponible: ${producto.cantidadDisponible})")
                }
            }
            2 -> {
                print("Ingrese el ID del producto: ")
                val idProducto = readLine()?.toIntOrNull() ?: 0
                val productoSeleccionado = productosDisponibles.find { it.id == idProducto }

                if (productoSeleccionado != null) {
                    print("Ingrese la cantidad: ")
                    val cantidad = readLine()?.toIntOrNull() ?: 1
                    carrito.agregarProducto(productoSeleccionado, cantidad)
                } else {
                    println("Producto no encontrado.")
                }
            }










}