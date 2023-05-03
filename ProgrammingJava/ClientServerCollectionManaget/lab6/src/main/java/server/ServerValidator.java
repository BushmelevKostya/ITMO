package server;

import common.product.Coordinates;
import common.product.Organization;
import common.product.Product;
import common.exception.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class ServerValidator {
    public ServerValidator() {
    }

    public void idCheck(Integer id) throws FalseValuesException {
        if (MainCollection.getCollection().containsKey(id)) {
            throw new FalseValuesException("Объект с таким ключом уже существует!");
        }
    }
    
    public void idExistCheck(Integer id) throws NoElementException {
        if (!MainCollection.getCollection().containsKey(id)) {
            throw new NoElementException("Объекта с таким ключом не существует!");
        }
    }

    public boolean isId(Integer id) {
        if (!MainCollection.getCollection().containsKey(id)) {
            System.out.println("Объекта с таким ключом не существует!");
            return false;
        }
        return true;
    }

    public Product getById(Integer id) throws NoElementException{
        var collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            if (Objects.equals(collection.get(key).getId(), id)) {
                return collection.get(key);
            }
        }
        throw new NoElementException("Объекта с таким id не существует!");
    }

    public String checkFileName(String[] args) {
        String fileName = "";
        try {
            fileName = args[0];
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Файл не был указан!");
            System.exit(0);
        }
        return fileName;
    }

    public void checkFile(TreeMap<Integer, Product> collection) throws FalseValuesException, NumberFormatException, UniqueException, NullPointerException {
        for (Integer key : collection.keySet()) {
            var element = collection.get(key);
            checkProduct(element);
            var coordinates = element.getCoordinates();
            checkCoordinates(coordinates);
            var manufacturer = element.getManufacturer();
            checkOrganization(manufacturer);
        }
        checkUnique(collection);
    }

    public void checkProduct(Product element) throws FalseValuesException, NumberFormatException, NullPointerException {
        String errorField = null;
        var id = element.getId();
        var name = element.getName();
        var creationDate = element.getCreationDate();
        var price = element.getPrice();
        var partNumber = element.getPartNumber();
        var unitOfMeasure = element.getUnitOfMeasure();

        try {
            ZonedDateTime.parse(creationDate);
        } catch (DateTimeParseException exception) {
            errorField = "CreationDate";
        }
        if (id == null || id <= 0) {
            errorField = "id";
        } else if (name == null || name.equals("")) {
            errorField = "name";
        } else if (creationDate == null || creationDate.equals("")) {
            errorField = "CreationDate";
        } else if (price <= 0 || price.isInfinite()) {
            errorField = "Price";
        } else if (partNumber == null || partNumber.equals("") ||
                partNumber.length() >= 83) {
            errorField = "PartNumber";
        } else if (unitOfMeasure == null) {
            errorField = "UnitOfMeasure";
        }
        checkErrorField(errorField);
    }

    public void checkCoordinates(Coordinates coordinates) throws FalseValuesException {
        String errorField = null;
        var x = coordinates.getX();
        var y = coordinates.getY();
        if (x <= -230) {
            errorField = "X";
        } else if (y == null || y > 702) {
            errorField = "Y";
        }
        checkErrorField(errorField);
    }

    public void checkOrganization(Organization manufacturer) throws FalseValuesException {
        String errorField = null;
        var mId = manufacturer.getId();
        var mName = manufacturer.getName();
        var mFullName = manufacturer.getFullName();
        var mAnnualTurnover = manufacturer.getAnnualTurnover();
        var mEmployeesCost = manufacturer.getEmployeesCount();
        var mOrganizationType = manufacturer.getType();

        if (mId <= 0) {
            errorField = "ManufacturerId";
        } else if (mName == null || mName.equals("")) {
            errorField = "ManufacturerName";
        } else if (mFullName != null && mFullName.length() > 1266) {
            errorField = "ManufacturerFullName";
        } else if (mAnnualTurnover == null || mAnnualTurnover <= 0) {
            errorField = "ManufacturerAnnualTurnover";
        } else if (mEmployeesCost <= 0) {
            errorField = "ManufacturerEmployessCost";
        } else if (mOrganizationType == null) {
            errorField = "ManufacturerType";
        }
        checkErrorField(errorField);
    }

    public void checkErrorField(String errorField) throws FalseValuesException {
        if (errorField != null) {
            throw new FalseValuesException("Ошибка инициализации поля: " + errorField);
        }
    }

    public void checkUnique(TreeMap<Integer, Product> collection) throws UniqueException {
        var uniqueId = new ArrayList<Integer>();
        var uniquePartNumber = new ArrayList<String>();
        var uniqueOrganizationId = new ArrayList<Integer>();
        var uniqueOrganizationFullName = new ArrayList<String>();
        for (Integer key : collection.keySet()) {
            var id = collection.get(key).getId();
            var partNumber = collection.get(key).getPartNumber();
            var organizationId = collection.get(key).getManufacturer().getId();
            var organizationFullName = collection.get(key).getManufacturer().getFullName();
            if (uniqueId.contains(id)) {
                throw new UniqueException("Заданы несколько объектов с одинаковым id");
            }
            uniqueId.add(id);
            if (uniquePartNumber.contains(partNumber)) {
                throw new UniqueException("Заданы несколько объектов с одинаковым partNumber");
            }
            uniquePartNumber.add(partNumber);
            if (uniqueOrganizationId.contains(organizationId)) {
                throw new UniqueException("Заданы несколько объектов с одинаковым organizationId");
            }
            uniqueOrganizationId.add(organizationId);
            if (uniqueOrganizationFullName.contains(organizationFullName)) {
                throw new UniqueException("Заданы несколько объектов с одинаковым organizationFullName");
            }
            uniqueOrganizationFullName.add(organizationFullName);
        }
    }

    public void isPositive(Integer value, String field) throws FalseValuesException {
        if (value <= 0) {
            throw new FalseValuesException("Поле " + field + " должно быть положительным");
        }
    }

    public void isPartNumberUnique(String partNumber) throws UniqueException {
        var collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            if (partNumber.equals(collection.get(key).getPartNumber())) {
                throw new UniqueException("Такое значение поля PartNumber уже существует!");
            }
        }
    }

    public void isIdUnique(Integer id) throws UniqueException {
        var collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            if (id.equals(collection.get(key).getManufacturer().getId())) {
                throw new UniqueException("Такое значение поля Id уже существует!");
            }
        }
    }

    public void isFullNameUnique(String string) throws UniqueException {
        var collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            if (string.equals(collection.get(key).getManufacturer().getFullName())) {
                throw new UniqueException("Такое значение поля FullName уже существует!");
            }
        }
    }
}
