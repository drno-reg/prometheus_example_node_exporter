javac Prometheus/First.java
java -cp . Prometheus.First
#jar cvfm first.jar Manifest.txt -C Prometheus/ .
jar cfme First.jar Manifest.txt Prometheus.First Prometheus/First.class
java -jar First.jar
