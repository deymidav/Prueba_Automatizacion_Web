package com.nttdata.page;

import org.openqa.selenium.By;

public class CartPage {
    public static By cartTitle = By.tagName("h1");
    public static By cartUnitPrice = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span"); // Precio unitario
    public static By cartQuantity = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input"); // Cantidad
    public static By cartTotalAmount = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span"); // Total
    public static By finalizeCartPurchase = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a");
}
