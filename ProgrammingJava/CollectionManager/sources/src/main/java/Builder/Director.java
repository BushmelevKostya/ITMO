package Builder;

import Classes.Product;
import Exceptions.ExitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Takes in a builder object and manages its operation
 * @see ProductBuilder
 */
public class Director {
    private Builder builder;

    /**
     *
     * @param builder
     */
    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     *
     * @param builder
     */
    public void changeBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     *
     * @return Product
     */
    public Product make() throws ExitException, IOException {
        builder.reset();
        builder.setBId();
        builder.setBName();
        builder.setBCoordinates();
        builder.setBCreationDate();
        builder.setBPrice();
        builder.setBPartNumber();
        builder.setBManufactureCost();
        builder.setBUnitOfMeasure();
        builder.setBOrganization();
        return builder.getResult();

    }

    public Product make(Product product) throws ExitException{
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Вы хотите обновить старый элемент или создать новый?\nold/new");
                String str = br.readLine().strip();
                if (str.equals("old")){
                    System.out.println("Введите поле, которое хотите обновить. Чтобы завершить обновление, введите /exit");
                    builder.reset(product);
                    str = "";
                    while (!str.equals("/exit")){
                        System.out.println("name - n\ncoordinates - c\nprice - p\npartNumber - pn\n" +
                         "manufactureCost - mc\nunitOfMeasure - uom\norganization - o");
                        str = br.readLine().strip();
                        switch (str){
                            case "name", "n" -> builder.setBName();
                            case "coordinates", "c" -> builder.setBCoordinates();
                            case "price", "p" -> builder.setBPrice();
                            case "partNumber", "pn" -> builder.setBPartNumber();
                            case "manufactureCost", "mc" -> builder.setBManufactureCost();
                            case "unitOfMeasure", "uom" -> builder.setBUnitOfMeasure();
                            case "organization", "o" -> builder.setBOrganization();
                            case "/exit" -> System.out.println("Изменения сохранены.");
                            default -> System.out.println("Неверный ввод!");
                        }
                    }
                    return builder.getResult();
                } else if (str.equals("new")){
                    return make();
                }
                else {
                    System.out.println("Неверный ввод!");
                }
            }
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
