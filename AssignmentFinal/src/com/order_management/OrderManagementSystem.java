package com.order_management;

import java.util.Scanner;

import com.order_management.Test.Test1;
import com.order_management.Test.Test2;
//import com.order_management.Test.Test2.Test3;
//import com.order_management.Test.Test2.Test3.Test4;
//import com.order_management.Test.Test2.Test3.Test5;
//import com.order_management.Test.Test1.Test2;
//import com.order_management.Test.Test1.Test2.Test3;
//import com.order_management.Test.Test2.Test3.Test5.Test6;
import com.order_management.Test.Test7;


public class OrderManagementSystem implements OrderManagement {

	public static void main(String[] args) {
		//Test t1 = new Test();

		Methods object = new Methods();
		// readOrder.readOrders();

		while (true) {
			System.out.println("Menu :");
			System.out.println();
			System.out.println("*************Order Management System************");

			System.out.println("              1.)Add Order ");
			System.out.println("              2.)View Order List  ");
			System.out.println("              3.)View By Order Id  ");
			System.out.println("              4.)Sort Order  ");
			System.out.println("              5.)Delete Order by Id  ");
			System.out.println("              6.)Mark as Delivered.  ");
			System.out.println("              7.)Cancel Order ");
			System.out.println("              8.)Generate Report.  ");
			System.out.println("              9.)Exit ");
			System.out.println("Choose Option");
			try {
				int choose = 0;
				Scanner scan = new Scanner(System.in);

				choose = scan.nextInt();

				switch (choose) {

				case 1:

					object.addOrder();

					break;
				case 2:
					//object.ViewOrderList();
					object.getOrderListPrint();
					break;
				case 3:
					int flag = 1;
					int obj = 0;
					String id = "";
					while (flag == 1) {

						System.out.println("Enter the Order id ");
						id = scan.next();
						obj = object.ViewOrderList(id);
						if (obj == 1) {
							id = "";
							continue;
						} else {
							break;
						}
					}
					break;

				case 4:
					object.sortOrder();
					break;
				case 5:
					object.DeleteById();
					break;
				case 6:
					object.MarkAsDel();
					break;
				case 7:
					object.CancleById();
					break;
				case 8:System.out.println("choose 1 or 2");
				int flag2 = 1;
			outer :	while(flag2 ==1) {
				int flag1 =1;
				int option = 0;
				inner: while (flag1 == 1) 
					try {
						option = scan.nextInt();
						break inner;
					} catch (Exception e) {
						System.out.println("choose valid option");
//		e.printStackTrace();;
						scan.nextLine();
						continue outer;
					}
				if (option < 1 || option > 2) {
					System.out.println("please enter the valid option");
					
				}
				
					//int number = scan.nextInt();
					switch(option) {
					case 1 : Test allReport = new Test();
					allReport.start();
						Test1 threadAll2= allReport.new Test1();
						threadAll2.start();
						flag2=0;
					break;
					case 2 : System.out.println("******** Choose Status********* ");
					System.out.println("         1).InProgress			");
					System.out.println("         2).Delivered 			");
					System.out.println("         3).Cancelled		    ");
					int choice = scan.nextInt();
					switch(choice) {
						
					case 1:	Test threadObject = new Test();
							com.order_management.Test.Test2 thread2 = threadObject.new Test2();
							thread2.start();
							com.order_management.Test.Test3 thread3 = threadObject.new Test3();
							thread3.start();
							break;
					case 2: 
						Test  deivered= new Test();
						com.order_management.Test.Test4 thread4= deivered.new Test4();
						thread4.start();
						com.order_management.Test.Test5 thread5 = deivered.new Test5();
						thread5.start();
						break;
					case 3: 
						Test  cancelled= new Test();
						com.order_management.Test.Test6 thread6= cancelled.new Test6();
						thread6.start();
						com.order_management.Test.Test7 thread7 = cancelled.new Test7();
						thread7.start();
						break;
							
					}
					}
					flag2 =0;
			}
					break;
				case 9:
					System.out.println("Updating Current Order Details.........");
					System.out.println("Exiting the Program.....");

					System.exit(0);
				default:
					System.out.println("Please select the valid Option");

				}
			} catch (Exception e) {
				System.out.println("Please select the valid Option");
				continue;
				// e.printStackTrace();
			}

		}

	}

}
