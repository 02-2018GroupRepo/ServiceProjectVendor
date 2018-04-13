package bootcamp.model.invoice;

import bootcamp.model.products.Product;
import bootcamp.service.InvoiceService;
import java.math.BigDecimal;
import java.util.List;

public class Payment {

	private double paymentForProduct;
	private int invoiceId;

	public Payment(double paymentForProduct, int invoiceId) {
		this.paymentForProduct = paymentForProduct;
		this.invoiceId = invoiceId;
	}

	public Payment() {
	}

	public Payment(double total) {
	}

	public double getPaymentForProduct() {
		return paymentForProduct;
	}

	public void setPaymentForProduct(double paymentForProduct) {
		this.paymentForProduct = paymentForProduct;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

}
