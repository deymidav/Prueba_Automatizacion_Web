package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CartSteps;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;

public class CartStepsDef {
    private WebDriver driver;
    private CartSteps cartSteps;

    public CartStepsDef() {
        this.driver = getDriver();
        this.cartSteps = new CartSteps(driver);
    }
    @Entonces("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        String actualTitle = cartSteps.getCartTitle();
        Assertions.assertEquals("carrito", actualTitle.toLowerCase(),
                "El título de la página no es el esperado. Obtenido: " + actualTitle);
    }

    @Y("vuelvo a validar el calculo de precios en el carrito.")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        cartSteps.validateCartTotal();
        cartSteps.finalizePurchase();
    }
}
