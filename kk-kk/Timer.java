package callhealth.com.callhealth;

import redis.clients.jedis.Jedis;

public class Timer {
	public static void main(String args[]){
		Jedis jedis=new Jedis("localhost");
		
		while(true){
			System.out.println(jedis.get("lastTime"));
			Double lastTime=Long.parseLong(jedis.get("lastTime"))/Math.pow(10, 9);
			int l=lastTime.intValue();
			System.out.println(l);
			Long currentTime=System.currentTimeMillis();
			//Long diff=currentTime-lastTime;
			System.out.println(currentTime-Long.parseLong("lastTime"));
			
		}
	}

}
