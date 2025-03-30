package Constants;

import Utils.AppiumUtils;

public class FileConstants {
	public static final String BASE_PATH= System.getProperty("user.dir");
		//public static final String REPORT_PATH =  BASE_PATH + "/src/main/resources/Reports/Mobile report.html";
		
		public static final String REPORT_PATH =  BASE_PATH + "/src/main/resources/Reports/"
				+"Mobile Report - "+AppiumUtils.getTimeStamp();
		public final static String SCREENSHOT_PATH = BASE_PATH + "/src/main/resources/Reports/Screenshots/"
		+AppiumUtils.getTimeStamp()+ ".PNG";

		public static final String TESTDATA_PATH =  BASE_PATH + "/src/main/java/TestData/Testdata.properties";

}
