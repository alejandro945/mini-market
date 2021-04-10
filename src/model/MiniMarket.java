package model;

import java.time.LocalDate;
import java.util.*;

import exceptions.DateException;
import exceptions.UnderAgeException;

public class MiniMarket {
    private List<Person> people;
    private int attempts;

    public MiniMarket() {
        people = new ArrayList<>();
        this.attempts = 0;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public List<Person> getPeople() {
        return this.people;
    }

    public void setPeople(List<Person> persons) {
        this.people = persons;
    }

    public String addPersonToMarket(DocumentType dt, int identification) throws UnderAgeException, DateException {
        String msg = "";
        int penul = getPenultimate(identification);
        if (dt.equals(DocumentType.TI)) {
            attempts++;
            throw new UnderAgeException();
        } else if (oddState(penul) && oddState(getDay())) {
            attempts++;
            throw new DateException(true);
        } else if (!oddState(penul) && !oddState(getDay())) {
            attempts++;
            throw new DateException(false);
        } else {
            attempts++;
            Person p = new Person(identification, dt);
            people.add(p);
            msg = "The person with id: " + identification + " can enter to our Market";
        }
        return msg;
    }

    public int getPenultimate(int identification) {
        int penultimate = 0;
        String render = String.valueOf(identification);
        if (render.length() > 1) {
            penultimate = Integer.parseInt(render.substring((render.length() - 2), (render.length() - 1)));
        } else {
            penultimate = identification;
        }
        return penultimate;
    }

    public boolean oddState(int redux) {
        boolean render = false;
        if (redux % 2 == 0) {
            render = true;
        }
        return render;
    }

    public int getDay() {
        return LocalDate.now().getDayOfMonth();
    }

}
