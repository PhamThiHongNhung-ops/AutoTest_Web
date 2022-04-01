package serenitybdd.Autotest.WebMyPham.common;

public class Util {
	
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static String getDateTimeNow() {
		String dateNow = java.time.LocalDateTime.now() + "";
		dateNow = dateNow.trim().replaceAll("[-:.]", "");
		return dateNow;
	}
	
	
	
}
