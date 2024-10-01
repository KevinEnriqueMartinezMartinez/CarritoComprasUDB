package org.example

class CarritoDeCompras {


    val items = mutableListOf<Pair<Producto, Int>>()

    fun agregarProducto(producto: Producto, cantidad: Int) {
        if (producto.cantidadDisponible >= cantidad) {
            items.add(Pair(producto, cantidad))
            producto.cantidadDisponible -= cantidad  // Reducir la cantidad disponible
            println("Se ha agregado $cantidad de '${producto.nombre}' al carrito.")
        } else {
            println("No hay Sufieciente Productos disponibles. Solo hay ${producto.cantidadDisponible} unidades en el inventario.")
        }
    }

    fun mostrarCarrito() {
        if (items.isEmpty()) {
            println("El carrito está vacío.")
        } else {
            println("Productos en el carrito:")
            items.forEachIndexed { index, (producto, cantidad) ->
                println("${index + 1}. ${producto.nombre} (x$cantidad) - Precio unitario: $${producto.precio} - Total: $${producto.precio * cantidad}")
            }

            // Mostrar el total al final
            val total = calcularTotal()
            println("************")
            println("Total del carrito: $$total")
            println("************")
        }
    }

    fun calcularTotal(): Double {
        return items.sumByDouble { (producto, cantidad) -> producto.precio * cantidad }
    }

    fun finalizarCompra() {
        val total = calcularTotal()
        if (total > 0) {
            println("* UDB TECHNOLOGY S.A de C.V. *")
            println("Ubicación: Frente a Plaza Salvador del Mundo")
            println("Contacto: 2413-7985 | udbtecnology@gmail.com")
            println("===============================")
            println("Detalles de la compra:")

            items.forEachIndexed { index, (producto, cantidad) ->
                println("${index + 1}. ${producto.nombre} (x$cantidad) - Precio unitario: $${producto.precio} - Total: $${producto.precio * cantidad}")

            }

            println("===============================")
            println("Total de la venta: $$total")
            println("===============================")
            println("Gracias por su compra.")
            println("* UDB TECHNOLOGY S.A de C.V***")

            items.clear()  // Limpia el carrito tras la compra
        } else {
            println("El carrito está vacío, no se puede finalizar la compra.")
        }
    }

    fun eliminarProducto(indice: Int) {
        if (indice in 1..items.size) {
            val productoEliminado = items.removeAt(indice - 1)
            println("Se ha eliminado '${productoEliminado.first.nombre}' del carrito.")
            productoEliminado.first.cantidadDisponible += productoEliminado.second  // Devolver stock al inventario
        } else {
            println("Índice inválido. Por favor, seleccione un número correcto.")
        }
    }

    // test comment

}