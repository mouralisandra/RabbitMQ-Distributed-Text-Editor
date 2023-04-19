package Task3;

import javax.swing.JFrame;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Task3 {

	private final static String QUEUE_NAME1 = "task1";
	private final static String QUEUE_NAME2 = "task2";
	
	public static void main(String[] args) throws Exception{
		
		Document doc = new Document();
		JFrame frame = new JFrame ("Real-Time text Editor");
		frame.setResizable(false);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add (doc);
		frame.pack();
		frame.setVisible (true);
	           
	    Task1Connection(doc);
	    Task2Connection(doc);
		
	}
	
	
	public static void Task1Connection(Document doc) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME1,false,false,false,null);
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			doc.setTextArea1Text(message);
		};
		
		channel.basicConsume(QUEUE_NAME1, true, deliverCallback, consumerTag -> {});
	}
	
	public static void Task2Connection(Document doc) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME2,false,false,false,null);
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			doc.setTextArea2Text(message);
		};
		
		channel.basicConsume(QUEUE_NAME2, true, deliverCallback, consumerTag -> {});
	}
	
	
}
