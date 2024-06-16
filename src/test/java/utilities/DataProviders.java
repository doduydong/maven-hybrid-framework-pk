package utilities;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1

	@DataProvider(name = "LoginData")
	public String[][] getData() {
		String userDir = System.getProperty("user.dir");
		Path filePath = Paths.get(userDir, "src", "test", "resources", "userInfo.xlsx");
		String path = filePath.toString();

		ExcelUtility xlutil = new ExcelUtility(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}

}
