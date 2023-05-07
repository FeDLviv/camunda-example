package com.example.workflow.delegate.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SuccessExecutionListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Success, all variables: {}", delegateExecution.getVariables());
    }

}
