package main.java.classes;

import main.java.interfaces.Lockable;
import main.java.abstractClasses.Site;
import main.java.abstractClasses.Furniture;

import java.util.ArrayList;

public class Safe extends Furniture implements Lockable {
    private boolean isOpened;
    private int wrongAttempts;
    private boolean isBlocked;
    static int symbols;
    private int code;

    public Safe(String name, int amount, Site location, int symbols) {
        this.location = location;
        this.name = name;
        this.amount = amount;
        Safe.symbols = symbols;
        try {
            this.price = Item.priceMap.get(name);
        } catch (Exception e) {
            System.out.println("Такого предмета не существует!");
        }
        this.isOpened = false;
        this.wrongAttempts = 0;
        isBlocked = false;
        this.code = Code.generate();
        this.items = new ArrayList<Item>();
    }
    public void putItem(Item item){
        items.add(item);
    }

    public void open(int code) {
        if (!isBlocked) {
            if (code == this.code) {
                setOpened(true);
            } else {
                setWrongAttempts();
            }
        }
    }

    public void setOpened(boolean isOpened){
        this.isOpened = isOpened;
    }

    public void setWrongAttempts() {
        this.wrongAttempts ++;
        if (wrongAttempts >= 3) {
            setBlocked(true);
        }
    }

    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public static class Code{
        static int kit;

        public Code(){}

        static int generate(){
            for (int i = 0; i < Safe.symbols; i++){
                kit = kit * 10 + (int) (Math.random()*10);
            }
            return kit;
        }
    }
}
