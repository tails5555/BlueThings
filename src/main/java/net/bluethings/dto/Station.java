package net.bluethings.dto;
import lombok.Data;
@Data
public class Station {
	String arsId;
	String stNm;
	public Station(String arsId, String stNm) {
		this.arsId=arsId;
		this.stNm=stNm;
	}
}
