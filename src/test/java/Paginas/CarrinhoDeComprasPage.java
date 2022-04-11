package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoDeComprasPage {
    private WebDriver navegador;

    public CarrinhoDeComprasPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    //Método para Guardar a mensagem que comprova a adição do produto no carrinho de compras
    public String capturarMensagemApresentada(){
        return navegador.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div/h1")).getText();
    }
}