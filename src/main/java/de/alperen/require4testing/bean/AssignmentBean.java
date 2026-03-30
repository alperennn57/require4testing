package de.alperen.require4testing.bean;

import java.io.Serializable;
import java.util.List;

import de.alperen.require4testing.dao.TestCaseDAO;
import de.alperen.require4testing.dao.TestRunDAO;
import de.alperen.require4testing.model.TestCase;
import de.alperen.require4testing.model.TestRun;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AssignmentBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private TestRunDAO testRunDAO = new TestRunDAO();
    private TestCaseDAO testCaseDAO = new TestCaseDAO();

    private Long selectedTestRunId;
    private Long selectedTestCaseId;
    private String testerName;

    public String assignTester() {
        TestRun selectedRun = null;
        for (TestRun tr : testRunDAO.findAll()) {
            if (tr.getId().equals(selectedTestRunId)) {
                selectedRun = tr;
                break;
            }
        }

        TestCase selectedCase = null;
        for (TestCase tc : testCaseDAO.findAll()) {
            if (tc.getId().equals(selectedTestCaseId)) {
                selectedCase = tc;
                break;
            }
        }

        if (selectedRun != null) {
            selectedRun.setTesterName(testerName);

            if (selectedCase != null && !selectedRun.getTestCases().contains(selectedCase)) {
                selectedRun.getTestCases().add(selectedCase);
            }

            testRunDAO.update(selectedRun);
        }

        selectedTestRunId = null;
        selectedTestCaseId = null;
        testerName = null;

        return "assignment.xhtml?faces-redirect=true";
    }

    public List<TestRun> getTestRuns() {
        return testRunDAO.findAll();
    }

    public List<TestCase> getTestCases() {
        return testCaseDAO.findAll();
    }

    public Long getSelectedTestRunId() {
        return selectedTestRunId;
    }

    public void setSelectedTestRunId(Long selectedTestRunId) {
        this.selectedTestRunId = selectedTestRunId;
    }

    public Long getSelectedTestCaseId() {
        return selectedTestCaseId;
    }

    public void setSelectedTestCaseId(Long selectedTestCaseId) {
        this.selectedTestCaseId = selectedTestCaseId;
    }

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }
}