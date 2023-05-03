package client;

import common.exception.ExitException;
import common.exception.FalseTypeException;
import common.exception.FalseValuesException;
import common.product.Product;

import java.io.IOException;

public abstract class ClientCommand {
    private Product product;
    public abstract void execute(String value) throws ExitException, FalseValuesException, NumberFormatException, IOException, FalseTypeException;
    
    public Product getProduct() {
        return product;
    }
}