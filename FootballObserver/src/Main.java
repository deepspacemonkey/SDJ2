import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FootballGame game = new FootballGame("Italy", "Portugal");
        Scoreboard scoreboard = new Scoreboard(game);
        addLocalFans(game);
        playTheGame(game);
    }

    private static void playTheGame(FootballGame game) {
        System.out.println("Football game between " + game.getHomeTeam() + " and " + game.getAwayTeam() + ":");
        Scanner input = new Scanner(System.in);
        System.out.print("Press ENTER to start the game");
        input.nextLine();
        System.out.println("Game started");
        play();
        goalChance(game);
        play();
        goalChance(game);
        play();
        goalChance(game);
        play();
        goalChance(game);
        play();
        goalChance(game);
        System.out.println("Game ended");
    }

    private static void addLocalFans(FootballGame game) {
        FootballFan[] fans = new FootballFan[3];
        for (int i = 0; i < fans.length * 2 / 3; i++) {
            fans[i] = new FootballFan(game, "Fan" + (i + 1), true);
        }
        for (int i = fans.length * 2 / 3; i < fans.length; i++) {
            fans[i] = new FootballFan(game, "Fan" + (i + 1), false);
        }
    }

    private static void goalChance(FootballGame game) {
        String team = null;
        if ((int) (Math.random() * 2) == 0) {
            team = game.getHomeTeam();
        } else {
            team = game.getAwayTeam();
        }
        if ((int) (Math.random() * 4) > 0) // 75% chance
        {
            System.out.println("--->" + team + " scored a goal");
            game.scoreGoal(team);
        } else {
            System.out.println(team + " missed a shot");
        }
    }

    private static void play() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}
