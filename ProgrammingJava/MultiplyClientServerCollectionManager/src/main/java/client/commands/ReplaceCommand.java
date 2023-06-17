package client.commands;

import client.ClientCommand;
import client.ClientValidator;
import client.builder.Director;
import client.builder.ProductBuilder;
import common.exception.FalseTypeException;
import common.product.Product;
import common.exception.ExitException;

import java.io.IOException;

public class ReplaceCommand extends ClientCommand {
	private final ClientValidator validator = new ClientValidator();
	private Product product;
	public ReplaceCommand() {
	}
	
	/**
	 *
	 * @param value  id of the element being changed
	 */
	public void execute(String value) throws ExitException {
		try {
			var product = new Director(new ProductBuilder()).make();
			setProduct(product);
		} catch (NumberFormatException exception){
			System.out.println("Этой команде необходимо передать параметр типа int!");
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return this.product;
	}
}