import com.rabbitmq.client.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class AdminQueue {

    private final static String QUEUE_NAME = "ColaPrueba";

    public static void Recibir()throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

    public static void Enviar(String message)throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        message = message + " " + LocalDateTime.now();
        channel.basicPublish("ExchangeTest", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'\n");

        channel.close();
        connection.close();
    }

    public static void main(String []args) throws Exception{
        //AdminQueue.Enviar("Kiubo muchá DESDE Java");
        AdminQueue.Recibir();
    }

}
