package merli;

import org.testng.annotations.DataProvider;
public class dataprovider {
	 @DataProvider(name = "urlProvider")
	    public Object[][] dataProviderMethod() {
	        return new Object[][] {
	            {"https://www.merillife.com/"}
	        };
	    }
}
