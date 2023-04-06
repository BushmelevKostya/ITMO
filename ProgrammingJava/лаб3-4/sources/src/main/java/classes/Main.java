package main.java.classes;
//238982.32
//Исключения - Место не существует
//Исключения - опоздал на поезд
//Локальный класс - кондуктор
//Вложенный класс - рюкзак, вагон
//Внутренный класс - Лесная еда
//Анонимный класс - фокусник

import main.java.abstractClasses.Humanoid;
import main.java.enumerations.DepartureTime;
import main.java.enumerations.State;
import main.java.exceptions.LateForTrainException;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception{
        main.java.classes.Item.addElement("Note", 1);
        main.java.classes.Item.addElement("Santik", 1);
        main.java.classes.Item.addElement("Ice-cream", 5);
        main.java.classes.Item.addElement( "BottleOfWater", 5);
        main.java.classes.Item.addElement("Несгораемый шкаф", 500);
        main.java.classes.Item.addElement("Несгораемый сундук", 500);
        main.java.classes.Item.addElement("Обрывки веревок", 1);
        main.java.classes.Item.addElement("Стеклянный шкаф", 200);
        main.java.classes.Item.addElement("Скафандр", 1000);
        main.java.classes.Item.addElement("Шляпа", 10);
        main.java.classes.Item.addElement("Деловая смекалка", 3);
        main.java.classes.Item.addElement("Давилонские юморески", 3);
        main.java.classes.Item.addElement("Газета для толстеньких", 3);
        main.java.classes.Item.addElement("Газета для тоненьких", 3);
        main.java.classes.Item.addElement("Газета для умных", 3);
        main.java.classes.Item.addElement("Газета для дураков", 3);
        main.java.classes.Item.addElement("Веревка", 2);
        main.java.classes.Item.addElement("Билет Незнайки", 5);
        main.java.classes.Item.addElement("Билет Жулио", 5);

        var santics = new Item("Santik", 220);

        var davilon = new TownLocations("Давилон");
        var san_Comaric = new TownLocations("Сан-Комарик");
        var hotel = new TownLocations("Гостиница");
        var cityPark = new TownLocations("Городской парк");
        var canteen = new TownLocations("Нестоловая");
        var station = new TownLocations("Станция");
        var office3 = new TownLocations("Третий этаж конторы");
        System.out.println();
        Thread.sleep(1000);

    var human1 = new MoonMen("Незнайка", davilon, "путешественник", false, false);
        var human2 = new MoonMen("Козлик", davilon, "путешественник", false, false);
        var human3 = new MoonMen("Жулио", davilon, "путешественник", false, false);
        System.out.println();

        var train = new Train(DepartureTime.EVENING, san_Comaric, davilon, 3);
        var ticket1 = new Ticket("Билет Незнайки", 1, train, human1);
        var ticket2 = new Ticket("Билет Жулио", 1, train, human2);

        human1.addState(State.PURSUER);
        human2.addState(State.PURSUER);
        human1.moveToPlace(office3);
        human2.moveToPlace(office3);
        var safe = new Safe("Несгораемый шкаф", 1, office3, 8);
        safe.setOpened(true);
        human1.rucksack.put(santics);
        human2.rucksack.put(santics);
        var note = human3.write("Note", 1);
        safe.putItem(note);
        safe.putItem(ticket1);
        safe.putItem(ticket2);

        human1.rucksack.put(safe.getItem(note));
        human1.rucksack.put(safe.getItem(ticket1));
        human2.rucksack.put(safe.getItem(ticket2));
        System.out.println();
        Thread.sleep(1000);

        office3.setOpened(false);
        var humans = new GroupOfMoonMen("Акционеры", davilon);
        humans.moveToPlace(office3);

        var chest = new Chest("й", 1, office3);
        var piecesOfRope = new Item("Обрывки веревок", 1);
        chest.putItem(piecesOfRope);
        human1.rucksack.put(chest.getItem(piecesOfRope));
        human1.create(piecesOfRope, "Веревка");

        var street = new TownLocations("Улица");
        human1.goDownTheRope(street);
        human2.goDownTheRope(street);
        humans.open(office3);
        humans.addState(State.ANGRY);
        var bookcase = new Item("Стеклянный шкаф", 1);
        var spaceSuit = new Item("Скафандр", 1);
        humans.destroy(bookcase);
        humans.destroy(spaceSuit);

        street.hide(human1);
        street.hide(human2);
        var shop1 = new TownLocations("Кондитерский магазин");
        var shop2 = new TownLocations("Разнокалиберный магазин");
        human1.search(shop2);
        human1.moveToPlace(shop1);
        human2.moveToPlace(shop1);

        human1.rucksack.getItem(note);
        human1.read(note);
        System.out.println();
        Thread.sleep(1000);

        train.rideOnSchedule(DepartureTime.DAY, san_Comaric);
        System.out.println();
        Thread.sleep(1000);

        human1.afraidToComeBack(hotel);
        human2.afraidToComeBack(hotel);
        System.out.println();
        Thread.sleep(1000);

        human1.moveToPlace(cityPark);
        human2.moveToPlace(cityPark);
        System.out.println();
        Thread.sleep(1000);

        human1.walk(cityPark, "обед");
        human2.walk(cityPark, "обед");
        System.out.println();
        Thread.sleep(1000);

        human1.moveOutOfPlace(cityPark);
        human2.moveOutOfPlace(cityPark);
        System.out.println();
        Thread.sleep(1000);

        human1.search(canteen);
        human2.search(canteen);
        System.out.println();
        Thread.sleep(1000);

        human1.moveToPlace(canteen);
        human2.moveToPlace(canteen);
        System.out.println();
        Thread.sleep(1000);

        var dinner = new Item("Dinner", 2);
        human1.buy(human1.rucksack, dinner, santics);
        human1.eat(human1.rucksack, dinner, canteen);
        human2.eat(human2.rucksack, dinner, canteen);
        System.out.println();
        Thread.sleep(1000);

        var ice_cream = new Item("Ice-cream", 2);
        var bottleOfWater = new Item("BottleOfWater", 1);
        human1.buy(human1.rucksack, ice_cream, santics);
        human1.buy(human1.rucksack, bottleOfWater, santics);

        class Conductor extends MoonMen{
            public void check(Ticket ticket){
                var carriage = ticket.getTrain().getCarriages().get(ticket2.getNumberCarriage());
                carriage.addPassanger(ticket.getHuman());
            }
        }

        var conductor = new Conductor();
        conductor.check(ticket1);
        conductor.check(ticket2);

        try{
            train.getCarriages().get(1).checkPassangers();
        }
        catch(LateForTrainException exception){
            exception.getHuman().sell(exception.getTicket(), exception.getHuman().rucksack);
        }

        var fatHuman = new MoonMen("Толстенький коротышка", train, "Путешественник", true, false);
        String[] arrayOfName = new String[]{"Деловая смекалка", "Давилонские юморески", "Газета для толстеньких", "Газета для тоненьких", "Газета для умных", "Газета для дураков"};
        for (int i = 0; i < 6; i++){
            fatHuman.read(new Item(arrayOfName[i], 1));
        }

        var hat = new Item("Шляпа", 1);
        MoonMen magicMan = new MoonMen(){
            @Override
            public void pull(Item item, String...items){
                for (String s : items) {
                    System.out.printf("Из объекта: %s появляeтся предмет: %s!", item.getName(), s);
                    System.out.println();
                }
            }
        };
        magicMan.pull(hat, "зубная щетка", "зубной порошок", "мыло", "полотенце", "носовой платок", "носки", "гвозди", "проволока");
    }
}
