package Classes;

import javax.swing.*;
import java.awt.*;

/**
 * The main object of collection
 *
 * @see UnitOfMeasure
 * @see Organization
 */

public class Product {
    /**
     * Field cannot be null
     * value this field must be more than 0
     * value this field must be unique
     * value this field must be generated automatically
     */
    private Integer id;
    /**
     * Field cannot be null
     * String cannot be empty
     */
    private String name;
    /**
     * Field cannot be null
     */
    private Coordinates coordinates;
    /**
     * Field cannot be null
     * value this field must be generated automatically
     */
    private String creationDate;
    /**
     * value this field must be more than 0
     */
    private double price;
    /**
     * Length of string cannot be more than 82
     * String cannot be empty
     * value this field must be unique
     * Field cannot be null
     */
    private String partNumber;
    /**
     * Field cannot be null
     */
    private int manufactureCost;
    /**
     * Field cannot be null
     */
    private UnitOfMeasure unitOfMeasure;
    /**
     * Field cannot be null
     */
    private Organization manufacturer;

    public Product(Integer id, String name, Coordinates coordinates, String creationDate, float price,
                   String partNumber, Integer manufactureCost, UnitOfMeasure unitOfMeasure, Organization manufacturer) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.partNumber = partNumber;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.manufacturer = manufacturer;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setManufactureCost(int manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setManufacturer(Organization manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public int getManufactureCost() {
        return manufactureCost;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + this.id.toString() + "\nname=" + this.name + "\ncoordinates=" + this.coordinates.toString() +
                "\ncreationDate=" + this.creationDate + "\nprice=" + this.price + "\npartNumber=" +
                this.partNumber + "\nmanufactureCost=" + this.manufactureCost + "\nunitOfMeasure=" +
                this.unitOfMeasure.toString() + "\nmanufacturer=" + this.manufacturer.toString();
    }

    /**
     * compare with this object by id
     *
     * @param product object with which they compare
     * @return boolean
     */
    public boolean compare(Product product) {
        if (!product.getName().equals(this.name)) {
            return product.getName().compareTo(this.name) < 0;
        } else if (!product.getManufacturer().getName().equals(this.manufacturer.getName())) {
            return product.getManufacturer().getName().compareTo(this.manufacturer.getName()) < 0;
        }
        return this.id > product.getId();
    }

    public static class TableDemo {
        JTable jtabOrders;

        public TableDemo(Object[][] data, String[] headings) {
            JFrame jfrm = new JFrame("Product Collection");
            jfrm.setLayout(new FlowLayout());
            jfrm.setSize(1000, 1000);
//            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Создаем таблицу, которая отображает
            //данные заказа

            jtabOrders = new JTable(data, headings);

            //Помещаем таблицу внутрь панели прокрутки

            JScrollPane jscrlp = new JScrollPane(jtabOrders);

            //Устанавливаем размер прокр. окна

            jtabOrders.setPreferredScrollableViewportSize(
                    new Dimension(1500, 700));

            jfrm.add(jscrlp);
            jfrm.setVisible(true);
        }
    }
}



