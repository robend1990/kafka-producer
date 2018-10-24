public class KafkaProducerApp {

    public static void main(String[] args) {
        SimpleMessageProducer simpleMessageProducer = new SimpleMessageProducer();
        simpleMessageProducer.sendMessages();
    }
}
