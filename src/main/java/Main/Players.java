package Main;

public class Players extends Document {
    public Players(String team, String name, int wins, int fastestLaps, int races, int birthYear, String nationality) {
        super(team, name, wins, fastestLaps, races, birthYear, nationality);
    }

    @Override
    public String toString() {
        return "Team{" + team + '\'' +
                "name='" + name + '\'' +
                ", wins=" + wins + '\'' +
                ", fastestLaps='" + fastestLaps + '\'' +
                ", races='" + races + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", nationality='" + nationality +
                '}';
    }
}
