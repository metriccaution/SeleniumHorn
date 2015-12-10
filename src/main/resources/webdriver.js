var run = function(driver) {
	driver.get('http://www.google.com');
	var element = driver.findElement(org.openqa.selenium.By.name('q'));
	element.sendKeys('Done');
	element.submit();
	return driver.getTitle();
}
