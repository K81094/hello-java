package callhealth.com.callhealth;

import java.util.List;

import redis.clients.jedis.Jedis;

public class Subscriber 
{
    public static void main( String[] args )
    {
        Jedis jedis = new Jedis("localhost");   
        List<String> messages = null;
        while(true){
          System.out.println("Waiting for a message in the queue");
          messages = jedis.blpop(0,"queue");
          System.out.println("Got the message");
          System.out.println("KEY:" + messages.get(0) + " VALUE:" + messages.get(1));
          String payload = messages.get(1);
          //Do some processing with the payload
          System.out.println("Message received:" + payload);
          long time=System.currentTimeMillis();
          jedis.set("lastTime", Long.toString(time));
          System.out.println(jedis.get("lastTime"));
        }

    }
}