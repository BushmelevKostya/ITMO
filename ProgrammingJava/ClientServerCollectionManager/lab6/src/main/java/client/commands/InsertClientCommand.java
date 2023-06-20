package client.commands;

import client.ClientCommand;
import client.ClientValidator;
import client.builder.Director;
import client.builder.ProductBuilder;
import common.exception.FalseTypeException;
import common.exception.FalseValuesException;
import common.product.Product;
import common.exception.ExitException;

import java.io.IOException;

/**
 * Add new element to collection
 *
 * @see ProductBuilder
 */
public class InsertClientCommand extends ClientCommand {
	private Product product;
	private final ClientValidator validator = new ClientValidator();
	
	public InsertClientCommand() {
	}
	
	/**
	 * @param value this id is key of new collection's element
	 */
	@Override
	public void execute(String value) throws ExitException, FalseValuesException, NumberFormatException, IOException, FalseTypeException {
		var id = validator.checkParamType(value);
		validator.isPositive(id, "Id");
		Product newProduct = new Director(new ProductBuilder(id)).make();
		setProduct(newProduct);
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
}