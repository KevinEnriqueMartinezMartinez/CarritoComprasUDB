package org.example

class CarritoDeCompras {



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
}