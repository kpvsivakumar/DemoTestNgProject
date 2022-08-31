package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFarmat = new SimpleDateFormat("YYYY\\MMM\\dd-hh-mm-ss");
		String format = simpleDateFarmat.format(date);
		return format;
	}
}
