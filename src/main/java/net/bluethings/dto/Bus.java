package net.bluethings.dto;
import lombok.Data;
@Data
public class Bus{
	String type;
	String adirection;
	String rtNm;
	String arrmsg1;
	String stationNm1;
	String arrmsg2;
	String stationNm2;
	public Bus(String type, String rtNm, String adirection, String arrmsg1, String stationNm1, String arrmsg2,
			String stationNm2) {
		this.type = type;
		this.rtNm = rtNm;
		this.adirection = adirection;
		this.arrmsg1 = arrmsg1;
		this.stationNm1 = stationNm1;
		this.arrmsg2 = arrmsg2;
		this.stationNm2 = stationNm2;
	}
}