package IO;

import Classes.Coordinates;
import Classes.Organization;
import Classes.Product;
import Collection.MainCollection;
import Command.CommandWithParameters;
import Command.CommandWithoutParameters;
import Exceptions.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class Validator {
    public Validator() {
    }

    public boolean check(String data) {
        try {
            var list = new Reader(data).getData();
            if (list.length > 2) {
                System.out.println("Введено слишком много аргументов!");
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        return true;
    }

    public boolean checkCommand(String command) {
        boolean exists = true;
        try {
            CommandWithoutParameters.valueOf(command);
        } catch (IllegalArgumentException exception) {
            try {
                CommandWithParameters.valueOf(command);
            } catch (IllegalArgumentException e) {
                exists = false;
                if (!command.equals("")) {
                    System.out.println("Команды " + command + " не существует!");
                }
            }
        }
        return exists;
    }

    public boolean checkParam(String command, String value) {
        if (value == null) {
            try {
                CommandWithoutParameters.valueOf(command);
            } catch (IllegalArgumentException exception) {
                System.out.println("Этой команде необходимо передать параметр!");
                return false;
            }
        } else {
            try {
                CommandWithParameters.valueOf(command);
            } catch (IllegalArgumentException exception) {
                System.out.println("У этой команды нет параметров!");
                return false;
            }
        }
        return true;
    }

    public void idCheck(Integer id) throws FalseValuesException {
        if (MainCollection.getCollection().containsKey(id)) {
            throw new FalseValuesException("Объект с таким ключом уже существует!");
        }
        isPositive(id, "Id");
    }

    public <T1, T2> boolean checkType(T1 validType, T2 object) {
        if (object.getClass() != validType.getClass()) {
            System.out.printf("Тип введенных данных некорректен! Необходимый тип: %s\n", validType.getClass());
            return false;
        }
        return true;
    }

    public Integer checkParamType(String value) throws NumberFormatException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Значение id должно быть типа int!");
        }
    }

    public boolean isId(Integer id) {
        if (!MainCollection.getCollection().containsKey(id)) {
            System.out.println("Объекта с таким ключом не существует!");
            return false;
        }
        return true;
    }

    public Product getById(Integer id) {
        var collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            if (Objects.equals(collection.get(key).getId(), id)) {
                return collection.get(key);
            }
        }
        System.out.println("Объекта с таким id не существует!");
        return null;
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

    public boolean checkParameterExist(Integer parameter) {
        return parameter == null;
    }

    public void isNull(String str, String field) throws NullPointerException {
        if (str.equals("")) {
            throw new NullPointerException("Поле " + field + " не может быть null!");
        }
    }

    public void isPositive(Double value, String field) throws FalseValuesException {
        if (value <= 0) {
            throw new FalseValuesException("Поле " + field + " должно быть положительным");
        }
    }

    public void isPositive(Integer value, String field) throws FalseValuesException {
        if (value <= 0) {
            throw new FalseValuesException("Поле " + field + " должно быть положительным");
        }
    }

    public Double isDouble(String value, String field) throws NumberFormatException {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Значение " + field + " должно быть типа double!");
        }
    }

    public Integer isInteger(String value, String field) throws NumberFormatException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Значение " + field + " должно быть типа int!");
        }
    }

    public Long isLong(String value, String field) throws NumberFormatException {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Значение " + field + " должно быть типа long!");
        }
    }

    public void isInfinite(Double value, String field) throws InfiniteException {
        if (value.isInfinite()) {
            throw new InfiniteException("Введено слишком большое значение, переполнение поля " + field + " !");
        }
    }

    public String emptyToZero(String value) {
        if (value.equals("")) {
            value = "0";
        }
        return value;
    }

    public String emptyToNull(String value) {
        if (value.equals("")) {
            value = null;
        }
        return value;
    }

    public void isGreater(Integer value, Integer number, String field) throws FalseTypeException {
        if (value <= number) {
            throw new FalseTypeException(field + " должен быть > " + number);
        }
    }

    public void isLower(Integer value, Integer number, String field) throws FalseTypeException {
        if (value >= number) {
            throw new FalseTypeException(field + " должен быть < " + number);
        }
    }

    public void isGreater(Long value, Long number, String field) throws FalseTypeException {
        if (value <= number) {
            throw new FalseTypeException(field + " должен быть > " + number);
        }
    }

    public void isLower(Long value, Long number, String field) throws FalseTypeException {
        if (value >= number) {
            throw new FalseTypeException(field + " должен быть < " + number);
        }
    }

    public void isGreater(Double value, Double number, String field) throws FalseTypeException {
        if (value <= number) {
            throw new FalseTypeException(field + " должен быть > " + number);
        }
    }

    public void isLower(Double value, Double number, String field) throws FalseTypeException {
        if (value >= number) {
            throw new FalseTypeException(field + " должен быть < " + number);
        }
    }

    public void isStringShort(String value, int number, String field) throws FalseValuesException {
        if (value.length() >= number) {
            throw new FalseValuesException("Длина " + field + " должна быть < " + number);
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
