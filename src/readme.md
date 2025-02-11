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

Activiti Tables to follow:
select * from act_hi_actinst order by start_time_ desc;
select * from act_hi_taskinst order by start_time_ desc;
select * from act_hi_procinst order by start_time_ desc;

workflow:
startEvent (Cart Created) --> user task confirmOrderTask to Confirm the Order 
--> Once the Customer approves/confirms to proceed to payment, service task paymentTask is triggered. 
Kafka sends payment-events. --> Payment consumer consumes this event. Once this task is completed, delivery task
is triggered -> delivery task to Notify Restaurant will trigger delivery-events -->
Delivery Consumer will consume this topic --> endEvent with Order Completed
