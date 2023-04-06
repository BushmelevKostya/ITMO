package main.java.classes;

import main.java.abstractClasses.Site;
import main.java.enumerations.DepartureTime;
import main.java.enumerations.State;
import main.java.interfaces.Rideable;
import main.java.exceptions.LateForTrainException;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Train extends Site implements Rideable {
    private int amountCarriages;
    private ArrayList<Carriage> carriages;
    private DepartureTime departureTime;
    private Site direction;
    private Site currentLocation;

    public Train(DepartureTime departureTime, Site direction, Site currentLocation, int amountCarriages) {
        this.departureTime = departureTime;
        this.direction = direction;
        this.currentLocation = currentLocation;
        System.out.println();
        System.out.println("Новый объект classes.Train успешно создан!");
        this.amountCarriages = amountCarriages;
        this.carriages = new ArrayList<Carriage>();
        for (int i = 0; i < amountCarriages; i++){
            this.carriages.add(new Carriage(i));
        }
    }

    public class Carriage {
        private final int number;
        private ArrayList<MoonMen> passangers;
        private ArrayList<Ticket> tickets;

        public Carriage(int number) {
            this.number = number;
            this.passangers = new ArrayList<MoonMen>();
            this.tickets = new ArrayList<Ticket>();

        }

        public ArrayList<MoonMen> getPassangers() {
            return passangers;
        }
        public void checkPassangers() throws LateForTrainException {
            for (int i = 0; i < tickets.size(); i++){
                MoonMen passanger = tickets.get(i).getHuman();
                if (!passangers.contains(passanger)){
                    LateForTrainException exc = new LateForTrainException(passanger, tickets.get(i));
                    throw exc;
                }
            }
        }

        public void addPassanger(MoonMen human) {
            this.passangers.add(human);
        }
    }


    public ArrayList<Carriage> getCarriages() {
        return carriages;
    }

    public void ride() {

        System.out.println();
        System.out.printf("Поезд отправляется из места: %s в место: %s", currentLocation, direction);
        this.currentLocation = direction;
        for (int i = 0; i < amountCarriages; i++){
            carriages.get(i).passangers.forEach(new Consumer<MoonMen>() {
                @Override
                public void accept(MoonMen human) {
                    human.setSite(direction);
                }
            });
        }
    }

    public void rideOnSchedule(DepartureTime time, Site site) {
        if (time == departureTime) {
            System.out.println();
            System.out.println("Поезд отправляется прямо сейчас");
            ride();
        }
        System.out.println();
        System.out.printf("Поезд отправляется только когда придет время: %s", this.departureTime);
    }

    public void changeDirection(Site direction1, Site direction2) {
        if (direction.equals(direction1)) {
            this.direction = direction2;
        } else {
            this.direction = direction1;
        }
    }

    public void hide(MoonMen moonMen) {
        moonMen.addState(State.ESCAPED);
        moonMen.removeState(State.PURSUER);
    }

    public void setDepartureTime(DepartureTime time) {
        this.departureTime = time;
    }

    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public void setDirection(Site site) {
        this.direction = site;
    }

    public Site getDirection() {
        return direction;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != getClass()) {
            return false;
        }
        Train train = (Train) object;
        if (this.departureTime != train.departureTime) return false;
        if (this.direction != train.direction) return false;
        if (this.currentLocation != train.currentLocation) return false;
        return (this.carriages != train.carriages);
    }

    @Override
    public String toString() {
        return "Поезд готовится к отправлению в городе " + this.currentLocation + " в город " + this.direction;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + departureTime.hashCode();
        result = result * 17 + direction.hashCode();
        result = result * 17 + currentLocation.hashCode();
        result = result * 17 + carriages.hashCode();
        return result;
    }
}
