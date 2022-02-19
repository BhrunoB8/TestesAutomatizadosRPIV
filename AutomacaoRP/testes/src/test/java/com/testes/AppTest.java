package com.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
/**
 * Unit test for simple App.
 */
public class AppTest 
{   
    Robot robot;
    WebDriver driver;
    @Before
    public void criarDriver() throws AWTException{
        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://rp4-revista.herokuapp.com/");
        driver.manage().window().maximize();
        robot = new Robot();
    }

    @Test
    public void loginVazio(){
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("btnSubmitLog")).click();
        String result = driver.findElement(By.className("card-header")).getText();
        assertEquals("Login", result);
        //Não consigo pegar o modal "Preencha este campo."
    }

    @Test
    public void cadastroVazio() throws InterruptedException{
        driver.findElement(By.id("Btnregistro")).click();
        driver.findElement(By.id("endereco")).sendKeys("Rua Gaspar Silveira Martins");
        Thread.sleep(500);
        driver.findElement(By.id("btnRegister")).click();
        String result = driver.findElement(By.className("invalid-feedback")).getText();
        assertEquals("O campo name é obrigatório.", result);
        
    }
    @Test
    public void emailSemArrolba() throws InterruptedException{
        driver.findElement(By.id("Btnregistro")).click();
        driver.findElement(By.id("name")).sendKeys("Bhruno");
        driver.findElement(By.id("email")).sendKeys("joseyahoo.com.br");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("password-confirm")).sendKeys("123123123");
        driver.findElement(By.id("endereco")).sendKeys("Rua Gaspar Silveira Martins");
        driver.findElement(By.id("telefone")).sendKeys("5551995171978");
        Thread.sleep(500);
        driver.findElement(By.id("btnRegister")).click();
        String result = driver.findElement(By.className("card-header")).getText();
        assertEquals("Registrar Usuário", result);
    }

    @Test
    public void altVazioAutor() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("thiago@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        Thread.sleep(500);
        driver.findElement(By.id("Autor")).click();
        Thread.sleep(500);
        driver.findElement(By.id("gerenciarAutor")).click();
        driver.findElement(By.id("editarAutor")).click();
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("endereco")).clear();
        driver.findElement(By.id("telefone")).clear();
        driver.findElement(By.id("instituicao")).clear();

        //ZOOM OUT
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);

        Thread.sleep(2000);
        driver.findElement(By.id("salvar")).click();
        String result = driver.findElement(By.className("text-center")).getText();
        assertEquals("Edição de autor", result);
    }

    @Test
    public void altVazioAvaliador() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("avaliador@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        Thread.sleep(500);
        driver.findElement(By.id("Avaliador")).click();
        Thread.sleep(500);
        driver.findElement(By.id("gerenciarAvaliador")).click();
        driver.findElement(By.id("editarAvaliador")).click();
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("endereco")).clear();
        driver.findElement(By.id("telefone")).clear();
        driver.findElement(By.id("salvar")).click();
        String result = driver.findElement(By.id("erroNome")).getText();
        assertEquals("O campo nome é obrigatório.", result);
        
    } 

    @Test
    public void altVazioEditor() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("editor@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        Thread.sleep(500);
        driver.findElement(By.id("Editor")).click();
        Thread.sleep(500);
        driver.findElement(By.id("gerenciarEditor")).click();
        driver.findElement(By.id("editarEditor")).click();
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("telefone")).clear();
        driver.findElement(By.id("endereco")).clear();
        driver.findElement(By.id("salvar")).click();
        String result = driver.findElement(By.id("erroNome")).getText();
        assertEquals("O campo nome é obrigatório.", result);

    }

    @Test
    public void altInvalidoAutor() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("thiago@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        Thread.sleep(500);
        driver.findElement(By.id("Autor")).click();
        Thread.sleep(500);
        driver.findElement(By.id("gerenciarAutor")).click();
        driver.findElement(By.id("editarAutor")).click();
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("B");
        driver.findElement(By.id("endereco")).clear();
        driver.findElement(By.id("endereco")).sendKeys("TesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTeste");
        driver.findElement(By.id("telefone")).clear();
        driver.findElement(By.id("telefone")).sendKeys("5195171978");
        driver.findElement(By.id("instituicao")).clear();

        //ZOOM OUT
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);

        Thread.sleep(1500);
        driver.findElement(By.id("salvar")).click();
        String result = driver.findElement(By.className("text-center")).getText();
        assertEquals("Edição de autor", result);
    }

    @Test
    public void altInvalidoAvaliador() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("avaliador@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        Thread.sleep(500);
        driver.findElement(By.id("Avaliador")).click();
        Thread.sleep(500);
        driver.findElement(By.id("gerenciarAvaliador")).click();
        driver.findElement(By.id("editarAvaliador")).click();
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("B");
        driver.findElement(By.id("endereco")).clear();
        driver.findElement(By.id("endereco")).sendKeys("TesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTeste");
        driver.findElement(By.id("telefone")).clear();
        driver.findElement(By.id("telefone")).sendKeys("5195171978");
        driver.findElement(By.id("salvar")).click();
        String result = driver.findElement(By.id("erroNome")).getText();
        assertEquals("O campo nome deve ter no mínimo 3 caracteres.", result);
    }
    @Test
    public void editorSubArt() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("willteste@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        driver.findElement(By.id("artigos")).click();
        Thread.sleep(500);
        driver.findElement(By.id("submeter")).click();
        String result = driver.findElement(By.className("text-center")).getText();
        assertEquals("", result);
    }

    @Test
    public void avaliadorSubArt() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("bhruno@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        driver.findElement(By.id("artigos")).click();
        Thread.sleep(500);
        driver.findElement(By.id("submeter")).click();
        String result = driver.findElement(By.className("text-center")).getText();
        assertEquals("", result);
    }

    @Test
    public void cadastroVazioRevista() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("thiago@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        driver.findElement(By.id("Revista")).click();
        Thread.sleep(500);
        driver.findElement(By.id("cadastrarRevista")).click();
        driver.findElement(By.id("btnSubmit")).click();
        String result = driver.findElement(By.className("text-center")).getText();
        assertEquals("Cadastro de Nova Revista", result);
    }

    @Test
    public void subArtigoVazio() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("thiago@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        driver.findElement(By.id("artigos")).click();
        Thread.sleep(500);
        driver.findElement(By.id("submeter")).click();
        String result = driver.findElement(By.className("text-center")).getText();
        assertEquals("Submeter Artigos", result);
    }

    @Test
    public void cadTelefoneExistente() throws InterruptedException{
        //Criou a conta, ou seja, não passou, pois o telefone já existe
        driver.findElement(By.id("Btnregistro")).click();
        driver.findElement(By.id("name")).sendKeys("Ana");
        driver.findElement(By.id("email")).sendKeys("ana@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("password-confirm")).sendKeys("123123123");
        driver.findElement(By.id("btnUsuario")).click();
        Thread.sleep(500);
        driver.findElement(By.id("avaliador")).click();
        driver.findElement(By.id("endereco")).sendKeys("Rua Gaspar Silveira Martins");
        driver.findElement(By.id("telefone")).sendKeys("5551995171978");

        //ZOOM OUT
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);

        driver.findElement(By.id("btnRegister")).click();
        String result = driver.findElement(By.className("card-header")).getText();
        assertEquals("Registrar Usuário", result);
        //Para poder executar o teste novamente é preciso apagar os dados da Ana do banco de dados
    }

    @Test
    public void cadSemTipoUsuario() throws InterruptedException{
        //PERMITIU CRIAR, OU SEJA, NÃO PASSOU
        driver.findElement(By.id("Btnregistro")).click();
        driver.findElement(By.id("name")).sendKeys("Paula");
        driver.findElement(By.id("email")).sendKeys("paula@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("password-confirm")).sendKeys("123123123");
        driver.findElement(By.id("endereco")).sendKeys("Rua Gaspar Silveira Martins");
        driver.findElement(By.id("telefone")).sendKeys("5551995171978");
        driver.findElement(By.id("btnRegister")).click();
        String result = driver.findElement(By.className("card-header")).getText();
        assertEquals("Registrar Usuário", result);
        //É PRECISO DELETAR O PAULO DO BANCO PARA REALIZAR O TESTE NOVAMENTE!!!
    }


    @Test
    public void altInvalidoEditor() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("thiago@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        Thread.sleep(500);
        driver.findElement(By.id("Editor")).click();
        Thread.sleep(500);
        driver.findElement(By.id("gerenciarEditor")).click();
        driver.findElement(By.id("editarEditor")).click();
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("B");
        driver.findElement(By.id("telefone")).clear();
        driver.findElement(By.id("telefone")).sendKeys("5195171978");
        driver.findElement(By.id("endereco")).clear();
        driver.findElement(By.id("endereco")).sendKeys("TesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTeste");
        driver.findElement(By.id("salvar")).click();
        String result = driver.findElement(By.id("erroNome")).getText();
        assertEquals("O campo nome deve ter no mínimo 3 caracteres.", result);
    }

    @Test
    public void edicaoRevistaVazia() throws InterruptedException{
        driver.findElement(By.id("Btnlogin")).click();
        driver.findElement(By.id("email")).sendKeys("thiago@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.id("btnSubmitLog")).click();
        Thread.sleep(500);
        driver.findElement(By.id("home")).click();
        Thread.sleep(500);
        driver.findElement(By.id("Revista")).click();
        Thread.sleep(500);
        driver.findElement(By.id("gerenciarRevista")).click();
        Thread.sleep(500);
        driver.findElement(By.id("edit")).click();
        driver.findElement(By.id("titulo")).clear();
        driver.findElement(By.id("editor_input")).clear();
        driver.findElement(By.id("issn")).clear();
        driver.findElement(By.id("limite")).clear();
        driver.findElement(By.id("finalizar")).click();
        String result = driver.findElement(By.className("text-center")).getText();
        assertEquals("Atualizando Revista Revista 1", result);
    }

    // @Test
    // public void removAutorERevistaVinc() throws InterruptedException{
    //     driver.findElement(By.id("Btnlogin")).click();
    //     driver.findElement(By.id("email")).sendKeys("thiago@gmail.com");
    //     driver.findElement(By.id("password")).sendKeys("123123123");
    //     driver.findElement(By.id("btnSubmitLog")).click();
    //     Thread.sleep(500);
    //     driver.findElement(By.id("home")).click();
    //     Thread.sleep(500);
    //     driver.findElement(By.id("artigos")).click();
    //     Thread.sleep(500);
    //     driver.findElement(By.id("minhasSub")).click();
    //     String result = driver.findElement(By.className("text-center")).getText();
    //     assertEquals("Submissões Pendentes", result);
    // }

    @Test
    public void cadastroInvalido() throws InterruptedException{
        driver.findElement(By.id("Btnregistro")).click();
        driver.findElement(By.id("name")).sendKeys("B");
        driver.findElement(By.id("email")).sendKeys("joseyahoo.com.br");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("password-confirm")).sendKeys("321");
        driver.findElement(By.id("btnUsuario")).click();
        driver.findElement(By.id("avaliador")).click();
        driver.findElement(By.id("endereco")).sendKeys("TesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTesteTeste");
        driver.findElement(By.id("telefone")).sendKeys("55519951719781");
        Thread.sleep(500);

        //ZOOM OUT
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);

        driver.findElement(By.id("btnRegister")).click();
        String result = driver.findElement(By.className("card-header")).getText();
        assertEquals("Registrar Usuário", result);
        //Não foi possivel pegar a modal do email!

    }



    // @After
    // public void fecharDriver(){
    //     driver.close();
    //     driver.quit();
    // }

}
