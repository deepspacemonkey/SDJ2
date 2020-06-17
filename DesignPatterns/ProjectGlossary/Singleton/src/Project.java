public class Project {
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ProjectGlossary getGlossary() {
        return ProjectGlossary.getInstance();
    }

    public String getDefinition(String phrase) {
        return ProjectGlossary.getInstance().getDefinition(phrase);
    }

    public void addGlossaryItem(String phrase, String definition) {
        ProjectGlossary.getInstance().addItem(phrase, definition);
    }

    public void removeGlossaryItem(String phrase) {
        ProjectGlossary.getInstance().removeItem(phrase);
    }

    @Override
    public String toString() {
        String s = "Project: " + name;
        if (ProjectGlossary.getInstance().size() > 0) {
            s += "\n" + ProjectGlossary.getInstance();
        } else {
            s += " [No glossary]";
        }
        return s;
    }
}