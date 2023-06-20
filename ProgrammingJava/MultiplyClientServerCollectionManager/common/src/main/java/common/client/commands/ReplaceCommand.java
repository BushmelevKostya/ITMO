package common.client.commands;

import common.client.ClientCommand;
import common.client.ClientValidator;
import common.client.builder.Director;
import common.client.builder.ProductBuilder;
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