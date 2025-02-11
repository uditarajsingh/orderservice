Prerequisites:

Kafka should be running: /opt/homebrew/opt/kafka/bin/kafka-server-start /opt/homebrew/etc/kafka/server.properties
H2 Db should be running:
cd /Users/{mydirectory}/Downloads/h2/bin
java -jar h2*.jar
Access the H2 console: http://localhost:8082/login.do?jsessionid=523da700d6c04bcdd609e613a2c0c6dd
Test the flow:
Place the order: http://localhost:8080/orders/place/{orderID}
Proceed to payment: http://localhost:8080/orders/tasks/proceedToPayment/{orderID}
This will complete the confirmation task and payment event will be triggered
On completion of payment event, Activiti will call delivery task and delivery event will be triggered.

