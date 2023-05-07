package com.example.workflow.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String name = (String) delegateExecution.getVariable("firstName");
        Integer age = (Integer) delegateExecution.getVariable("age");

        if (name == null) {
            log.error("Error - firstName is required");
            throw new BpmnError("error.name.null");
        }

        if (age == null) {
            log.error("Error - age is required");
            //without Error Boundary Event
            throw new BpmnError("error.age.null");
        }

        log.info("{} (age={}) call simple service task", name, age);

        int sum = (int) (Math.random() * 100);
        delegateExecution.setVariable("money", sum);
    }

}
