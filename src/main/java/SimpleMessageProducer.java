import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.stream.IntStream;

public class SimpleMessageProducer {


    public void sendMessages() {
            Properties properties = getProperties();
            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
            trySendMessages(producer);
    }

    private void trySendMessages(KafkaProducer<String, String> producer) {
        try {
            IntStream.rangeClosed(1,150).forEach(i -> producer.send(getRecord(i)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

    private ProducerRecord<String, String> getRecord(Integer i) {
        return new ProducerRecord<String,String>("my_topic", i.toString(), "My message: " + i.toString());
    }

    private Properties getProperties() {
        //http://kafka.apache.org/documentation.html#producerconfigs
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092, localhost:9093");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }
}
