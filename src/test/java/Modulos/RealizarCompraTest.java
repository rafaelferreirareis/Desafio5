package Modulos;

import Paginas.AdicionarProdutoCarrinhoPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@DisplayName("Teste de adição de produto ao carrinho de compra")
public class RealizarCompraTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        //Abrir Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\ChromeDriver100\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Maximizar o browser
        this.navegador.manage().window().maximize();

        //Definir um tempo de espera padrão de 5 seg
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a página da Amazon
        this.navegador.get("https://www.amazon.com.br/");
    }

    @Test
    @DisplayName("Incluir o produto no carrinho de compra")
    public void IncluiProdutoNoCarrinho(){
       String mensagemApresentada = new AdicionarProdutoCarrinhoPage(navegador)

                .selecionarProduto()
                .capturarMensagemApresentada();

                Assertions.assertEquals("Carrinho de compras", mensagemApresentada);
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }
}

