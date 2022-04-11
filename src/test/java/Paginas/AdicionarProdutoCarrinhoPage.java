package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AdicionarProdutoCarrinhoPage {
    private WebDriver navegador;

    public AdicionarProdutoCarrinhoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public CarrinhoDeComprasPage selecionarProduto (){
        //Selecionando o menu ELETRÔNICOS
        navegador.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[9]")).click();

        //Selecionando o menu CELULARES E COMUNICAÇÃO
        navegador.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[1]/ul/li[6]/span/a/span")).click();

        //Selecionando o menu CELULARES E SMARTPHONES
        navegador.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[1]/ul/li[4]/span/a/span")).click();

        //Selecionando o menu APPLE
        navegador.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[17]/ul/li[3]/span/a/div/label/i")).click();

        //Clicando na opção "ANAZON INDICA", assim ele pegará sempre o primeiro produto indicado
        navegador.findElement(By.xpath("//*[@id=\"B09BG1CZ68-amazons-choice-label\"]/span")).click();

        //Adicionando ao carrinho
        navegador.findElement(By.id("add-to-cart-button")).click();

        //Respondendo NÃO OBRIGADO, na oferta de seguro contra roubo caso apareça essa opção
        if (navegador.findElement(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input")).isDisplayed()){
            navegador.findElement(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input")).click();
        }

        //Aguardando o elemento "IR PARA O CARRINHO" ficar clicável
        WebElement firstResult = new WebDriverWait(navegador, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sw-gtc\"]/span/a")));

        //Clicando no campo "IR PARA O CARRINHO"
        navegador.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();

        //Retornando para a pagina seguinte CARRINHO DE COMPRAS
        return new CarrinhoDeComprasPage(navegador);
    }
}