package se.iths.madeleine.model;

public class Competence {

    private int competenceId;
    private String name;
    private String description;

    public Competence(int competenceId, String name, String description) {
        this.competenceId = competenceId;
        this.name = name;
        this.description = description;
    }

    public int getCompetenceId() {
        return competenceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
