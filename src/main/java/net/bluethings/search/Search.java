package net.bluethings.search;
import lombok.Data;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
@Data
public class Search {
	
	String arsId;
	String stSrch;
	
	boolean samul;
	boolean kang;
	
	public String getQueryString() {
		String url=null;
		try {
			String temp1=(arsId==null) ? "" : URLEncoder.encode(arsId, "UTF-8");
			String temp2=(stSrch==null) ? "" : URLEncoder.encode(stSrch, "UTF-8");
			url=String.format("arsId=%s&stSrch=%s&samul=%b&kang=&b", temp1, temp2, samul, kang);
		}catch(UnsupportedEncodingException e) {}
		return url;
	}
}
