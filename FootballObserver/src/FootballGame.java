import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FootballGame implements PropertyChangeSubject {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamGoal;
    private int awayTeamGoal;
    private PropertyChangeSupport property;

    public FootballGame(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeTeamGoal = 0;
        awayTeamGoal = 0;
        property = new PropertyChangeSupport(this);
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void scoreGoal(String team) {
        if (team.equals(homeTeam))
            property.firePropertyChange(homeTeam, homeTeamGoal, ++homeTeamGoal);

        else if (team.equals(awayTeam))
            property.firePropertyChange(awayTeam, awayTeamGoal, ++awayTeamGoal);
    }

    public String getScore() {
        return String.format("%s %d - %d %s", homeTeam, homeTeamGoal, awayTeamGoal, awayTeam);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
