package pruebas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IniciarSesion_CredencialesCorrectas {

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
    public void iniciarSesionCredencialesCorrectas() {

        // Escribir usuario correcto
        driver.findElement(By.id("username"))
              .sendKeys("student");

        // Escribir contraseña correcta
        driver.findElement(By.id("password"))
              .sendKeys("Password123");

        // Presionar botón de inicio de sesión
        driver.findElement(By.id("submit")).click();

        // Obtener la URL actual
        String urlActual = driver.getCurrentUrl();

        // Verificación del resultado esperado
        Assert.assertTrue(
                urlActual.contains("logged-in-successfully"),
                "El inicio de sesión no fue exitoso."
        );

        // Verificar que aparezca el botón Log out
        boolean botonSalirVisible =
                driver.findElement(By.linkText("Log out"))
                      .isDisplayed();

        Assert.assertTrue(
                botonSalirVisible,
                "El botón Log out no está visible."
        );
    }

    @AfterTest
    public void cerrarNavegador() {

        if (driver != null) {
            driver.quit();
        }
    }
}