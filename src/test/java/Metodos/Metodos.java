package Metodos;

import java.awt.print.Printable;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.deps.com.thoughtworks.xstream.io.xml.AbstractDocumentReader;
import junit.framework.Assert;
import ru.yandex.qatools.ashot.Screenshot;

public class Metodos {

	public static WebDriver driver;

	public void screnShoot(String print) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File desFile = new File(print);
		FileUtils.copyFile(srcFile, desFile);
	}

	public void pausa(int tempo, String descricaoPasso) throws InterruptedException {
		try {
			Thread.sleep(tempo);
		} catch (NoSuchElementException e) {
			Assert.fail(LocalDateTime.now() + "Erro no passo" + descricaoPasso);
		}
	}

	public void preencher(By elemento, String texto, String descricaoPasso) throws IOException {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (NoSuchElementException e) {
			Assert.fail(LocalDateTime.now() + "Erro no passo" + descricaoPasso);
			screnShoot(descricaoPasso);
		}
	}
	

	public void click(By elemento, String descricaoPasso) throws IOException {
		try {
			driver.findElement(elemento).click();
		} catch (NoSuchElementException e) {
			Assert.fail(LocalDateTime.now() + "Erro no passo" + descricaoPasso);
			screnShoot(descricaoPasso);
		}
	}
	
	public void fecharNavegador(String descricaoPasso) throws IOException {
		try {
			driver.quit();;
		} catch (NoSuchElementException e) {
			Assert.fail(LocalDateTime.now() + "Erro no passo" + descricaoPasso);
			screnShoot(descricaoPasso);	
		}	
	}
	
	public void executarNavegador(String url,String descricaoPasso) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url); 
		driver.manage().window().maximize();
		
	}
}
