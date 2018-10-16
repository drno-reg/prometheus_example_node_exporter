javac Prometheus/First.java
java -cp . Prometheus.First
#jar cvfm first.jar Manifest.txt -C Prometheus/ .
#jar cfme First.jar Manifest.txt Prometheus.First Prometheus/First.class
#jar cvfm First.jar Manifest.txt Prometheus.First Prometheus/First.class
#jar cvfm First.jar manifest_first.txt Prometheus.First Prometheus/*.class
jar cfm first.jar manifest_first.txt Prometheus.First Prometheus/*.class
#jar cfme First.jar Manifest.txt Prometheus.First
java -jar first.jar
