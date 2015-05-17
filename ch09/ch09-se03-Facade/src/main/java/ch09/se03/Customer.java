package ch09.se03;

public class Customer {
	public void haveDinner() {
		// // 依次创建三个部门实例
		// Payment pay = new PaymentImpl();
		// Cook cook = new CookImpl();
		// Waiter waiter = new WaiterImpl();
		// // 依次调用三个部门实例的方法来实现用餐功能
		// String food = pay.pay();
		// food = cook.cook(food);
		// waiter.serve(food);
		// 直接依赖于Facade类来实现用餐方法
		Facade f = new Facade();
		f.serveFood();
	}

	public static void main(String[] args) {
		new Customer().haveDinner();
	}
}