package net.bluethings.dao;
import java.util.List;
import java.util.ArrayList;
import net.bluethings.dto.Bus;
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
// 공공 데이터에 대한 저작자 : 서울시교통정보과 교통정보 API(api.bus.go.kr/index.jsp)
public class BusDAO{
	public List<Bus> findByStationId(String arsid) throws MalformedURLException, IOException, JSONException{
		List<Bus> busList=new ArrayList<Bus>();
		HttpURLConnection connection=(HttpURLConnection) new URL("http://ws.bus.go.kr/api/rest/stationinfo/getStationByUid?serviceKey=5bD3XdOL8WNVvRQ7GM265ksawhaS%2FfUq4zCUx0Z8fxBoYR%2BMf%2BRB8oM1rkAv6sBaY105oMNkkeDmQcPemWznjw%3D%3D&"+"arsId="+arsid).openConnection();
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
			int routeType=arriveInfo.getJSONObject(k).getInt("routeType");
			String rtype="";
			switch(routeType) {
			case 1 : 
				rtype="공항";
				break;
			case 2 : 
				rtype="마을";
				break;
			case 3 : 
				rtype="간선";
				break;
			case 4 : 
				rtype="지선";
				break;
			case 5 : 
				rtype="순환";
				break;
			case 6 : 
				rtype="광역";
				break;
			default : 
				rtype="기타";
				break;
			}
			String rtNm=arriveInfo.getJSONObject(k).get("rtNm").toString();
			String adirection=arriveInfo.getJSONObject(k).getString("adirection");
			String stationNm1="";
			if(!arriveInfo.getJSONObject(k).isNull("stationNm1")) {
				stationNm1=arriveInfo.getJSONObject(k).getString("stationNm1");
			}
			String arrmsg1=arriveInfo.getJSONObject(k).getString("arrmsg1"); 
			String stationNm2="";
			if(!arriveInfo.getJSONObject(k).isNull("stationNm2")) {
				stationNm2=arriveInfo.getJSONObject(k).getString("stationNm2");
			}
			String arrmsg2=arriveInfo.getJSONObject(k).getString("arrmsg2");
			busList.add(new Bus(rtype, rtNm, adirection, arrmsg1, stationNm1, arrmsg2, stationNm2));
		}
		return busList;
	}
}