#  Sistema de Gestión de Compras para Empresas - POO


**Materia:** Programación Orientada a Objetos  
**Autores:** Cristian Moscoso y Pablo Feijo

---

## Descripción

Este proyecto es un sistema integral de gestión de compras diseñado para empresas, que permite administrar proveedores, productos y solicitudes de manera eficiente. Está desarrollado en Java, utilizando principios de Programación Orientada a Objetos (POO) como herencia, encapsulamiento, polimorfismo y abstracción. Además, ofrece una interfaz gráfica intuitiva basada en AWT para facilitar la interacción con el usuario.

---

## Tabla de Contenidos


- Estructura del Proyecto  
- Funcionalidades Principales  
- Tecnologías y Principios Aplicados 
- Ejemplos de Código


---

### Instrucciones de Uso

- Compilar y ejecutar el archivo `Main.java`.  
- Navegar a través de menús jerárquicos para gestionar proveedores y productos.  
- Utilizar los formularios para la entrada de datos y los botones “Buscar” para filtrar proveedores por ID.  
- Visualizar los resultados en las áreas de texto diseñadas para tal fin.

---

##  Estructura del Proyecto

| Paquete / Clase            | Descripción breve                                               |
|---------------------------|----------------------------------------------------------------|
| **Main.java**             | Punto de entrada que inicia el `MenuPrincipal`.                |
| **SistemaDeCompras**      | Clase central que gestiona las listas de proveedores y productos. |
| **MenuPrincipal**         | Ventana inicial con botones para acceder a módulos principales.|
| **MenuProveedores**       | CRUD de proveedores, con búsqueda y asociación de productos.   |
| **MenuProductos**         | Formulario para creación de productos, con selección de categoría e IVA. |
| **Proveedor**             | Entidad que hereda de Usuario, contiene lista de productos asociados. |
| **Producto**              | Clase abstracta que define métodos para el cálculo de precios. |
| **ProductoIva / ProductoNoIva** | Implementaciones concretas que manejan productos con o sin IVA (polimorfismo). |
| **CategoriaProducto**     | Enum que define categorías: HARDWARE, OFICINA, LIMPIEZA.       |
| **Estado**                | Enum para estados de solicitudes: REVISION, APROBADA, RECHAZADA.|
| **Departamento**          | Enum que representa áreas de la empresa como RRHH, Finanzas, etc.|

---

##  Funcionalidades Principales

### Gestión de Proveedores

- Registro y búsqueda de proveedores por ID.  
- Visualización de lista completa con detalles (nombre, teléfono, correo).  
- Asociación de productos a proveedores.

### Gestión de Productos

- Creación de productos con o sin IVA (15%).  
- Clasificación por categorías (hardware, oficina, limpieza).  
- Validación para evitar productos duplicados.  
- Cálculo automático de precios finales (base + IVA si aplica).

### Interfaz Gráfica

- Menús jerárquicos: principal, proveedores, productos.  
- Formularios para la entrada de datos.  
- Visualización de resultados en áreas de texto.

### Persistencia de Datos

- Los datos se mantienen en memoria durante la ejecución del programa.

---

##  Tecnologías y Principios Aplicados

- **Java AWT:** Utilizado para la implementación de la interfaz gráfica.  
- **Programación Orientada a Objetos (POO):**  
  - *Herencia:* ProductoIva y ProductoNoIva extienden la clase abstracta Producto.  
  - *Abstracción:* Producto define el método abstracto `calcularPrecio()`.  
  - *Encapsulamiento:* Uso de atributos privados con getters y setters.  
  - *Polimorfismo:* Implementación distinta del cálculo de precios según tipo de producto.  
  - *Enums:* Para definir categorías, estados y departamentos, mejorando la legibilidad y control de valores.

---

##  Ejemplos de Código (Resumen conceptual)

- Clase abstracta `Producto` con método abstracto para cálculo de precio.  
- Clases concretas `ProductoIva` y `ProductoNoIva` que implementan el cálculo considerando o no el IVA.  
- Uso de enums para manejar categorías de productos y estados de las solicitudes.  
- Interfaces gráficas basadas en menús y formularios para facilitar la interacción.

---


> Autores: Cristian Moscoso y Pablo Feijo · Universidad Politecnica Salesiana · 2025
