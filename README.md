# Sistema de Gestión de Compras para Empresas - POO

**Materia:** Programación Orientada a Objetos  
**Autores:** Cristian Moscoso y Pablo Feijo

---

## Descripción

Este proyecto es un sistema integral de gestión de compras diseñado para empresas, que permite administrar proveedores, productos, solicitudes y usuarios de manera eficiente. Está desarrollado en Java, utilizando principios de Programación Orientada a Objetos (POO) como herencia, encapsulamiento, polimorfismo y abstracción. Además, ofrece una interfaz gráfica intuitiva basada en AWT para facilitar la interacción con el usuario.

---

## Tabla de Contenidos

- Estructura del Proyecto  
- Funcionalidades Principales  
- Tecnologías y Principios Aplicados  
- Ejemplos de Código

---

### Instrucciones de Uso

- Compilar y ejecutar el archivo `Main.java`.  
- Navegar a través de menús jerárquicos para gestionar proveedores, productos y solicitudes.  
- Utilizar los formularios para la entrada de datos y los botones “Buscar” para filtrar registros por ID.  
- Visualizar los resultados en las áreas de texto diseñadas para tal fin.

---

## Estructura del Proyecto

| Paquete / Clase                     | Descripción breve                                               |
|-----------------------------------|----------------------------------------------------------------|
| **Main.java**                      | Punto de entrada que inicia el `MenuPrincipal`.                |
| **SistemaDeCompras**               | Clase central que gestiona listas de proveedores, productos y solicitudes. |
| **MenuPrincipal**                  | Ventana inicial con botones para acceder a módulos principales.|
| **MenuProveedores**                | CRUD de proveedores, con búsqueda y asociación de productos.   |
| **MenuProductos**                  | Formulario para creación de productos, con selección de categoría e IVA. |
| **Proveedor**                     | Entidad que hereda de Usuario, contiene lista de productos asociados. |
| **Usuario**                      | Clase base que representa usuarios con atributos básicos (id, nombre, teléfono, correo). |
| **Producto**                     | Clase abstracta que define métodos para el cálculo de precios. |
| **ProductoIva / ProductoNoIva**  | Implementaciones concretas que manejan productos con o sin IVA (polimorfismo). |
| **CategoriaProducto**            | Enum que define categorías: HARDWARE, OFICINA, LIMPIEZA.       |
| **Estado**                      | Enum para estados de solicitudes: REVISION, APROBADA, RECHAZADA.|
| **Departamento**                | Enum que representa áreas de la empresa como RRHH, Finanzas, etc.|
| **clases.solicitudes.Solicitante** | Representa al solicitante de una compra, con datos personales y departamento. |
| **clases.solicitudes.DetalleSolicitud** | Detalle de productos solicitados, con cantidad y justificación. |
| **clases.solicitudes.SolicitudCompra** | Maneja las solicitudes de compra, estado, detalles y cálculo de costo total. |
| **interfaces.Calculable**        | Interfaz que define el método para calcular el costo total de una solicitud de compra. |

---

## Funcionalidades Principales

### Gestión de Proveedores

- Registro y búsqueda de proveedores por ID.  
- Visualización de lista completa con detalles (nombre, teléfono, correo).  
- Asociación de productos a proveedores.

### Gestión de Productos

- Creación de productos con o sin IVA (15%).  
- Clasificación por categorías (hardware, oficina, limpieza).  
- Validación para evitar productos duplicados.  
- Cálculo automático de precios finales (base + IVA si aplica).

### Gestión de Solicitudes

- Registro de solicitantes con información personal y departamento.  
- Creación de solicitudes de compra con múltiples detalles (productos, cantidades, justificaciones).  
- Control y transición de estados de solicitud (En revisión, aprobada, rechazada).  
- Cálculo automático del costo total de cada solicitud (sumatoria de subtotales).  
- Implementación de interfaz `Calculable` para estandarizar el cálculo de costos.

### Interfaz Gráfica

- Menús jerárquicos: principal, proveedores, productos, solicitudes.  
- Formularios para la entrada de datos.  
- Visualización de resultados en áreas de texto.

### Persistencia de Datos

- Los datos se mantienen en memoria durante la ejecución del programa.

---

## Tecnologías y Principios Aplicados

- **Java AWT:** Utilizado para la implementación de la interfaz gráfica.  
- **Programación Orientada a Objetos (POO):**  
  - *Herencia:* ProductoIva y ProductoNoIva extienden la clase abstracta Producto; Proveedor hereda de Usuario.  
  - *Abstracción:* Producto define el método abstracto `calcularPrecio()`.  
  - *Encapsulamiento:* Uso de atributos privados con getters y setters en todas las clases.  
  - *Polimorfismo:* Implementación distinta del cálculo de precios según tipo de producto.  
  - *Interfaces:* `Calculable` para definir el método de cálculo de costos en solicitudes.  
  - *Enums:* Para definir categorías, estados y departamentos, mejorando la legibilidad y control de valores.

---
## Video Explicativo del programa
https://youtu.be/vhrHu_zfygg


## Ejemplos de Código (Resumen conceptual)

- Clase abstracta `Producto` con método abstracto para cálculo de precio.  
- Clases concretas `ProductoIva` y `ProductoNoIva` que implementan el cálculo considerando o no el IVA.  
- Clases `Solicitante`, `DetalleSolicitud` y `SolicitudCompra` para la gestión de compras con métodos para agregar detalles, calcular costos y cambiar estados.  
- Interfaz `Calculable` implementada por `SolicitudCompra` para estandarizar el cálculo total.  
- Uso de enums para manejar categorías de productos, departamentos y estados de solicitudes.  
- Interfaces gráficas basadas en menús y formularios para facilitar la interacción.

---

> Autores: Cristian Moscoso y Pablo Feijo · Universidad Politécnica Salesiana · 2025
