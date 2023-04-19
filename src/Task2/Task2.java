package Task2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Task2 {
	private final static String QUEUE_Name = "task2";
	
	public static void sendMessage(String message) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
			Channel channel = connection.createChannel()){
			channel.queueDeclare(QUEUE_Name,false,false,false,null);
			channel.basicPublish("", QUEUE_Name, null, message.getBytes());
		}
		
	}
}