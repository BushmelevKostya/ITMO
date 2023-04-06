package Collection;

import Classes.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * In this class stored collection of objects
 *
 * @see Product
 */

public class MainCollection extends TreeMap<Integer, Product> {
    static private TreeMap<Integer, Product> collection = new TreeMap<>();
    static final String inicializationTime = new Date().toString();

    static private String fileName;
    private static final String[] headings = new String[]{"key", "id", "name", "coordinateX", "coordinateY", "creationDate",
            "price", "partNumber", "manufactureCost", "unitOfMeasure", "OrganizationId", "OrganizationName", "OrganizationFullName",
            "OrganizationannualTurnover", "OrganizationEmployessCount", "OrganizationType"};

    public MainCollection() {
    }

    public static Object getType() {
        return collection.getClass();
    }

    public static String getTime() {
        return inicializationTime;
    }

    public static int getSize() {
        return collection.size();
    }

    public static TreeMap<Integer, Product> getCollection() {
        return collection;
    }

    public static void setCollection(TreeMap<Integer, Product> collection) {
        MainCollection.collection = collection;
    }

    public static void setFileName(String fileName) {
        MainCollection.fileName = fileName;
    }

    public static String getFileName() {
        return fileName;
    }


    /**
     * @return StringBuilder
     */
    public static void printCollection() {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println("Вы хотите представить вывод в виде таблицы?\nyes/no");
//            String str = br.readLine();
//            if (str.equals("yes")){
//                SwingUtilities.invokeLater(() -> new Product.TableDemo(collectionToArray(), headings));
//            } else {
//                System.out.println("Не хотите, ну и не надо.");
//                StringBuilder stringBuilder = new StringBuilder();
//                for (Integer key : collection.keySet()) {
//                    stringBuilder.append("key= ").append(key).append("\n").append(collection.get(key).toString()).append("\n");
//                }
//                System.out.println(stringBuilder);
//            }
//        } catch (IOException exception){
//            System.out.println(exception.getMessage());
//        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer key : collection.keySet()) {
            stringBuilder.append("key= ").append(key).append("\n").append(collection.get(key).toString()).append("\n").append("\n");
        }
        if (collection.size() == 0) {
            System.out.println("Коллекция пуста!");
        } else {
            System.out.println(stringBuilder);
        }
    }

    public static Object[][] collectionToArray() {
        int size = collection.size();
        Object[][] array = new Object[size][16];
        int i = -1;
        for (Integer key : collection.keySet()) {
            i++;
            for (int j = 0; j < 16; j++) {
                switch (j) {
                    case 0 -> array[i][j] = key;
                    case 1 -> array[i][j] = collection.get(key).getId();
                    case 2 -> array[i][j] = collection.get(key).getName();
                    case 3 -> array[i][j] = collection.get(key).getCoordinates().getX();
                    case 4 -> array[i][j] = collection.get(key).getCoordinates().getY();
                    case 5 -> array[i][j] = collection.get(key).getCreationDate();
                    case 6 -> array[i][j] = collection.get(key).getPrice();
                    case 7 -> array[i][j] = collection.get(key).getPartNumber();
                    case 8 -> array[i][j] = collection.get(key).getManufactureCost();
                    case 9 -> array[i][j] = collection.get(key).getUnitOfMeasure();
                    case 10 -> array[i][j] = collection.get(key).getManufacturer().getId();
                    case 11 -> array[i][j] = collection.get(key).getManufacturer().getName();
                    case 12 -> array[i][j] = collection.get(key).getManufacturer().getFullName();
                    case 13 -> array[i][j] = collection.get(key).getManufacturer().getAnnualTurnover();
                    case 14 -> array[i][j] = collection.get(key).getManufacturer().getEmployeesCount();
                    case 15 -> array[i][j] = collection.get(key).getManufacturer().getType();
                }
            }
        }
        return array;
    }

    public static TreeMap<java.lang.Integer, Product> notFoundCollection() {
        System.out.println("Указанный файл не существует, хотите создать новую коллекцию?\nyes/no");
        return initializeCollection();
    }

    public static TreeMap<java.lang.Integer, Product> isNullCollection(TreeMap<Integer, Product> collection) {
        if (collection == null) {
            System.out.println("Указанный файл пуст, хотите создать новую коллекцию?\nyes/no");
            return initializeCollection();
        }
        return collection;
    }

    public static TreeMap<java.lang.Integer, Product> wrongJSON() {
        System.out.println("Файл поврежден, проверьте наличие всех полей в файле и синтаксис json.");
        System.out.println("Хотите создать новую коллекцию?\nyes/no");
        return initializeCollection();
    }

    public static void wrongType() {
        System.out.println("Файл поврежден, указан неверный тип данных!");
        System.out.println("Хотите создать новую коллекцию?\nyes/no");
        initializeCollection();
    }

    public static TreeMap<java.lang.Integer, Product> initializeCollection() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String str = br.readLine();
                if (str.equals("yes")) {
                    return new TreeMap<>();
                } else if (str.equals("no")) {
                    System.exit(0);
                }
                System.out.println("Неверный ввод!");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
