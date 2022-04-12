package Main;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Document implements Comparable<Document>{
    protected String team;
    protected String name;
    protected int wins;
    protected int fastestLaps;
    protected int races;
    protected int birthYear;
    protected String nationality;

    //Constructor
    public Document(String team, String name, int wins, int fastestLaps, int races, int birthYear, String nationality) {
        this.team = team;
        this.name = name;
        this.wins = wins;
        this.fastestLaps = fastestLaps;
        this.races = races;
        this.birthYear = birthYear;
        this.nationality = nationality;
    }

    //Return the team of the driver
    public String getTeam() {
        return team;
    }

    //Set a value of team of driver
    public void setTeam(String team) {
        this.team = team;
    }

    //Return the driver's name
    public String getName() {
        return name;
    }

    //Set the driver's name
    public void setName(String name) {
        this.name = name;
    }

    //Return the number of wins of driver
    public int getWins() {
        return wins;
    }

    //Set the number of wins of driver
    public void setWins(int wins) {
        this.wins = wins;
    }

    //Return the number of the fastest lap of driver
    public int getFastestLaps() {
        return fastestLaps;
    }

    //Set the number of the fastest lap of driver
    public void setFastestLaps(int fastestLaps) {
        this.fastestLaps = fastestLaps;
    }

    //Return number of races the driver took part in
    public int getRaces() {
        return races;
    }

    //Set number of races the driver took part in
    public void setRaces(int races) {
        this.races = races;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Players)) return false;

        Players players = (Players) o;

        if (wins != players.getWins()) return false;
        if (name != null? name.equals(players.getName()) : players.getName()!= null) return false;
        return team == null ? team.equals(players.getTeam()) : players.getTeam() == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + wins;
        result = 31 * result +  (team != null ? team.hashCode() : 0);
        return result;
    }


    @Override
    public int compareTo(Document o) {
        int result = this.team.compareTo(o.team);
        if (result != 0) {
            return result;
        }
        result = this.name.compareTo(o. name);
        if (result != 0) {
            return result;
        }

        result = this.wins - o.wins;
        return result;
    }
}
