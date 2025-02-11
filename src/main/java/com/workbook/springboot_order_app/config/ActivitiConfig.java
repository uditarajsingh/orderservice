package com.workbook.springboot_order_app.config;


import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.io.InputStream;

@Configuration
public class ActivitiConfig {

    @Autowired
    private RepositoryService repositoryService;

    @Bean
    public void deployProcess() {
        // Input stream of the BPMN file
        InputStream bpmnStream = getClass().getClassLoader().getResourceAsStream("processes/order-process.bpmn20.xml");

        // Deploying the process
        Deployment deployment = repositoryService.createDeployment()
                .addInputStream("order-process.bpmn20.xml", bpmnStream)
                .deploy();

        System.out.println("Deployment ID: " + deployment.getId());
    }

}
