package de.alperen.require4testing.bean;

import java.io.Serializable;
import java.util.List;

import de.alperen.require4testing.dao.RequirementDAO;
import de.alperen.require4testing.dao.TestCaseDAO;
import de.alperen.require4testing.model.Requirement;
import de.alperen.require4testing.model.TestCase;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class TestCaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private TestCase testCase = new TestCase();
    private TestCaseDAO testCaseDAO = new TestCaseDAO();
    private RequirementDAO requirementDAO = new RequirementDAO();

    private Long selectedRequirementId;

    public String saveTestCase() {
        if (selectedRequirementId != null) {
            for (Requirement req : requirementDAO.findAll()) {
                if (req.getId().equals(selectedRequirementId)) {
                    testCase.setRequirement(req);
                    break;
                }
            }
        }

        testCaseDAO.save(testCase);
        testCase = new TestCase();
        selectedRequirementId = null;
        return "testcases.xhtml?faces-redirect=true";
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    public List<TestCase> getTestCases() {
        return testCaseDAO.findAll();
    }

    public List<Requirement> getRequirements() {
        return requirementDAO.findAll();
    }

    public Long getSelectedRequirementId() {
        return selectedRequirementId;
    }

    public void setSelectedRequirementId(Long selectedRequirementId) {
        this.selectedRequirementId = selectedRequirementId;
    }
}