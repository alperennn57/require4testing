package de.alperen.require4testing.bean;

import java.io.Serializable;
import java.util.List;

import de.alperen.require4testing.model.TestRun;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class StatusBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TestRunBean testRunBean;

    public List<TestRun> getTestRuns() {
        return testRunBean.getTestRuns();
    }
}