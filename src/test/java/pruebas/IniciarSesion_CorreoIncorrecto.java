package pruebas;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IniciarSesion_CorreoIncorrecto {

    WebDriver driver;

    @BeforeTest
    public void abrirNavegador() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(
            "https://practicetestautomation.com/practice-test-login/"
        );
    }

    @Test
    public void iniciarSesionCorreoIncorrecto() {

        // Escribir usuario incorrecto
        driver.findElement(By.id("username"))
              .sendKeys("usuarioIncorrecto");

        // Escribir contraseña
        driver.findElement(By.id("password"))
              .sendKeys("Password123");

        // Presionar botón de inicio de sesión
        driver.findElement(By.id("submit")).click();

        // Obtener el mensaje de error
        WebElement mensajeError =
                driver.findElement(By.id("error"));

        String resultadoActual = mensajeError.getText();

        String resultadoEsperado =
                "Your username is invalid!";

        // Verificación del resultado esperado
        Assert.assertEquals(
                resultadoActual,
                resultadoEsperado,
                "El mensaje de error no es el esperado."
        );
    }

    @AfterTest
    public void cerrarNavegador() {

        if (driver != null) {
            driver.quit();
        }
    }
}