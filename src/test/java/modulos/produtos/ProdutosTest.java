package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void BeforeEach(){

        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        this.navegador.manage().window().maximize();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }
    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .InformarNomeDoProduto("MacBook Pro")
                .InformarValorDoProduto("000")
                .InformarCoresDoProduto("preto,azul")
                .submeterFormularioDeAdicaoComErro()
                .captuarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }
    @Test
    @DisplayName("Não é permitido registrar um produto com valor maior que 70000")
    public void testNaoEPermitidoRegistrarProdutoComValorMaiorQueSeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .InformarNomeDoProduto("Iphone")
                .InformarValorDoProduto("700001")
                .InformarCoresDoProduto("preto,branco")
                .submeterFormularioDeAdicaoComErro()
                .captuarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam na faixa de 0,01 e 7000,01")
    public void testPossoAdicionarProdutosComValorDeUmCentavoASeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .InformarNomeDoProduto("MacBook Pro")
                .InformarValorDoProduto("90000")
                .InformarCoresDoProduto("preto,branco")
                .submeterFormularioDeAdicaoComSucesso()
                .captuarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @Test
    @DisplayName("Posso adicionar produtos que esteja no limite 0,01")
    public void testPossoAdicionarProdutosComValorDeUmCentavo() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .InformarNomeDoProduto("MacBook Pro")
                .InformarValorDoProduto("001")
                .InformarCoresDoProduto("preto,branco")
                .submeterFormularioDeAdicaoComSucesso()
                .captuarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
}

    @Test
    @DisplayName("Posso adicionar produtos que esteja no limite de 7000")
    public void testPossoAdicionarProdutosComValorDeUmSeteMil() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .InformarNomeDoProduto("MacBook Pro")
                .InformarValorDoProduto("700000")
                .InformarCoresDoProduto("preto,branco")
                .submeterFormularioDeAdicaoComSucesso()
                .captuarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @AfterEach
    public void afterEach(){
       navegador.quit();
    }
}
