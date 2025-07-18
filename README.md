# 💱 Conversor de Monedas - Challenge

Este proyecto es un challenge académico donde se construye una aplicación de consola en Java que permite convertir montos entre distintas monedas utilizando una API externa de tipo de cambio.

---

## 📖 Descripción

La aplicación permite al usuario:

- Ingresar un código de moneda base (por ejemplo: USD)
- Ingresar un código de moneda destino (por ejemplo: COP)
- Ingresar una cantidad a convertir

El sistema valida las entradas y luego realiza la conversión utilizando una API pública. Además, maneja posibles errores como datos inválidos o fallas en la conexión.

---

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Java
- **Versión:** OpenJDK 21
- **Formato:** Aplicación de consola
- **Librerías externas:**
    - `Gson` para parseo de JSON

---

## 🚀 ¿Cómo ejecutar el proyecto?

1. Clona o descarga el repositorio:

   ```bash
   git clone https://github.com/luvalenciaq/conversor-monedas.git

2. Abre el proyecto en tu IDE favorito (IntelliJ, VS Code con soporte Java, Eclipse, etc.).
3. Asegúrate de tener el SDK de Java 21 configurado.
4. Ejecuta la clase principal (Principal.java) para iniciar el menú.

## 🎯 Funcionalidades

- Menú interactivo por consola
- Validación de entradas del usuario:
  - El código de moneda debe contener exactamente 3 letras (A-Z)
  - La cantidad debe ser un número positivo
- Llamado a API pública con los parámetros ingresados
- Manejo de errores
- Posibilidad de realizar múltiples conversiones hasta que el usuario decida salir

## 🌐 API utilizada

 ExchangeRate API

## 📸 Ejemplo de uso

********** Bienvenido al conversor de monedas ***********

Códigos de las monedas:
USD - Dólar estadounidense
EUR - Euro
...

Ingresa el código de la moneda base (ej: USD): usd
Ingresa el código de la moneda a convertir (ej: COP): cop
Ingresa la cantidad a convertir: 100

Resultado:
100 USD equivalen a 403000 COP


## 🎓 Challenge académico

Este proyecto fue desarrollado como parte de un ejercicio práctico para afianzar conocimientos en:

- Consumo de APIs externas con HttpClient 
- Manejo de excepciones 
- Separación de lógica en clases (MVC simplificado)










   

