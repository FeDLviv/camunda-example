package com.example.workflow.delegate.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FailExecutionListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("money", 0);

        log.info("Fail, all variables: {}", delegateExecution.getVariables());
    }

}
