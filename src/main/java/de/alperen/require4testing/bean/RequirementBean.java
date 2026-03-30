package de.alperen.require4testing.bean;

import java.io.Serializable;
import java.util.List;

import de.alperen.require4testing.dao.RequirementDAO;
import de.alperen.require4testing.model.Requirement;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class RequirementBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Requirement requirement = new Requirement();
    private RequirementDAO requirementDAO = new RequirementDAO();

    public String saveRequirement() {
        requirementDAO.save(requirement);
        requirement = new Requirement();
        return "requirements.xhtml?faces-redirect=true";
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public List<Requirement> getRequirements() {
        return requirementDAO.findAll();
    }
}