package org.example

fun main() {
    val productosDisponibles = listOf(
        Producto(1, "Laptop", 850.0, 10),
        Producto(2, "Mouse inalámbrico", 30.0,25),
        Producto(3, "Teclado mecánico", 75.0, 15),
        Producto(4, "Monitor 24 pulgadas", 200.0, 8),
        Producto(5, "Disco Duro SSD 500GB", 120.0, 12),
        Producto(6, "Audífonos Bluetooth", 55.0, 20)
    )










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
                    println("${producto.id}. ${producto.nombre} - $${producto.precio}")
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
            3 -> carrito.mostrarCarrito()
            4 -> {
                carrito.mostrarCarrito()
                if (carrito.items.isNotEmpty()) {
                    print("Ingrese el número del producto a eliminar: ")
                    val indiceProducto = readLine()?.toIntOrNull() ?: 0
                    carrito.eliminarProducto(indiceProducto)
                }
            }
            5 -> carrito.finalizarCompra()
            0 -> println("Gracias por visitar UDB Technology.")
            else -> println("Opción no válida. Intente de nuevo.")
        }
    } while (opcion != 0)










}