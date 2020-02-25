import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Scoreboard implements PropertyChangeListener {
    private FootballGame footballGame;

    public Scoreboard(FootballGame footballGame) {
        this.footballGame = footballGame;
        footballGame.addListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(footballGame.getScore());
    }
}
