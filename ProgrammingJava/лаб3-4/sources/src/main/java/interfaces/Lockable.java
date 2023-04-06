package main.java.interfaces;

import main.java.classes.Item;

public interface Lockable{
    void putItem(Item item);
    void open(int code);

    class Lock extends Item{
        private boolean isCrashed;

        public Lock(String name, int amount) {
            this.name = name;
            this.amount = amount;
            this.isCrashed = false;
            try {
                this.price = Item.priceMap.get(name);
            } catch (Exception e) {
                System.out.println("Такого предмета не существует!");
            }
        }
        public void crash(){
            this.isCrashed = true;
        }
    }
}