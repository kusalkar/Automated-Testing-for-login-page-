import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class loginpagetest {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ashwini\\Desktop\\selenium jar\\chromedriver.exe");
		WebDriver w = new ChromeDriver();
		w.navigate().to("https://www.shopsy.co.in/my-account/");
		w.manage().window().maximize();
		Thread.sleep(500);
		
		loginpagetest demo = new loginpagetest();
		demo.login_validuname_validpass(w);
		demo.login_validuname_invalidpass(w);
		demo.login_invaliduname_validpass(w);
		demo.login_blankuname_blankpass(w);
	}
	public void login_validuname_validpass(WebDriver w) //check with valid username and valid password 
	{
		w.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ashwinik");
		w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1996Ashwini@");
		w.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/div/form/p[3]/button")).click();
		String actualmsg = w.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div/small")).getText();
		//System.out.println(actualmsg);
		String expectedmsg = "DASHBOARD";
		Assert.assertEquals(actualmsg, expectedmsg,"fail with valid username and valid password");
		w.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[2]/div/div/p[1]/a")).click();
	}
	public void login_validuname_invalidpass(WebDriver w) // check with valid username  and invalid password
	{
		w.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ashwinik");
		w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234");
		w.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/div/form/p[3]/button")).click();
		String actualmsg = w.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/ul/li/div/strong[1]")).getText();
		//System.out.println(actualmsg);
		String expectedmsg = "Error:";
		Assert.assertEquals(actualmsg, expectedmsg,"fail with valid username and invalid password");
		w.navigate().to("https://www.shopsy.co.in/my-account/");
	}
	public void login_invaliduname_validpass(WebDriver w) //check with invalid username and valid password
	{
		w.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ashwin");
		w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1996Ashwini@");
		w.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/div/form/p[3]/button")).click();
		String actualmsg = w.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/ul/li/div/strong[1]")).getText();
		//System.out.println(actualmsg);
		String expectedmsg = "Error:";
		Assert.assertEquals(actualmsg, expectedmsg,"fail with valid username and invalid password");
		w.navigate().to("https://www.shopsy.co.in/my-account/");
	}
	
	public void login_blankuname_blankpass(WebDriver w) // check with blank username and blank password
	{
		w.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("  ");
		w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("  ");
		w.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/div/form/p[3]/button")).click();
		String actualmsg = w.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[1]/ul/li/div/strong[1]")).getText();
		//System.out.println(actualmsg);
		String expectedmsg = "Error:";
		Assert.assertEquals(actualmsg, expectedmsg,"fail with valid username and invalid password");
		
	}
}
