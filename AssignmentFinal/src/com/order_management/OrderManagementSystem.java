package com.order_management;

import java.util.Scanner;

//import com.order_management.orderManagement;

public class OrderManagementSystem {

	public static void main(String[] args) {
		
		Methods object = new Methods();
	//	readOrder.readOrders();
		
		while(true) 
		{
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
			int choose =0;
			Scanner scan = new Scanner(System.in);
			
			 choose = scan.nextInt();
			 
		
			
			switch(choose) 
			{
				
				case 1:
					
					object.Add_order();
				
				    break;
				case 2:
					object.getOrderListPrint();
					break;
				case 3:
					int flag = 1;
					int obj = 0;
					String id ="";
					while(flag == 1) {
						
						System.out.println("Enter the Order id ");
						 id = scan.next();
						obj = object.ViewOrderList(id);
					if(obj ==1) {
						id ="";
						continue;
					}else
					{
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
				case 8:
					GenerateReportUsingMultiThread thread = new GenerateReportUsingMultiThread();
					thread.run();
					break;
				case 9:
					System.out.println("Updating Current Order Details.........");
						System.out.println("Exiting the Program.....");
					
						System.exit(0);
				default:
					System.out.println("Please select the valid Option");
					
		   }
		}catch(Exception e) {
			System.out.println("Please select the valid Option");
			continue;
			//e.printStackTrace();
		}
			
	   }
    
	}

}
