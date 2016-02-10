import org.openqa.selenium.chrome.ChromeDriver

def chromeDriver = new File('test/drivers/chrome/chromedriver')
System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
driver = { new ChromeDriver() }

