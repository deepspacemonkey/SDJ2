import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FootballFan implements PropertyChangeListener {
    private FootballGame footballGame;
    private String myName;
    private String myTeam;

    public FootballFan(FootballGame footballGame, String myName, boolean isHomeTeamFan) {
        this.footballGame = footballGame;
        this.myName = myName;
        if (isHomeTeamFan)
            myTeam = footballGame.getHomeTeam();
        else
            myTeam = footballGame.getAwayTeam();
        footballGame.addListener(this);
        cheer(myTeam);
    }

    public void cheer(String team) {
        System.out.println(myName + " -> GO " + myTeam);
    }

    public void reactOnGoal(String team) {
        if (team.equals(myTeam))
            System.out.println(myName + " -> YAY!");
        else
            System.out.println(myName + " -> BOOze!");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        reactOnGoal(evt.getPropertyName());
    }
}
