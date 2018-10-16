javac Prometheus/NodeExporter.java
java -cp . Prometheus.NodeExporter
jar cvfm node_exporter.jar manifest_prometheus.txt Prometheus.NodeExporter Prometheus/*.class
java -jar node_exporter.jar
