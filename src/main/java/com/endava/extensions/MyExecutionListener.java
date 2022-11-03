//package com.endava.extensions;
//
//
//import org.junit.platform.engine.TestExecutionResult;
//import org.junit.platform.engine.reporting.ReportEntry;
//import org.junit.platform.launcher.TestExecutionListener;
//import org.junit.platform.launcher.TestIdentifier;
//import org.junit.platform.launcher.TestPlan;
//
//
//
//public class MyExecutionListener implements TestExecutionListener {
//    @Override
//    public void executionStarted(TestIdentifier testIdentifier) {
//        System.out.println("ExecutionStarted " + testIdentifier.getDisplayName());
//    }
//
//
//
//    @Override
//    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
//        System.out.println("Execution Finished " + testIdentifier.getDisplayName()+" Test execution result = "+ testExecutionResult.getStatus());
//    }
//
//
//
//    @Override
//    public void testPlanExecutionStarted(TestPlan testPlan) {
//        System.out.println("TestPlanExecutionStarted ");
//    }
//
//
//
//    @Override
//    public void testPlanExecutionFinished(TestPlan testPlan) {
//        System.out.println("testPlanExecutionFinished");
//    }
//
//
//
//    @Override
//    public void dynamicTestRegistered(TestIdentifier testIdentifier) {
//        System.out.println("dynamicTestRegistered "+ testIdentifier.getDisplayName());
//    }
//
//
//
//    @Override
//    public void executionSkipped(TestIdentifier testIdentifier, String reason) {
//        System.out.println("executionSkipped " + testIdentifier.getDisplayName() + " reason "+ reason);
//    }
//
//
//
//    @Override
//    public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
//        System.out.println("reportingEntryPublished" + testIdentifier.getDisplayName());
//    }
//}
