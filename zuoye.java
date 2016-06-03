package com.orilore.gyx.test;

public enum Action {
		STOP,RIGHT,LEFT,UP,DOWN
}

///////////////////////
package com.orilore.gyx.test;
import static java.lang.System.out;
import java.util.Calendar;
public class CalenderUtil {
	public static void main(String[] args){
		Calendar birth = Calendar.getInstance();
		birth.set(1975,Calendar.MAY,26);
		Calendar now = Calendar.getInstance();
		out.printf("����:",yearsBetween(birth,now));
		out.printf("����:",yearsBetween(birth,now));
	}
	public static long yearsBetween(Calendar begin,Calendar end){
		Calendar calendar = (Calendar) begin.clone();
		long years = 0;
		while(calendar.before(end)){
			calendar.add(Calendar.YEAR, 1);
			years++;
		}
		return years - 1;
	}
	public static long dayBetween(Calendar begin,Calendar end){
		Calendar calendar = (Calendar) begin.clone();
		long days = 0;
		while(calendar.before(end)){
			calendar.add(Calendar.DATE,1);
			days++;
		}
		return days - 1;
	}
}
/////////////////////////////
package com.orilore.gyx.test;

public class Client {
	public final String ip;
	public final String name;
	public Client(String ip,String name){
		this.ip = ip;
		this.name = name;
	}
}
///////////////////////////
package com.orilore.gyx.test;

public class ClientEvent {
	private Client client;
	public ClientEvent(Client client){
		this.client = client;
	}
	public String getName(){
		return client.name;
	}
	public String getIp(){
		return client.ip;
	} 
}
//////////////////
package com.orilore.gyx.test;

public interface ClientListener {
	void clientAdded(ClientEvent event);
	void clientRemoved(ClientEvent event);

}
//////////////////////
package com.orilore.gyx.test;
import java.util.ArrayList;
public class ClientQueue {
	private ArrayList cilents = new ArrayList();
	private ArrayList listeners = new ArrayList();
	public void addClientListener(ClientListener listener){
		listeners.add(listeners);
		}
	public void add(Client client){
		ClientQueue clients = null;
		clients.add(client);
		ClientEvent event = new ClientEvent(client);
		for(int i=0;i<listeners.size();i++){
			ClientListener listener = (ClientListener) listeners.get(i);
			listener.clientAdded(event);
		}
	}
	public void remove(Client client){
		ClientQueue clients = null;
		clients.remove(client);
		ClientEvent event = new ClientEvent(client);
		for(int i=0;i<listeners.size();i++){
			ClientListener listener = (ClientListener)listeners.get(i);
			listener.clientRemoved(event);
		}
	}
}
////////////////////////////////
package com.orilore.gyx.test;
import java.util.*; 
import static java.lang.System.*;
public class DateDemo {
	public static void mian(String[] args){
		Date date1 = new Date(currentTimeMillis());
		Date date2 = new Date();
		out.println(date1.getDate());
		out.println(date2.getDate());
	}
}
//////////////////////////////
package com.orilore.gyx.test;
import java.util.*;
import static java.lang.System.out;
import static java.text.DateFormat.*;
public class DateFormatDemo {
	public static void main(String[] args){
		Date date = new Date();
		dateInstanceDemo(date);
		timeInstanceDemo(date);
		timeInstanceDemo(date);
		dateInstanceDemo(date);
	}
	static void dateInstanceDemo(Date date){
		out.println("getDateInstance() demo");
		out.println(getDateInstance(LONG).format(date));
		out.println(getDateInstance(SHORT).format(date));
	}
	static void timeInstanceDemo(Date date){
		out.println("gettimeinstance");
		out.println(getTimeInstance(LONG).format(date));
		out.println(getTimeInstance(MEDIUM).format(date));
		out.println(getTimeInstance(SHORT).format(date));
	}
	static void dateTimeInstanceDemo(Date date){
		out.println("getDateTimeIntance() demo");
		out.printf("getDateTimeIntance(LONG,LONG).format(date)");
		out.printf("getDateTimeIntance(SHORT,MEDIUM).format(date)");
		out.printf("getDateTimeInstance(SHORT,SHORT).format(date)");
	}

}
//////////////////////////////////////
package com.orilore.gyx.test;
import static java.lang.System.out; 
public class Game {
	public static void main(String[] args){
		play(Action.RIGHT);
		play(Action.UP);
	}
	public static void play(Action action){
		switch(action){
		case STOP:
			out.println("����ֹͣ����");
			break;
		case RIGHT:
			out.println("�������Ҷ���");
			break;
		case LEFT:
			out.println("�������󶯻�");
			break;
		case UP:
			out.println("�������϶���");
			break;
		case DOWN:
			out.println("�������¶���");
			break;
		}
	}
	
}
///////////////////////////////
package com.orilore.gyx.test;
import java.util.*;
import java.text.*;
public class HowOld {
	public static void mian(String[] args) throws Exception{
		System.out.print("�������������(yyyy-mm-dd): ");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date birthDate = dateFormat.parse(new Scanner(System.in).nextLine());
		Date currentDate = new Date();
		long life = currentDate.getTime()-birthDate.getTime();
		System.out.println("����������Ϊ:"+(life/(365*24*60*60*1000L)));
	}
}
///////////////////////////
package com.orilore.gyx.test;

public class MultiChat {
	public static void main(String[] args){
		Client c1 = new Client("127.0.0.1","Caterpillar");
		Client c2 = new Client("192.168.0.2","Just");
		ClientQueue queue = new ClientQueue();
		queue.addClientListener(new ClientListener(){

			@Override
			public void clientAdded(ClientEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void clientRemoved(ClientEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		queue.add(c1);
		queue.add(c2);
		queue.remove(c1);
		queue.remove(c2);
	}
}
/////////////////////////////////
package com.orilore.gyx.test;
import java.text.*;
import java.util.*;
public class SimpleDateFormatDemo {
	public static void main(String[] args){
		DateFormat dateFormat = new SimpleDateFormat(
				args.length==0?"EE-MM-dd-yyyy":args[0]
				);
		System.out.println(dateFormat.format(new Date()));
	}
}
///////////////////////////////
package com.orilore.gyx.test;
import static java.lang.System.out;
import java.util.TimeZone;
public class TimeZoneDemo {
	public static void main(String[] args){
		TimeZone timeZone = TimeZone.getDefault();
		out.println(timeZone.getDisplayName());
		out.println("ʱ��:"+timeZone.getID());
		out.println("�չ��Լʱ��:"+timeZone.getDSTSavings());
		out.println("ƫ�ƺ�����:"+timeZone.getRawOffset());
	}
}
///////////////////
package com.orilore.gyx.test;
import java.util.*;

import static java.lang.System.out;
public class TimeZoneDemo2 {
	public static void main(String[] args){
		TimeZone taipeiTe = TimeZone.getTimeZone("Asia/Taipei");
		TimeZone taipeiTz = null;
		Calendar calendar = Calendar.getInstance(taipeiTz);
		showTime(calendar);
		TimeZone copenhagenTz = TimeZone.getTimeZone("Europe/Copenhagen");
		calendar .setTimeZone(copenhagenTz);
		showTime(calendar);
	}
	static void showTime(Calendar  calendar){
		out.print(calendar.getTimeZone().getDisplayName());;
		out.printf(
				calendar.getDisplayName(Calendar.HOUR, 0, null),
				calendar.getDisplayName(Calendar.MINUTE, 0, null));
	}
}
