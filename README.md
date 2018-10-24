## Very simple kafka producer application (without spring framework).

**To run it:**

1. Install Scala https://www.scala-lang.org/news/2.12.0/
2. Download and unzip kafka 2.12 binaries https://kafka.apache.org/downloads
3. Install Java JDK 8+
4. We will create a topic with 3 partitions. Let's now create configuration files for 3 brokers (servers):
   * One (default) already exists in [Kafka_dir]\config\server.properties. Copy this file twice and name them accordingly: server1.properties and server2.properties,
   * In server1.properties set broker.id to 1 add port=9093 and log.dirs=/tmp/kafka-logs-1,
   * In server2.properties set broker.id to 2 add port=9094 and log.dirs=/tmp/kafka-logs-2.
5. Run Zookeeper: 
   ```sh
   [Kafka_dir]\bin\windows> .\zookeeper-server-start.bat [Kafka_dir]\config\zookeeper.properties
    ```
6. Run 3 brokers:
   ```sh
   [Kafka_dir]\bin\windows>.\kafka-server-start.bat [Kafka_dir]\config\server.properties
   [Kafka_dir]\bin\windows>.\kafka-server-start.bat [Kafka_dir]\config\server1.properties
   [Kafka_dir]\bin\windows>.\kafka-server-start.bat [Kafka_dir]\config\server2.properties
   ```
7. Create a topic with 3 partitions and replication factor of 3:
   ```sh
   [Kafka_dir]\bin\windows>.\kafka-topics.bat --zookeeper localhost:2181 --create --topic my_topic --partitions 3 --replication-factor 3
   ```
8. Run Application
9. To verify that messages were send correctly you can run console consumer
   ```sh
   [Kafka_dir]\bin\windows>.\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my_topic
   ```

###### Note :exclamation:
If you will have some issues while running zookeeper or brokers.
Then close all consoles and clear tmp directory in which zookeeper and brokers keep the logs (for example C:\tmp)