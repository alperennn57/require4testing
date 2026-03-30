package de.alperen.require4testing.bean;

import java.io.Serializable;
import java.util.List;

import de.alperen.require4testing.dao.TestRunDAO;
import de.alperen.require4testing.model.TestRun;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class TestRunBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private TestRun testRun = new TestRun();
    private TestRunDAO testRunDAO = new TestRunDAO();

    public String saveTestRun() {
        testRunDAO.save(testRun);
        testRun = new TestRun();
        return "testruns.xhtml?faces-redirect=true";
    }

    public TestRun getTestRun() {
        return testRun;
    }

    public void setTestRun(TestRun testRun) {
        this.testRun = testRun;
    }

    public List<TestRun> getTestRuns() {
        return testRunDAO.findAll();
    }
}