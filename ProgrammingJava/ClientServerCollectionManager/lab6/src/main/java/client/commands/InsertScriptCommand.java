package client.commands;

import client.ClientValidator;
import common.product.*;
import server.MainCollection;
import common.exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;

public class InsertScriptCommand {
    private final BufferedReader reader;

    public InsertScriptCommand(BufferedReader reader) {
        this.reader = reader;
    }

    public final ClientValidator validator = new ClientValidator();

    public void execute(String value) throws FalseValuesException, FalseTypeException, NullPointerException, IllegalArgumentException, IOException, InfiniteException, UniqueException, NullStringException {
        var id = validator.checkParamType(value);

        var product = new Product();
        String str;

//        validator.idCheck(id);
        product.setId(id);

        str = newString();
        validator.isNull(str, "Name");
        product.setName(str);

        product.setCoordinates(setCoordinates());

        product.setCreationDate(ZonedDateTime.now().toString());

        var price = newString();
        validator.isNull(price, "Price");
        var Price = validator.isDouble(price, "Price");
        validator.isInfinite(Price, "Price");
        validator.isPositive(Price, "Price");
        product.setPrice(Price);

        str = newString();
        validator.isNull(str, "PartNumber");
        validator.isStringShort(str, 83, "PartNumber");
        product.setPartNumber(str);

        str = newString();
        str = validator.emptyToZero(str);
        product.setManufactureCost(validator.isInteger(str, "ManufactureCost"));

        str = newString();
        validator.isNull(str, "UnitOfMeasure");
        product.setUnitOfMeasure(UnitOfMeasure.valueOf(str));

        product.setManufacturer(setOrganization());

        var collection = MainCollection.getCollection();
        collection.put(id, product);
//        validator.checkUnique(collection);
        MainCollection.setCollection(collection);
    }

    public Coordinates setCoordinates() throws IOException, FalseTypeException, NumberFormatException, NullPointerException, NullStringException {
        var coordinates = new Coordinates();

        var x = newString();
        x = validator.emptyToZero(x);
        var X = validator.isInteger(x, "X");
        validator.isGreater(X, -230, "X");
        coordinates.setX(X);

        var y = newString();
        validator.isNull(y, "Y");
        var Y = validator.isLong(y, "Y");
        validator.isLower(Y, 703L, "Y");
        coordinates.setY(Y);
        return coordinates;
    }

    public Organization setOrganization() throws IOException, FalseValuesException, NullStringException {
        Organization organization = new Organization();

        organization.setId(getRandomId());

        var name = newString();
        validator.isNull(name, "OrganizationName");
        organization.setName(name);

        var fullname = newString();
        validator.isStringShort(fullname, 1267, "FullName");
        fullname = validator.emptyToNull(fullname);
        organization.setFullName(fullname);

        var str = newString();
        validator.isNull(str, "AnnualTurnover");
        var annualTurnover = validator.isInteger(str, "AnnualTurnover");
        validator.isPositive(annualTurnover, "AnnualTurnover");
        organization.setAnnualTurnover(annualTurnover);

        str = newString();
        validator.isNull(str, "EmployessCount");
        var employessCount = validator.isInteger(str, "EmployessCount");
        validator.isPositive(employessCount, "EmployessCount");
        organization.setEmployeesCount(employessCount);

        var organizationType = newString();
        validator.isNull(organizationType, "OrganizationType");
        organization.setType(OrganizationType.valueOf(organizationType));

        return organization;
    }

    public String newString() throws IOException, NullStringException {
        try {
            return reader.readLine().strip();
        } catch (NullPointerException exception) {
            throw new NullStringException("Пропущены поля для создания нового объекта!");
        }
    }

    public Integer getRandomId() {
        return (int) (Math.random() * 1000 + 1);
    }
}

