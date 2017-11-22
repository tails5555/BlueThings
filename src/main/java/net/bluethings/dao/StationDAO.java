package net.bluethings.dao;
import java.util.List;
import java.util.ArrayList;
import net.bluethings.dto.Station;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
//공공 데이터에 대한 저작자 : 서울시교통정보과 교통정보 API(api.bus.go.kr/index.jsp)
public class StationDAO{
	public List<Station> findByStSrch(String stSrch) throws MalformedURLException, IOException, JSONException{
		List<Station> stationList=new ArrayList<Station>();
		HttpURLConnection connection=(HttpURLConnection) new URL("http://ws.bus.go.kr/api/rest/stationinfo/getStationByName?serviceKey=5bD3XdOL8WNVvRQ7GM265ksawhaS%2FfUq4zCUx0Z8fxBoYR%2BMf%2BRB8oM1rkAv6sBaY105oMNkkeDmQcPemWznjw%3D%3D&"+"stSrch="+stSrch).openConnection();
		connection.connect(); // 이는 인터넷을 이용해서 xml 파일을 얻어오는 작업이다. 여기서 serviceKey는 인증번호 같은 거고, strSrch는 버스 노선 번호
		BufferedInputStream bis=new BufferedInputStream(connection.getInputStream()); // Java 내에서 xml 문자열들을 입력하기 위해 InputStream을 쓴다. 보통 자료를 받아올 때 InputStream을 쓰기 마련.
		BufferedReader reader=new BufferedReader(new InputStreamReader(bis)); // Buffer된 xml 파일을 읽어들인다.
		StringBuffer list=new StringBuffer(); // StringBuffer를 통해서 저장을 해야 한다. 이는 Thread를 고려해야 하기 때문이다.
		String line;
		while((line=reader.readLine())!=null) {
			list.append(line);
		} // JDBC라고 생각하면 그 resultSet랑 같은 의미로 생각할 수 있다.
		JSONObject xmlToJson=XML.toJSONObject(list.toString()); // JSON은 상당히 괜찮은 구조다. HashMap과 유사하게 생겼는데, 객체에 대해서 Key, Value로 정리가 잘 되어 있어서 유용하게 쓰인다. 방금 XML 파일에 대해서 JSON 파일로 변환을 하는 작업이다.
		JSONArray arriveInfo=xmlToJson.getJSONObject("ServiceResult").getJSONObject("msgBody").getJSONArray("itemList");
		for(int k=0;k<arriveInfo.length();k++) {
			String arsId=arriveInfo.getJSONObject(k).get("arsId").toString();
			String stNm=arriveInfo.getJSONObject(k).get("stNm").toString();
			stationList.add(new Station(arsId, stNm));
		}
		return stationList;
	}
}