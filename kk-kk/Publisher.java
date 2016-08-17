package callhealth.com.callhealth;

import redis.clients.jedis.Jedis;

public class Publisher {

	public static void main(String[] args) throws InterruptedException {
		Jedis jedis = new Jedis("localhost");
		int i=0;
		while(true){
			if(jedis.llen("queue")>2){
				System.out.println("queue is full\n");
				Thread.sleep(20000);
			}
			else{
				System.out.println("Inserting value to queue :Value"+i);
			jedis.rpush("queue", "Value "+i);
			i++;
			}
		}


	}

}