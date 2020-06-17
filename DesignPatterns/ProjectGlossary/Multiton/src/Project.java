public class Project {
    private String name;
    private String key;

    public Project(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public ProjectGlossary getGlossary() {
        return ProjectGlossary.getInstance(key);
    }

    public String getDefinition(String phrase) {
        return ProjectGlossary.getInstance(key).getDefinition(phrase);
    }

    public void addGlossaryItem(String phrase, String definition) {
        ProjectGlossary.getInstance(key).addItem(phrase, definition);
    }

    public void removeGlossaryItem(String phrase) {
        ProjectGlossary.getInstance(key).removeItem(phrase);
    }

    @Override
    public String toString() {
        String s = "Project: " + name + " Language: " + key;
        if (ProjectGlossary.getInstance(key).size() > 0) {
            s += "\n" + ProjectGlossary.getInstance(key);
        } else {
            s += " [No glossary]";
        }
        return s;
    }
}