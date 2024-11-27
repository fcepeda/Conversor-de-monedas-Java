<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Aplicación de consola en Java para convertir monedas usando la API ExchangeRate-API.">
</head>
<body>
    <header>
        <h1>Conversor de Moneda 🪙💱</h1>
        <p>Aplicación de consola en <strong>Java</strong> que permite realizar conversiones entre distintas monedas utilizando la API <a href="https://www.exchangerate-api.com/" target="_blank">ExchangeRate-API</a>.</p>
    </header>
    <hr>
    <main>
        <section>
            <h2>Características 🚀</h2>
            <ul>
                <li>Conversión entre monedas comunes:
                    <ul>
                        <li>Dólar (USD) ⇔ Peso Chileno (CLP)</li>
                        <li>Dólar (USD) ⇔ Peso Argentino (ARS)</li>
                    </ul>
                </li>
                <li>Soporte para monedas personalizadas: permite ingresar códigos de moneda según los estándares ISO 4217.</li>
                <li>Historial de conversiones: registra cada operación realizada con su respectiva fecha y hora.</li>
                <li>Interfaz simple en consola: menús e interacciones fáciles de entender.</li>
            </ul>
        </section>
        <hr>
        <section>
            <h2>Tecnologías Utilizadas 🛠️</h2>
            <ul>
                <li><strong>Lenguaje:</strong> Java 17.</li>
                <li><strong>API:</strong> <a href="https://www.exchangerate-api.com/" target="_blank">ExchangeRate-API</a> para obtener los tipos de cambio actuales.</li>
                <li><strong>Clases:</strong>
                    <ul>
                        <li><code>LocalDateTime</code> para gestionar fechas.</li>
                        <li><code>DateTimeFormatter</code> para formatear las fechas.</li>
                    </ul>
                </li>
            </ul>
        </section>
        <hr>
        <section>
            <h2>Requisitos del Sistema 🖥️</h2>
            <ul>
                <li>Java Runtime Environment (JRE) instalado en tu máquina.</li>
                <li>Conexión a Internet (para consultar los tipos de cambio de la API).</li>
                <li>Editor de código (como IntelliJ IDEA, Eclipse o Visual Studio Code).</li>
            </ul>
        </section>
        <hr>
        <section>
            <h2>Instalación 📥</h2>
            <ol>
                <li>Clona el repositorio desde GitHub:
                    <pre><code>git clone https://github.com/tu-usuario/conversor-moneda.git</code></pre>
                </li>
                <li>Navega al directorio del proyecto:
                    <pre><code>cd conversor-moneda</code></pre>
                </li>
                <li>Compila los archivos del proyecto:
                    <pre><code>javac ConversorMoneda.java</code></pre>
                </li>
                <li>Ejecuta el programa:
                    <pre><code>java ConversorMoneda</code></pre>
                </li>
            </ol>
        </section>
        <hr>
        <section>
            <h2>Uso 📘</h2>
            <p>Al iniciar el programa, verás un menú como este:</p>
            <pre>
**********************************

Sea bienvenido/a al Conversor de Moneda =)

1) Dólar ==>> Peso Chileno
2) Peso Chileno ==>> Dólar
3) Dólar ==>> Peso Argentino
4) Peso Argentino ==>> Dólar
5) Otros países
6) Revisar historial
7) Salir

**********************************
 </pre>
<p>Selecciona una opción del menú y sigue las instrucciones en pantalla para realizar la conversión.</p>
 </section>
 <hr>
        <section>
            <h2>Ejemplo de Uso 📂</h2>
            <p>A continuación, se muestran ejemplos de cómo funciona el programa:</p>
            <h3>Conversión estándar</h3>
            <pre>
> Ingrese su elección: 1
> Ingrese el valor a convertir: 100
El valor 100[USD] corresponde al valor final de >>> 90000[CLP]
Historial actualizado: El valor 100[USD] corresponde al valor final de >>> 90000[CLP] | 2024-11-26 14:30:45
            </pre>
            <h3>Conversión personalizada ingresando códigos de país</h3>
            <pre>
> Ingrese su elección: 5
> Ingrese el código de moneda del país proveniente: EUR
> Ingrese el código de moneda del país a convertir: JPY
> Ingrese el valor a convertir: 50
El valor 50[EUR] corresponde al valor final de >>> 8000[JPY]
Historial actualizado: El valor 50[EUR] corresponde al valor final de >>> 8000[JPY] | 2024-11-26 14:32:12
            </pre>
            <p>En este caso, el usuario selecciona la opción 5 para realizar una conversión personalizada, ingresa los códigos de moneda <code>EUR</code> (Euro) y <code>JPY</code> (Yen japonés), e indica que desea convertir 50 Euros. El programa muestra el resultado y actualiza el historial.</p>
        </section>
        <hr>
        <section>
            <h2>Próximos Pasos 🚧</h2>
            <ul>
                <li>Implementar una interfaz gráfica (GUI) para una mejor experiencia de usuario.</li>
                <li>Guardar el historial de conversiones en un archivo (JSON o CSV).</li>
                <li>Expandir el soporte para más monedas y opciones de conversión.</li>
            </ul>
        </section>
        <section>
            <h2>Contacto 📧</h2>
            <p>Si tienes dudas o sugerencias, no dudes en contactarme:</p>
            <ul>
                <li><strong>Autor:</strong> Francisco Cepeda Venegas (Lhite)</li>
                <li><strong>Email:</strong> lhite123@gmail.com.com</li>
                <li><strong>Portafolio:</strong> <a href="https://itch.io/lhite" target="_blank">itch.io/lhite</a></li>
            </ul>
        </section>
    </main>
</body>
</html>
