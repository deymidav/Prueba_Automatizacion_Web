package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.ProductSteps;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;

public class LoginStepsDef {
    private WebDriver driver;
    private LoginSteps loginSteps;
    private ProductSteps productSteps;

    @Before
    public void setup() {
        this.driver = getDriver();
        this.loginSteps = new LoginSteps(driver);
        this.productSteps = new ProductSteps(driver);
    }

    @Cuando("me logueo con mi usuario {string} y clave {string}")
    public void inicio_sesion_con_las_credenciales(String user, String password) {
        loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        if (!productSteps.isLoginSuccessful()) {
            throw new AssertionError("Fallo en la autenticación");
        }
    }
}
