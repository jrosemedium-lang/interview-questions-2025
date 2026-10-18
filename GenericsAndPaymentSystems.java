package JavaCodingExamplePkg;

interface PaymentMethod {
	public void pay();
}


abstract class PaymentSystem<T> {
	abstract public void getPayment(T paymentMethodInstance);
}

class CreditCardPayment implements PaymentMethod{
	String type = "CreditCardPayment";
	@Override
	public void pay() {
		System.out.println(type + " pays");
	}
}


class UPIPayment implements PaymentMethod{
	String type = "UPIPayment";
	@Override
	public void pay() {
		System.out.println(type + " pays");
	}
}

class PayPalPayment implements PaymentMethod{
	String type = "PayPalPayment";
	@Override
	public void pay() {
		System.out.println(type + " pays");
	}
}

class PaymentSystemImpl<U extends PaymentMethod> extends PaymentSystem<U>{

	@Override
	public void getPayment(U paymentMethodInstance) {
		paymentMethodInstance.pay();
	}


}


public class GenericsAndPaymentSystems {
	public static void main(String[] args) {
		new PaymentSystemImpl<PayPalPayment>().getPayment(new PayPalPayment());
	} 
}
