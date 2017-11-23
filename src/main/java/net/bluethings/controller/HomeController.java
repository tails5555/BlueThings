package net.bluethings.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.bluethings.dao.BusDAO;
import net.bluethings.dao.StationDAO;
import net.bluethings.dto.Bus;
import net.bluethings.dto.Station;
import net.bluethings.search.Search;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import java.awt.event.*;


@Controller
@RequestMapping("home")
public class HomeController{
	static { System.setProperty("java.awt.headless", "false1"); } 
	BusDAO busDAO=new BusDAO();
	StationDAO stationDAO=new StationDAO();
	@RequestMapping("home")
	public String home(Model model, Search search) throws MalformedURLException, IOException, JSONException {
		List<Bus> busList=busDAO.findByStationId(search.getArsId());
		List<Station> stationList=stationDAO.findByStSrch(search.getStSrch());
		List<Bus> arriveSoon=new ArrayList<Bus>();
		Object[] getArrive=busList.toArray();
		for(int k=0;k<getArrive.length;k++) {
			System.out.println(((Bus)getArrive[k]).getRtNm()+" "+((Bus)getArrive[k]).getArrmsg1());
			if(((Bus)getArrive[k]).getArrmsg1().equals("곧 도착")) {
				arriveSoon.add((Bus)getArrive[k]);
				busList.remove((Bus)getArrive[k]);
			}
		}
		System.out.println(search.isKang());
		System.out.println(search.isSamul());
		
	
		
		
		
	if(search.isSamul()==true) {
			
			String exeFile = "C:\\Program Files (x86)\\teraterm\\ttermpro.exe";
	           System.out.println("exeFile: " + exeFile);
	           Process p;
	         
	          	
	           Runtime rt = Runtime.getRuntime();
	         
					p = rt.exec(exeFile);
					
					  try {
						  System.setProperty("java.awt.headless", "false");
				            Robot robot = new Robot();
				 
				            robot.delay(2000);
				            
				            robot.keyPress(KeyEvent.VK_ALT);
				            robot.keyPress(KeyEvent.VK_E);
				            robot.keyRelease(KeyEvent.VK_ALT);
				            robot.keyRelease(KeyEvent.VK_E);
				            robot.keyPress(KeyEvent.VK_ALT);
				            robot.keyPress(KeyEvent.VK_R);
				            robot.keyRelease(KeyEvent.VK_ALT);
				            robot.keyRelease(KeyEvent.VK_R);
				    
				            robot.keyPress(KeyEvent.VK_ENTER);
				            robot.keyRelease(KeyEvent.VK_ENTER);
				            robot.delay(2000);
				            robot.keyPress(KeyEvent.VK_1);
				            robot.keyRelease(KeyEvent.VK_1);
				            robot.delay(2000);
				            
				        } catch (AWTException e) {
				            e.printStackTrace();
				        }
					  
					  p.destroy();
	       		  
		}
		
		else if(search.isSamul()==false) {
			
			String exeFile = "C:\\Program Files (x86)\\teraterm\\ttermpro.exe";
	           System.out.println("exeFile: " + exeFile);
	           Process p;
	         
	          	
	           Runtime rt = Runtime.getRuntime();
	         
					p = rt.exec(exeFile);
				  
					  try {
						  System.setProperty("java.awt.headless", "false");
				            Robot robot = new Robot();
				            
				        
				            robot.delay(2000);
				            
				            robot.keyPress(KeyEvent.VK_ALT);
				            robot.keyPress(KeyEvent.VK_E);
				            robot.keyRelease(KeyEvent.VK_ALT);
				            robot.keyRelease(KeyEvent.VK_E);
				            robot.keyPress(KeyEvent.VK_ALT);
				            robot.keyPress(KeyEvent.VK_R);
				            robot.keyRelease(KeyEvent.VK_ALT);
				            robot.keyRelease(KeyEvent.VK_R);
				         
				            robot.keyPress(KeyEvent.VK_ENTER);
				            robot.keyRelease(KeyEvent.VK_ENTER);
				            robot.delay(2000);
				            robot.keyPress(KeyEvent.VK_2);
				            robot.keyRelease(KeyEvent.VK_2);
				            robot.delay(2000);
				            
				            
				        } catch (AWTException e) {
				            e.printStackTrace();
				        }
					  
					  p.destroy();
	       		  
		}
		model.addAttribute("buses", busList); // 곧 도착 이외에 버스 목록들. n분 남은 경우.
		model.addAttribute("arrives", arriveSoon); // 곧 도착 예정 버스들
		model.addAttribute("stations", stationList); // 지역 검색 별 정류장 목록들
		return "home/home";
	}
}


