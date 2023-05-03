package server;

import common.product.Product;

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
    public static String printCollection() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer key : collection.keySet()) {
            stringBuilder.append("key= ").append(key).append("\n").append(collection.get(key).toString()).append("\n").append("\n");
        }
        if (collection.size() == 0) {
            return "Коллекция пуста!";
        } else {
            return stringBuilder.toString();
        }
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
